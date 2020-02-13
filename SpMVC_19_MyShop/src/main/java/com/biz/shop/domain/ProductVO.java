package com.biz.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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

@Entity
@Table(name="tbl_product", schema = "emsDB")
public class ProductVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long p_id;
	
	// jsp의 path가 name과 같다.
	@Column(name="p_code",length = 13)
	private String p_code;
	
	@Column(name="p_name")
	private String p_name;
	
	@Column(name="p_bcode",length = 5)
	private String p_bcode;
	
	@Column(name="p_dcode",length = 5)
	private String p_dcode;
	
	@Column(name="p_iprice")
	private int p_iprice;
	
	@Column(name="p_oprice")
	private int p_oprice;
	
	@Column(name="p_detail")
	@Type( type = "text")
	private String p_detail;
}
