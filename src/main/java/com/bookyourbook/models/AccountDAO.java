package com.bookyourbook.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AccountDAO extends AuditableDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1042777312615696635L;

	@NotBlank
	@Getter
	@Setter
	protected String firstName;
	
	@NotBlank
	@Getter
	@Setter
	protected String lastName;
	
	@Email @NotBlank
	@Column(unique = true)
	@Getter
	@Setter
	protected String email;

	@NotBlank
	@Getter
	@Setter
	protected String username;
	
	@NotBlank
	@Getter
	@Setter
	protected String saltedHashedPassword;
	
	@Getter
	@Setter
	@NotNull
	@Enumerated(EnumType.STRING)
    @Column(length = 10)
	protected Role role;

}
