package com.witoraugusto.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witoraugusto.project.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
}
