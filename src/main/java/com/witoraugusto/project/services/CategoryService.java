package com.witoraugusto.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witoraugusto.project.entities.Category;
import com.witoraugusto.project.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired //fazer injeção transparente
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();//buscar todos!
	}
	//retornando por ID
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
