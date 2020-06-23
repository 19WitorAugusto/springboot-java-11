package com.witoraugusto.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witoraugusto.project.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
