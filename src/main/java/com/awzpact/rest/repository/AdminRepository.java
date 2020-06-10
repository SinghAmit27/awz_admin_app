package com.awzpact.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.awzpact.rest.model.Admin;
import com.awzpact.rest.response.ApiResponse;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("from Admin where lower(adminEmail)=lower(:email) and lower(adminPassword)=lower(:password)" )
	public Admin loginByEmailPwd(@Param("email") String email, @Param("password") String password);
	
	
	public Admin findByadminEmail(String email);
	
}
