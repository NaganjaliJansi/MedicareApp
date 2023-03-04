package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
