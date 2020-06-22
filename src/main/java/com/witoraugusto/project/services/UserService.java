package com.witoraugusto.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witoraugusto.project.entities.User;
import com.witoraugusto.project.repositories.UserRepository;

@Service
public class UserService {
	@Autowired //fazer injeção transparente
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();//buscar todos!
	}
	//retornando por ID
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
