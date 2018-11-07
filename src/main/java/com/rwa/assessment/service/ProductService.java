package com.rwa.assessment.service;

import com.rwa.assessment.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}