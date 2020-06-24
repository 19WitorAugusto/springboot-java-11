package com.witoraugusto.project.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.witoraugusto.project.entities.Category;
import com.witoraugusto.project.entities.Order;
import com.witoraugusto.project.entities.User;
import com.witoraugusto.project.entities.enums.OrderStatus;
import com.witoraugusto.project.repositories.CategoryRepository;
import com.witoraugusto.project.repositories.OrderRepository;
import com.witoraugusto.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
				
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "maria Bronw","maria@gmail.com","123456789","142536");
		User u2 = new User(null, "Alex Green","alex@gmail.com","987654321","362514");
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:53:07Z"), OrderStatus.ESPERANDO_PAGAMENTO, u2 );
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:53:07Z"), OrderStatus.ESPERANDO_PAGAMENTO,u1);					
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	
		
	}
	
	
}
