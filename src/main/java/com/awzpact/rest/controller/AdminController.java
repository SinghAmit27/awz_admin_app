package com.awzpact.rest.controller;

import java.util.List;
import java.util.logging.ErrorManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awzpact.rest.exception.ApiException;
import com.awzpact.rest.model.Admin;
import com.awzpact.rest.response.ApiResponse;
import com.awzpact.rest.service.AdminService;
import com.awzpact.rest.util.ErrorMessage;
import com.awzpact.rest.util.ErrorMessage.MyMessage;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("getList")
	public List<Admin> getAdminList() {
		return adminService.getAdminList();
	}

	@PostMapping("login")
	public ApiResponse createVendor(@RequestBody Admin adminReq) {

		Admin adminLogin = null;

		if (adminReq.getAdminEmail().isEmpty()) {
			throw new ApiException(ErrorMessage.ERROR_EMAIL_EMPTY);
		}

		else if (adminReq.getAdminPassword().isEmpty()) {
			throw new ApiException(ErrorMessage.ERROR_PASSWORD_EMPTY);
		}

		else {

			Admin adminByEmail = adminService.findByEmail(adminReq);

			if (adminByEmail == null) {
				throw new ApiException(ErrorMessage.ERROR_USER_NOT_EXIST);
			}

			else if (adminByEmail != null) {

				adminLogin = adminService.adminLogin(adminReq);

				if (adminLogin == null) {
					throw new ApiException(ErrorMessage.ERROR_EMAIL_PWD_NO_MATCH);
				}

			}
		}

		return new ApiResponse(HttpStatus.OK.value(), MyMessage.MSG_LOGIN_SUCCESS, adminLogin);

	}

}
