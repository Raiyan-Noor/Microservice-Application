package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends  MongoRepository<Product, String> {
    Product findProductById(String userId);
}