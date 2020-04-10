package com.biz.score.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentVO {

	private long st_id;
	private long st_num;
	private String st_name;
	private long st_grade;
	private long st_class;
	private ScoreVO scoreVO;
	
}
