package com.biz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biz.shop.domain.Authorities;
import com.biz.shop.domain.Users;

@Repository
public interface AuthDao extends JpaRepository<Authorities, String>{


	
}
