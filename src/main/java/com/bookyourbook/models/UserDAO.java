package com.bookyourbook.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="users")
public class UserDAO extends AccountDAO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1064018891857798009L;

	@NotBlank
	@Getter
	@Setter
	private String address;
	
	@NotBlank
	@Getter
	@Setter
	private String contact;

}
