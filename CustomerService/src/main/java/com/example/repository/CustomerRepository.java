package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends  MongoRepository<Customer, String> {
    Customer findCustomerById(String userId);
}