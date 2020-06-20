package com.postgresdemo.demo;

import com.postgresdemo.demo.entities.Product;
import com.postgresdemo.demo.repos.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	@Order(1)
	public void testCreate(){
		Product product = new Product();
		product.setId(1);
		product.setName("bnokia ph");
		product.setDesc("awesosssme");
		product.setPrice(500d);
		productRepository.save(product);
	}

	@Test
	@Order(2)
	public void testRead(){
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("bnokia ph",product.getName());
	}

	@Test
	@Order(3)
	public void testUpdate(){
		Product product = productRepository.findById(1).get();
		product.setPrice(1200d);
		productRepository.save(product);
	}

	@Test
	@Order(4)
	public void testDelete(){
		if(productRepository.existsById(1)){
			System.out.println("deleting a product");
			productRepository.deleteById(1);
		}
	}

}
