package com.biz.bucket.domain;

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
public class BucketVO {
	
	private long b_id; // number no
	private String b_subject; // nvarchar2(125 char) no
	private String b_content; // nvarchar2(1000 char) no
	private long b_complete;
	private String b_impression; // nvarchar2(1000 char) yes
}
