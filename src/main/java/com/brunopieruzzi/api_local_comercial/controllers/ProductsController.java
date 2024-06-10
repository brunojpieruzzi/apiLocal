package com.brunopieruzzi.api_local_comercial.controllers;


import com.brunopieruzzi.api_local_comercial.models.Products;
import com.brunopieruzzi.api_local_comercial.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductsController {

    @Autowired
    ProductsService productsService;


    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Products getproductById(@PathVariable String id) {
        return productsService.getProductById(id);
    }

    @PostMapping("/product")
    public Products createProduct(@RequestBody Products products) {
        return productsService.createProduct(products);
    }

    @PutMapping("/{id}")
    public Products upDateProduct(@PathVariable String id, @RequestBody Products detailProduct) {
        return productsService.upDateProduct(id, detailProduct);
    }


    @DeleteMapping("product/{id}")
    public Products deleteProduct(@PathVariable String id) {
        return productsService.deleteProduct(id);
    }

    @GetMapping("/search/{text}")
    public List<Products> searchProduct(@PathVariable String text) {
        return productsService.searchProduct(text);
    }

}
