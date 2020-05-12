package com.cognizant.JpaPracticeCheck.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	private int id;
	
	@Column(name="us_name")
	private String name;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "cart",
	joinColumns = @JoinColumn(name = "ct_us_id"),
	inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private Set<MenuItem> menuItemList;
	
	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public User() {
		super();
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
}
