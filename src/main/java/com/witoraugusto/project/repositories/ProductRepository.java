package com.witoraugusto.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witoraugusto.project.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
