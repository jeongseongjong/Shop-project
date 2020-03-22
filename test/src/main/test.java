package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		List<String> test = new ArrayList<>();

		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

		LocalDateTime a = LocalDateTime.of(2014, 3, 01, 03, 22, 30);
		LocalDateTime b = LocalDateTime.of(2014, 3, 01, 03, 22, 10);

		DateTimeFormatter aFor = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter bFor = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String aTime = a.format(aFor);
		String bTime = b.format(bFor);

		test.add(aTime);
		test.add(bTime);

		SimpleDateFormat a_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date aaTime = a_time.parse(test.get(Integer.valueOf(aTime)));
		SimpleDateFormat b_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date bbTime = b_time.parse(test.get(Integer.valueOf(bTime)));

		long a_b = aaTime.getTime() + bbTime.getTime();

		long sec = a_b / 1000;

		// 시간 = 초 / 3600
		long hour = sec / 3600;
		long minute = sec / 60;

		// long to String 하기위해 format해준다.
		String form = String.format("0%d:0%d:0%d", hour, minute, sec);

		System.out.println(form);

	}

}
