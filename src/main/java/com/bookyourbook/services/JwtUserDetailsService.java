package com.bookyourbook.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookyourbook.dtos.UserDTO;
import com.bookyourbook.exception.BookYourBookException;
import com.bookyourbook.models.AccountDAO;
import com.bookyourbook.models.AdminDAO;
import com.bookyourbook.models.Role;
import com.bookyourbook.models.UserDAO;
import com.bookyourbook.repositories.AccountRepository;
import com.bookyourbook.repositories.AdminRepository;
import com.bookyourbook.repositories.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountDAO account = accountRepository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("Account doesn't exist for this username");
		}
		return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getSaltedHashedPassword(),
				new ArrayList<>());
	}
	
	public UserDAO save(UserDTO user) throws BookYourBookException {
		AccountDAO account=accountRepository.findByUsername(user.getUsername());
		if(account!=null){
			throw new BookYourBookException("Account already exists with this username");
		}
		account= accountRepository.findByEmail(user.getEmail());
		if(account!=null){
			throw new BookYourBookException("Account already exists with this email id");
		}
		UserDAO newUser=new UserDAO();
		newUser.setFirstName(user.getFirstname());
		newUser.setLastName(user.getLastname());
		newUser.setUsername(user.getUsername());
		newUser.setSaltedHashedPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAddress(user.getAddress());
		newUser.setContact(user.getContact());
		newUser.setEmail(user.getEmail());
		newUser.setRole(Role.USER);
		return userRepository.save(newUser);
	}
	
	public AdminDAO saveAdmin(UserDTO user) throws BookYourBookException {
		AccountDAO account=accountRepository.findByUsername(user.getUsername());
		if(account!=null){
			throw new BookYourBookException("Account already exists with this username");
		}
		account= accountRepository.findByEmail(user.getEmail());
		if(account!=null){
			throw new BookYourBookException("Account already exists with this email id");
		}
		AdminDAO admin=new AdminDAO();
		admin.setFirstName(user.getFirstname());
		admin.setLastName(user.getLastname());
		admin.setUsername(user.getUsername());
		admin.setSaltedHashedPassword(bcryptEncoder.encode(user.getPassword()));
		admin.setEmail(user.getEmail());
		admin.setRole(Role.ADMIN);
		return adminRepository.save(admin);
	}
	public String getRoleByUserName(String username) {
		return accountRepository.findByUsername(username).getRole().name();
	}
	
}