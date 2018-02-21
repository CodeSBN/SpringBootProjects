package com.example.Products.Model;
/*
 * Author:Soham Banerjee
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="Products_data")
//Auto populate create and update entry for the Model
@EntityListeners(AuditingEntityListener.class)
//Allowing only in response ignoring these properties from request
@JsonIgnoreProperties(value={"createdAt","UpdatedAT"},allowGetters=true)
public class ProductsModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7110587841974407079L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	
	@NotBlank
	private String ProductName;
	private int productQuantity;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)//used for date object to covert to equivalant database type and reverse
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date updatedAt;
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	

}
