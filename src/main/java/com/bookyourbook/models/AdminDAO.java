package com.bookyourbook.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="admins")
public class AdminDAO extends AccountDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454147127959338798L;

}
