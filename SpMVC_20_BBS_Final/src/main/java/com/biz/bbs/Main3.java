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
			
			return num + add(num -1);
		}
	}
}
