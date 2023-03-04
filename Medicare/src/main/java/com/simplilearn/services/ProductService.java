package com.simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entities.Product;
import com.simplilearn.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	public ProductRepo repo;
	
	public Product addProduct(Product p) {
		return repo.save(p);
	}
	public List<Product> getProducts(){
		return repo.findAll();
	}
	public Product getProductById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
	}
	public Product updateProduct(int id, Product p) {
		if(repo.findById(id).isPresent()) {
			Product oldProduct = repo.findById(id).get();
			oldProduct.setName(p.getName());
			oldProduct.setBrand(p.getBrand());
			oldProduct.setCost(p.getCost());
			oldProduct.setDescription(p.getDescription());
			oldProduct.setStatus(p.isStatus());
			return repo.save(p);
		}
		else {
			return null;
		}
	}
	public boolean deleteProduct(int id) {
		if(repo.findById(id).isPresent()) {
			 repo.deleteById(id);
			 return true;
		}
		else {
			return false;
		}
	}
}
