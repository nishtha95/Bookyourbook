package com.bookyourbook.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="authors")
public class AuthorDAO extends AuditableDAO{

	@NotNull
	@Getter
	@Setter
	private String Name;
	
	@Getter
	@Setter
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = { CascadeType.PERSIST,CascadeType.MERGE},
    mappedBy = "authors")
	private Set<BookDAO> books = new HashSet<>();
	
}
