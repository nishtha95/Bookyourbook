package com.bookyourbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookyourbook.models.AdminDAO;

@Repository
public interface AdminRepository extends JpaRepository<AdminDAO, Long> {

	AdminDAO findByUsername(String username);
	
	AdminDAO findByEmail(String email);
	
}