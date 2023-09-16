package com.gustavogeraldelli.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gustavogeraldelli.course.entities.Order;
import com.gustavogeraldelli.course.entities.User;
import com.gustavogeraldelli.course.repositories.OrderRepository;
import com.gustavogeraldelli.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Carl Purple", "carl@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Walter White", "walter@gmail.com", "988888888", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-20T03:23:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:2Z"), u1);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
