package com.somshine.webApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "shoppe_id")
	private int shoppeId;
	private String name;
	private String description;
	private Double quantity;
	private int deleted;
	
	@ManyToOne
	private Company company;
	
	public Product() {
		super();
	}
	
	public Product(Long id, int shoppeId, String name, String description, Double quantity, Company company) {
		super();
		this.id = id;
		this.shoppeId = shoppeId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.company = company;
	}

	public Product(int shoppeId, String name, String description, Double quantity, Company company) {
		super();
		this.shoppeId = shoppeId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getShoppeId() {
		return shoppeId;
	}

	public void setShoppeId(int shoppeId) {
		this.shoppeId = shoppeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
