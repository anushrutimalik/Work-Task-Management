package com.example.demo.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Userdto;
import com.example.demo.models.Role;
import com.example.demo.models.UserEntity;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServices {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${application.hr.email}")
	private String hrEmail;
	
	@Value("${application.hr.password}")
	private String hrPassword;
	
	/*
	 * public boolean isValidCredentials(String email,String password) {
	 * if(hrEmail.equals(email) && hrPassword.equals(password)) { return true; }
	 * else return false; }
	 */

	public UserEntity createUser(Userdto userdto) {
//		Optional<UserEntity> existingUser = userRepository.findByEmail(userdto.getEmail());
//		
		Role role =roleRepository.findByRolename(userdto.getRole()).orElseThrow(()-> new RuntimeException("Not Found"));
		
		UserEntity saveuser = new UserEntity();
		saveuser.setEmail(userdto.getEmail());
		saveuser.setFullname(userdto.getFullname());
		saveuser.setContact(userdto.getContact());
		saveuser.setPassword(passwordEncoder.encode(userdto.getPassword()));
		saveuser.setRole(role);
		
		
		
		return userRepository.save(saveuser);
	}
	
}
