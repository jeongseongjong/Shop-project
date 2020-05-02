package com.biz.movie.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.movie.config.NaverConfig;
import com.biz.movie.domain.PageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieService {

	private final String naver_movie_url = "https://openapi.naver.com/v1/search/movie.json";

	@Autowired
	PageService pService;

	public PageDTO getPage(String cat, String search, long currentPageNo) throws IOException, ParseException {

		// 전체 데이터 계산
		String totalQuery = this.queryMovie(cat, search);
		String totalString = this.getMovieString(totalQuery);
		JSONObject totalJObject = this.strToJson(totalString);

		// JSONOBJECT에서 key가 total인 항목을 찾아서 값을 문자열로 추출
		String strTotal = totalJObject.get("total").toString();
		long totalCount = Long.valueOf(strTotal);
		if (totalCount > 1000) {
			totalCount = 1000;
		}

		PageDTO pageDTO = pService.makePagination(totalCount, currentPageNo);

		log.debug("전체개수 : " + totalCount);

		return pageDTO;
	}

	public JSONArray getMovie(String cat, String search, long currentPageNo) throws ParseException, IOException {

		PageDTO pageDTO = this.getPage(cat, search, currentPageNo);

		if (currentPageNo == 1) {
			currentPageNo = 1;
		} else {
			// 현재페이지 = (현재페이지번호 -1 ) * 한페이지에 보여질 리스트개수
			currentPageNo = (currentPageNo - 1) * pageDTO.getListPerPage();
		}

		String queryString = this.queryMovie(cat, search, currentPageNo, pageDTO.getListPerPage());

		String resString = this.getMovieString(queryString);

		JSONObject resObject = this.strToJson(resString);

		JSONArray resArray = this.getArray(resObject, "items");

		return resArray;
	}

	// search, start, display 값을 매개변수로 받아서
	// start부터 display개수만큼 데이터를 가져오기 위한 queryString 생성
	public String queryMovie(String cat, String search) throws UnsupportedEncodingException {
		
		String queryString = URLEncoder.encode(search, "UTF-8");
		queryString = this.queryURL(cat) + "?query=" + queryString;
		
		return queryString;
	}
	
	public String queryMovie(String cat, String search, long start, long display) throws UnsupportedEncodingException {
		
		String queryString = URLEncoder.encode(search, "UTF-8");
		queryString = this.queryURL(cat) + "?query=" + queryString;
		
		// start와 display값을 query에 포함하면
		// start부터 display 개수만큼 데이터를 보내라는 의미
		queryString += "&start=" + start;
		queryString += "&display=" + display;
		return queryString;
	}
	
	public String getMovieString(String queryString) throws IOException {
		
		URL url = new URL(queryString);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverConfig.NaverClientId);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverConfig.NaverClientSecret);
		
		int resCode = httpConn.getResponseCode();
		
		BufferedReader buffer = null;
		if(resCode == 200) {
			
			InputStreamReader is = new InputStreamReader(httpConn.getInputStream());
			buffer = new BufferedReader(is);
		}else {
			InputStreamReader is = new InputStreamReader(httpConn.getErrorStream());
			buffer = new BufferedReader(is);
		}
		
		// String resString = "";
		StringBuffer resString = new StringBuffer();
		String reader = "";
		while(true) {
			reader = buffer.readLine();
			if(reader == null)break;
			resString.append(reader);
		}
		
		// 디버깅을 위한 코드
		if(resCode == 200) {
			return  resString.toString();
		}else {
			
			log.debug("네이버 오류" + resString.toString());
		}
		
		return null;
		
	}
	
	// 문자열을 JSONOject로 변환
	// 네이버에서 response(수신)한 문자열을 통째로 JSON Object로 변환
	public JSONObject strToJson(String jsonString) throws ParseException {
		
		JSONParser jParser = new JSONParser();
		JSONObject jObject = (JSONObject) jParser.parse(jsonString);
		
		return jObject;
	}
	
	// JSONObject로 부터 Naver의 items만 추출하여
	// JSON Array로 변환
	// naver로부터 받은 데이터에서 items 항목을 추출하여
	// 실제 데이터들을 array로 만들어 주는 메소드
	public JSONArray getArray(JSONObject jObject, String keyString) {
		
		return (JSONArray) jObject.get(keyString);
	}
	
	public String queryURL(String cat) {
		String queryURL = naver_movie_url;
		if(cat.equalsIgnoreCase("MOVIE")) {
			queryURL = naver_movie_url;
		}
		return queryURL;
	}
}
