package com.awzpact.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.awzpact.rest.model.Admin;
import com.awzpact.rest.repository.AdminRepository;
import com.awzpact.rest.response.ApiResponse;
import com.awzpact.rest.util.ErrorMessage;




@Service
public class AdminService {
	
	
	@Autowired
	private AdminRepository adminRepo;
	
	
	public List<Admin> getAdminList() {
		return adminRepo.findAll();
	}
	
	public Admin createAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin getAdminById(int id) {
		return adminRepo.findById(id).get();
	}
	
	public Admin adminLogin(Admin admin) {
		
		return adminRepo.loginByEmailPwd(admin.getAdminEmail(), admin.getAdminPassword());

	}
	
	public Admin findByEmail(Admin admin) {
			
		return adminRepo.findByadminEmail(admin.getAdminEmail());
	
	}
	
	
	public void deleteAdminById(int id) {
		adminRepo.deleteById(id);
	}
	
	public Admin updateVendor(Admin admin) {
		Admin existingAdmin = adminRepo.findById(admin.getAdminId()).orElse(null);
		existingAdmin.setAdminEmail(admin.getAdminEmail());
		return adminRepo.save(existingAdmin);
	}


}
