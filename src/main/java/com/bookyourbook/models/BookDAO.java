package com.bookyourbook.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="books")
public class BookDAO extends AuditableDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2304160417505194407L;
	
	@NotBlank
	@Getter
	@Setter
	private String title;
	
	@NotBlank
	@Getter
	@Setter
	private String isbn;
	
	@NotBlank
	@Getter
	@Setter
	private Double price;
	
	@NotBlank
	@Getter
	@Setter
	private Integer quantity;
	
	@Getter
	@Setter
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = { CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "book_author",
    joinColumns = { @JoinColumn(name = "book_id") },
    inverseJoinColumns = { @JoinColumn(name = "author_id") })
	private Set<AuthorDAO> authors = new HashSet<>();
	
	
}
