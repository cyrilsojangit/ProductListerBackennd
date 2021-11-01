package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

public class ProductDTO {

	private long id;
	private String name;
	private String description;
	private ProductCategoryDTO category;
	private Date creation_Date;
	private Date updated_Date;
	private Date last_purchased_Date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(ProductCategoryDTO category) {
		this.category = category;
	}

	public Date getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}

	public Date getUpdated_Date() {
		return updated_Date;
	}

	public void setUpdated_Date(Date updated_Date) {
		this.updated_Date = updated_Date;
	}

	public Date getLast_purchased_Date() {
		return last_purchased_Date;
	}

	public void setLast_purchased_Date(Date last_purchased_Date) {
		this.last_purchased_Date = last_purchased_Date;
	}

}
