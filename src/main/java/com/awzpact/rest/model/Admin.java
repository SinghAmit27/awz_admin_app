package com.awzpact.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

@Entity
@Table(name="admin")
public class Admin implements Serializable {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	private Integer adminId;
	@NonNull
	@Column(name="email")
	private String adminEmail;
	@NonNull
	@Column(name="password")
	private String adminPassword;
	@NonNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sId")
	private Integer serviceId;
	@NonNull
	@Column(name="service_name")
	private String serviceName;
	@NonNull
	@Column(name="service_type")
	private String serviceType;
	
	public Admin() {
		super();
	}

	public Admin(Integer adminId, String adminEmail, String adminPassword, Integer serviceId, String serviceName,
			String serviceType) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	
	
	

		

}
