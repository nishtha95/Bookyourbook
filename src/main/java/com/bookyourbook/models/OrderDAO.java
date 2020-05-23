package com.bookyourbook.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="orders")
public class OrderDAO extends AuditableDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6532083352362055273L;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
	private Set<OrderItemDAO> orderItem=new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
	private UserDAO user;
}
