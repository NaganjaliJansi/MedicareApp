package com.simplilearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entities.Product;
import com.simplilearn.entities.User;
import com.simplilearn.services.ProductService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductController {
	@Autowired
	public ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		Product product= service.addProduct(p);
		if(product!=null)
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		else
			return new ResponseEntity<Product>(product,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/allProducts")
	public List<Product> getProducts(){
		return service.getProducts();
	}
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product= service.getProductById(id);
		if(product!=null)
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		else
			return new ResponseEntity<Product>(product,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product p) {
		Product product = service.updateProduct(id, p);
			return product;
	}
	@DeleteMapping("/deleteProduct/{id}")
	public Boolean deleteProduct(@PathVariable int id){
		boolean result = service.deleteProduct(id);
		return result;
			
	}

}
