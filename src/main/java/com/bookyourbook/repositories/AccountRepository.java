package com.bookyourbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookyourbook.models.AccountDAO;


@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Long> {

	AccountDAO findByUsername(String username);
	
	AccountDAO findByEmail(String email);
	
}
