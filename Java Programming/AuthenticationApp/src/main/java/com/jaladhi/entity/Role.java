package com.jaladhi.entity;

import javax.persistence.*;

import com.jaladhi.util.RoleConstants;

@Entity
@Table(name = "ROLES")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleConstants name;

	public Role() {

	}

	public Role(RoleConstants name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleConstants getName() {
		return name;
	}

	public void setName(RoleConstants name) {
		this.name = name;
	}
}