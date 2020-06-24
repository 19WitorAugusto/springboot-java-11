package com.witoraugusto.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witoraugusto.project.entities.Product;
import com.witoraugusto.project.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired //fazer injeção transparente
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();//buscar todos!
	}
	//retornando por ID
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
