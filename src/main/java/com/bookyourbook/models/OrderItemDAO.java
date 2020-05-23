package com.bookyourbook.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="order_items")
public class OrderItemDAO extends AuditableDAO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7765878797572025031L;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnore
	private BookDAO book;

	@Getter
	@Setter
	private Integer quantity;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
    @Column(length = 10)
	private Status status;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
	private OrderDAO order;
}
