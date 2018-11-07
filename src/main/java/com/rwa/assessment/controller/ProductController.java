package com.rwa.assessment.controller;

import com.rwa.assessment.domain.Product;
import com.rwa.assessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @GetMapping("product/{id}")
    public String showProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    @GetMapping("product/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @GetMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @PostMapping(value = "product")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}