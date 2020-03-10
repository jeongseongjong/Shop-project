package com.biz.bbs;

public class Main3 {

	public static void main(String[] args) {
		
		int sum = add(10);
		System.out.println(sum);
	}
	
	/*
	 * 최초에 add(10)이 main에서 호출
	 * 		num 값은 10이 되고
	 * 		if 문을 건너 뛰게되고
	 * 		10 + add()의 return값을 덧셈
	 */
	public static int add(int num) {
		
		
		if(num < 1) {
			
			return 0;
		}else {
			
			// add가 자기 자신의 메소드 이기때문에
			// num(10) + add (10-1) 을 실행 했을때
			// 10 + 9가 아닌 10 + ( num + add(num-1))이 된다.
			return num + add(num -1);
		}
	}
}
