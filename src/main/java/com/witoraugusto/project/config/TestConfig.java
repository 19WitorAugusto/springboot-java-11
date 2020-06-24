package com.witoraugusto.project.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.witoraugusto.project.entities.Category;
import com.witoraugusto.project.entities.Order;
import com.witoraugusto.project.entities.Product;
import com.witoraugusto.project.entities.User;
import com.witoraugusto.project.entities.enums.OrderStatus;
import com.witoraugusto.project.repositories.CategoryRepository;
import com.witoraugusto.project.repositories.OrderRepository;
import com.witoraugusto.project.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;
	
	
				
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		productRepository.saveAll(Arrays.asList(p1, p2, p3 ,p4,p5));
		
		User u1 = new User(null, "maria Bronw","maria@gmail.com","123456789","142536");
		User u2 = new User(null, "Alex Green","alex@gmail.com","987654321","362514");
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:53:07Z"), OrderStatus.ESPERANDO_PAGAMENTO, u2 );
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:53:07Z"), OrderStatus.ESPERANDO_PAGAMENTO,u1);					
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	
		
	}
	
	
}
