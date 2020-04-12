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
public class SubjectVO {

	private String kor;
	private String Eeg;
	private String math;
	private String science;
	private String history;
	
}
