package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

/*
 * summernote에서 dragAnddrop으로 이미지파일을 업로드 하면
 * 일단 서버에 파일을 업로드하고
 * 파일 이름을 다시 내려보내서 base64로 encoding된 파일 정보를
 * img src="저장된경로/파일이름" 형식으로 변경한다.
 */
@Service
@RequiredArgsConstructor
public class FileService {

	// servlet-context.xml에 설정된 파일 저장경로 정보를
	// 가져와서 사용하기
	private final String filePath;
	
	/*
	 * 브라우저에서 파일이 전송되어 오면
	 * 원래 파일이름을 UUID 부착된 파일이름을 변경
	 * 변경된 이름으로 서버의 filePath에 저장하고
	 * 변경된 파일이름을 return
	 */
	public String fileUp(MultipartFile upFile) {
		
		//파일이름을 추출(그림.jpg)
		String originalFileName = upFile.getOriginalFilename();
		
		// UUID(36자의 유일한수)가 부착된 새로운 이름을 생성
		String strUUID = UUID.randomUUID().toString();
		
		// UUID(유일한수)와 파일이름을 결합
		strUUID += originalFileName; // UUID그림.JPG
		
		// 파일을 저장할 경로와 변경된 파일이름을 결합하여
		// File객체를 생성
		File serverFile = new File(filePath,strUUID);
		
		// upload할 filePath가 잇는지 확인을 하고
		// 없으면 폴더를 생성
		File dir = new File(filePath);
		
		if(!dir.exists()) {
			
			dir.mkdirs();
		}
		
		// upFile을 serverFile 이름으로 복사 수행
		// transferTo
		// 지정해놓은 filePath(경로)에 저장하는 메소드
		try {
			upFile.transferTo(serverFile);
			
			return strUUID;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
