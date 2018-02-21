package com.example.Products.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Products.Model.ProductsModel;
import com.example.Products.repository.ProductsRepository;

@RestController
@RequestMapping("/Welcome/Services")
public class ProductsController {
	@Autowired
	ProductsRepository repository;

	// Get All Products API
	@GetMapping("/products")
	public List<ProductsModel> getAllProducts() {

		return repository.findAll();

	}

	// Create a new Product date
	// @valid to check valid reqeust cause we have used @NotBlank check at data
	// model
	@PostMapping("/new")
	public ProductsModel createProduct(@Valid @RequestBody ProductsModel product) {
		return repository.save(product);
	}

	// Get a Single product API

	// In the below method, we are returning a ResponseEntity<Note> instead of
	// Note. The ResponseEntity class gives us more flexibility while returning
	// a response from the api.

	// For example, in the above api, If a note doesn’t exist with the given id,
	// then we’re returning a 404 Not Found error with the help of
	// ResponseEntity.
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductsModel> getProductById(@PathVariable(value = "id") Long productId) {

		ProductsModel product = repository.findOne(productId);

		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(product);
	}
	
	
	//Updating Product quantity
	@PutMapping("/products/change/{id}")
	
	public ResponseEntity<ProductsModel> updateProduct(@Valid @PathVariable(value="id")Long productId,
															@RequestBody ProductsModel model){
			ProductsModel product=repository.findOne(productId);
			
			if(product==null){
				return ResponseEntity.notFound().build();
			}
			
			
			product.setProductQuantity(model.getProductQuantity());
			
			ProductsModel updatedProduct=repository.save(model);
			
			return ResponseEntity.ok().body(updatedProduct);
		
		
	}
	
	
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<ProductsModel> deleteProduct(@PathVariable(value="id") Long productId){
		
		ProductsModel model=repository.findOne(productId);
		
		if(model==null){
			return ResponseEntity.notFound().build();
		}
		
		repository.delete(model);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
	

}
