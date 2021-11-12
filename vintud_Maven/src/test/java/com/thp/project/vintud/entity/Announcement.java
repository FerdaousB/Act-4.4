package com.thp.project.vintud.entity;

import java.util.Arrays;
import java.util.Objects;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;


public class Announcement implements AnnouncementImpl{

	
	
	private int id ;
	private String title;
	private String description  ;
	private int category_id;
	private double price;
	private byte[] picture;
	private String publication_date ; 
	private boolean  is_available;
	private int view_number;
	private String localisation;
	private int user_id;
	
	
	public Announcement() {
	}


	public Announcement(int id, String title, String description, int category_id, double price, byte[] picture,
	    String publication_date, boolean is_available, int view_number, String localisation, int user_id) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.category_id = category_id;
		this.price = price;
		this.picture = picture;
		this.publication_date = publication_date;
		this.is_available = is_available;
		this.view_number = view_number;
		this.localisation = localisation;
		this.user_id = user_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(picture);
		result = prime * result + Objects.hash(category_id, description, id, is_available, localisation, price,
				publication_date, title, user_id, view_number);
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
		Announcement other = (Announcement) obj;
		return category_id == other.category_id && Objects.equals(description, other.description) && id == other.id
				&& is_available == other.is_available && Objects.equals(localisation, other.localisation)
				&& Arrays.equals(picture, other.picture)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publication_date, other.publication_date) && Objects.equals(title, other.title)
				&& user_id == other.user_id && view_number == other.view_number;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double d) {
		this.price = d;
	}


	public byte[] getPicture() {
		return picture;
	}


	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public String getPublication_date() {
		return publication_date;
	}


	public void setPublication_date(String string) {
		this.publication_date = string;
	}


	public boolean getIs_available() {
		return is_available;
	}


	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}


	public int getView_number() {
		return view_number;
	}


	public void setView_number(int view_number) {
		this.view_number = view_number;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", description=" + description + ", category_id="
				+ category_id + ", price=" + price + ", picture=" + Arrays.toString(picture) + ", publication_date="
				+ publication_date + ", is_available=" + is_available + ", view_number=" + view_number
				+ ", localisation=" + localisation + ", user_id=" + user_id + "]";
	}
	
	
	
	
	
	
	
	
}
