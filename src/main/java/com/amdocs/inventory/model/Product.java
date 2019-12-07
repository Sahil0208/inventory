package com.amdocs.inventory.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@NotNull(message = "Please enter product name")
	private String productName;

	private String imageUrl;

	@NotNull(message = "Please enter product price")
	private double price;

	@NotNull(message = "Please enter product type")
	private String productType;

	@OneToMany
	@JoinColumn(name = "productId")
	private List<ProductCharacteristic> productCharacteristics;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date creationDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date updationDate = new Date();

	private Long createdByUserId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<ProductCharacteristic> getProductCharacteristics() {
		return productCharacteristics;
	}

	public void setProductCharacteristics(List<ProductCharacteristic> productCharacteristics) {
		this.productCharacteristics = productCharacteristics;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

}
