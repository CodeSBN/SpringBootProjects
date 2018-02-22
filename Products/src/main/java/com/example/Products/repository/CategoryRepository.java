package com.example.Products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Products.Model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
	
	CategoryModel findBycategoryName(String name);

}
