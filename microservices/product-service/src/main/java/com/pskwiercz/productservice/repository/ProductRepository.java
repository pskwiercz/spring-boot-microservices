package com.pskwiercz.productservice.repository;

import com.pskwiercz.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  ProductRepository extends MongoRepository<Product, String> {
}
