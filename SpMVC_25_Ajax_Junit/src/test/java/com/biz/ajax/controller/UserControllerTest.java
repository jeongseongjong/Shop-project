package com.biz.ajax.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.biz.ajax.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class UserControllerTest {

	/*
	 * 사용자 정의 DI 컨테이너 모드
	 * 단독모드
	 * 스프링 MVC의 설정을 적용한 DI 컨테이너를 만들어 이 DI 컨테이너를 사용해
	 * 스프링 MVC 동작 재현 애플리케이션 서버에 배포한 것과 같은 것 처럼 테스트 가능 
	 */
	private MockMvc mockMvc;
	
	// 테스트 대상 컨트롤러 지정
	@InjectMocks
	private UserController userController;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(userController)
				.build();
	}

	@Test
	public void testSaveUser() throws Exception {
		
		UserVO userVO = new UserVO();
		
		/*
		 * saveUser를 POST방식으로 호출하면서
		 * 4개의 requesParam 데이터를 주입하고
		 * 결과가 200인지 검사하고
		 * 최종적으로 model에 담겨서 리턴되는 값이 userVO냐?
		 */
		// 실행할 컨트롤러의 mapping을 지정
		mockMvc.perform(post("/saveUser")
				// 값을 넣어줄 VO의 변수지정
			.param("userId",userVO.sampleVO().getUserId())
			.param("password",userVO.sampleVO().getPassword())
			.param("userName",userVO.sampleVO().getUserName())
			.param("rolle",userVO.sampleVO().getRolle())
				
			).andExpect(status().isOk())
			// 매핑된 컨트롤러에서 userVO라는 ModelAttribute로 보내주는것이 있어야 한다.
			.andExpect(model().attributeExists("userVO"))
			.andReturn();
	}

	public void sendUserIdTest() throws Exception {
		mockMvc.perform(post("/sendUserId")
				.param("userId", "admin")
				.param("password", "1234")
				.param("userName", "Hong")
				.param("rolle", "admin")
		)
		.andExpect(status().isOk())
		// controller의 매핑된곳에서도 명확하게 type이 지정되어있어야 한다.
		.andExpect(content().contentType("application/json;charset=UTF-8"))// .APPLICATION_JSON))
		// userVO의 userId가 존재한다.
		.andExpect(jsonPath("$.userVO.userId").exists())
		// userId가 admin이 맞느냐 ? 체크하는 코드
		.andExpect(jsonPath("$.userVO.userId", is("admin")))
		.andExpect(jsonPath("$.userVO.password").exists())
		.andExpect(jsonPath("$.userVO.password", is("1234")))
		.andExpect(jsonPath("$.userVO.userName").exists())
		.andExpect(jsonPath("$.userVO.rolle").exists());
		
		
	}
}
