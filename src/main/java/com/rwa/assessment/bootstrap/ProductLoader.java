package com.rwa.assessment.bootstrap;

import com.rwa.assessment.domain.Product;
import com.rwa.assessment.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(ProductLoader.class);

    private ProductRepository productRepository;


    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setProductId(UUID.randomUUID().toString());
        productRepository.save(shirt);

        LOG.info("Saved Shirt - id {}", shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setProductId(UUID.randomUUID().toString());
        productRepository.save(mug);

        LOG.info("Saved Mug - id: {}", mug.getId());
    }
}