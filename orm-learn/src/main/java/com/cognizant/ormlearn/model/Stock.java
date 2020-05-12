package com.cognizant.ormlearn.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	@Id
	@Column(name = "st_id")
	private int id;

	@Column(name = "st_code")
	private String code;
	
	@Column(name="st_date")
	private Date date;
	
	@Column(name="st_open")
	private float open;
	
	@Column(name="st_close")
	private float close;
	
	@Column(name="st_volume")
	private int volume;

	public Stock() {
	}



	public Stock(int id, String code, Date date, float open, float close, int volume) {
		this.id = id;
		this.code = code;
		this.date = date;
		this.open = open;
		this.close = close;
		this.volume = volume;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public float getOpen() {
		return open;
	}



	public void setOpen(float open) {
		this.open = open;
	}



	public float getClose() {
		return close;
	}



	public void setClose(float close) {
		this.close = close;
	}



	public int getVolume() {
		return volume;
	}



	public void setVolume(int volume) {
		this.volume = volume;
	}



	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close
				+ ", volume=" + volume + "]";
	}
	
	
}
