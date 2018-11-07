package com.rwa.assessment.repository;

import com.rwa.assessment.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}