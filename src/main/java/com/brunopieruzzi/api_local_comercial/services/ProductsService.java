package com.brunopieruzzi.api_local_comercial.services;

import com.brunopieruzzi.api_local_comercial.models.Products;
import com.brunopieruzzi.api_local_comercial.repositories.ProductsRepo;
import com.brunopieruzzi.api_local_comercial.repositories.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductsService {

    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    SearchRepo searchRepo;

    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    public Products getProductById(String id) {
        Products products;
        products = productsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("no se encontro el producto"));
        return products;
    }

    public Products createProduct(Products products) {
        return productsRepo.save(products);
    }

    public Products upDateProduct(String id, Products detailProduct) {
        Products products = productsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto"));
        products.setNombre(detailProduct.getNombre());
        products.setDescripcion(detailProduct.getDescripcion());
        products.setCantidad(detailProduct.getCantidad());
        products.setPrecio(detailProduct.getPrecio());
        return productsRepo.save(products);
    }


    public Products deleteProduct(String id) {
        Products products = productsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));
        productsRepo.delete(products);
        return products;
    }


    public List<Products> searchProduct(String text) {
        return searchRepo.searchByText(text);
    }
}
