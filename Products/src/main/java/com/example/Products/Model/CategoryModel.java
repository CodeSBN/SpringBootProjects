package com.example.Products.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="category")
public class CategoryModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9107565948632243183L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryId;
	@Column(name="name")
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category",fetch=FetchType.EAGER)
	@JsonBackReference
	private Set<ProductsModel> products=new HashSet<>();
	
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<ProductsModel> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductsModel> products) {
		this.products = products;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
