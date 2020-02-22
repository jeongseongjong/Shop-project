package com.biz.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.shop.domain.ProductVO;

public interface ProductDao {

//	@Select("select * from tbl_product where p_name LIKE '%' || #{p_name} || '%' ")
	public List<ProductVO> findByPName(@Param("p_name")String p_name);
}
