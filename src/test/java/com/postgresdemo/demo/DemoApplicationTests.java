package com.postgresdemo.demo;

import com.postgresdemo.demo.entities.Product;
import com.postgresdemo.demo.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = new Product();
		product.setId(2);
		product.setName("android phone");
		product.setDesc("awesome");
		product.setPrice(500d);

		productRepository.save(product);
	}

//	@Test
//	public void testRead(){
//		Optional<Product> product = productRepository.findById(1);
//		assertNotNull(product);
//		assertEquals("iphone",product.getName());
//	}

}
