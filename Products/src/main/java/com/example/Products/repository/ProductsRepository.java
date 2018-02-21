package com.example.Products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Products.Model.ProductsModel;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel,Long> {

}
