package com.biz.ajax.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class BookControllerTest {

	MockMvc mockMvc;
	
	@InjectMocks
	BookController bookcontroller;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookcontroller).build();
	}

	@Test
	public void testInsertBad() throws Exception {
		
		/*
		 * book/insert를 호출하면서
		 * 도서가격을 숫자형 문자열이 아닌 빈값을 전달했다
		 * 이때 controller는 응답코드로 400오류를 보낸다.
		 * 
		 * 테스트를 수행하면서 잘못된 값을 전달하면
		 * 잘못되었다는 오류를 보여주는지 테스트 하는 코드
		 */
		mockMvc.perform(post("/book/insert")
				.param("b_title","자바야 놀자")
				.param("b_comp","길벗")
				.param("b_price","")
				)
		.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
		// .andExpect(status().isOk());
		
	}
	
	@Test
	public void testInsertok() throws Exception {
		
		/*
		 * book/insert를 호출하면서
		 * 도서가격을 숫자형 문자열이 아닌 빈값을 전달했다
		 * 이때 controller는 응답코드로 400오류를 보낸다.
		 * 
		 * 테스트를 수행하면서 잘못된 값을 전달하면
		 * 잘못되었다는 오류를 보여주는지 테스트 하는 코드
		 */
		mockMvc.perform(post("/book/insert")
				.param("b_title","자바야 놀자")
				.param("b_comp","길벗")
				.param("b_price","")
				)
		//.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
		.andExpect(status().isOk());
		
	}

}
