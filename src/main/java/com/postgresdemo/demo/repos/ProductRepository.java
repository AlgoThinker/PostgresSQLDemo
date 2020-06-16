package com.postgresdemo.demo.repos;

import com.postgresdemo.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
