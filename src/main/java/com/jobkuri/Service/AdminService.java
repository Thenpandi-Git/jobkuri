package com.jobkuri.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobkuri.DTO.AdminDTO;
import com.jobkuri.Entity.Admin;
import com.jobkuri.Repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	
	
	public Admin performanceAction(AdminDTO dto) {
		
		Admin admin = new Admin();
		admin.setAdminId(dto.getAdminId());
		admin.setUserId(dto.getUserId());
		admin.setAction(dto.getAction());
		admin.setTimeStamp(LocalDateTime.now());
		
		return adminRepo.save(admin);
		
	}
	
	public List<Admin>getActionsByAdmin(Long adminId){
		return adminRepo.findByAdminId(adminId);
	}
	
	public List<Admin>getActionsByUser(Long userId){
		return adminRepo.findByUserId(userId);
	}

}

