package main;

public class test1 {

	public String solution(String[] seoul) {
		String answer = "";

		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				answer = "김서방은" + i + "에 있다.";
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		test1 s = new test1();
		String[] names = {"Queen", "Tod","Kim"};
		
		System.out.println(s.solution(names));

	}

}