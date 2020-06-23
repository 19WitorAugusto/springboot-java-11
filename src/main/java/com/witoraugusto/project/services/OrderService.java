package com.witoraugusto.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witoraugusto.project.entities.Order;
import com.witoraugusto.project.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired //fazer injeção transparente
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();//buscar todos!
	}
	//retornando por ID
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
