package com.postgresdemo.demo;

import com.postgresdemo.demo.entities.Product;
import com.postgresdemo.demo.repos.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
		product.setId(4);
		product.setName("bhelllli");
		product.setDesc("asmee");
		product.setPrice(100d);
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
		product.setPrice(11100d);
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

	@Test
	public void testFindByName(){
		List<Product> products = productRepository.findByName("android ph");
		products.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void testFindByPriceGreaterThan(){
		List<Product> products = productRepository.findByPriceGreaterThan(200d);
		products.forEach(p -> System.out.println(p.getDesc()));
	}

}
