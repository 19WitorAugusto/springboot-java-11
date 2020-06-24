package com.witoraugusto.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witoraugusto.project.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
