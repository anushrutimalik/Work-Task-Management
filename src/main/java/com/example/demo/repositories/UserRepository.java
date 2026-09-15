package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Userdto;
import com.example.demo.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	
	Optional<UserEntity> findByEmail(String email);
	Optional<UserEntity> findByContact(String contact);
	Userdto save(Userdto userdt);

}
