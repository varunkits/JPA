package com.cognizant.JpaPracticeCheck.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "menu_item")
public class MenuItem {
	
	@Id
	@Column(name = "me_id")
	private int id;
	
	@Column(name = "me_name")	
	private String name;
	
	@Column(name = "me_price")
	private float price;
	
	@Column(name = "me_active")
	private boolean active;
	
	@Column(name = "me_date_of_launch")
	private Date dateOfLaunch;
	
	@Column(name = "me_category")
	private String category;
	
	@Column(name = "me_free_delivery")
	private boolean freeDelivery;
	
	
	@ManyToMany(mappedBy = "menuItemList",fetch=FetchType.EAGER)
	private Set<User> userList;	
	
	public MenuItem() {
		super();
	}

	public Set<User> getUserList() {
		return userList;
	}



	public void setUserList(Set<User> userList) {
		this.userList = userList;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "\nId = " + id + "\nName = " + name + "\nPrice = " + price + "\nActive = " + active +
				"\nDate Of Launch = " + dateOfLaunch + "\nCategory = " + category + 
				"\nFree Delivery = " + freeDelivery + "\n***************************************";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

