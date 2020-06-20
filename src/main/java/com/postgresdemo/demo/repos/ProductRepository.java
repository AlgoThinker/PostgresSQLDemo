package com.postgresdemo.demo.repos;

import com.postgresdemo.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByPriceGreaterThan(Double price);
}
