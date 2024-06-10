package com.brunopieruzzi.api_local_comercial.models;

public class ItemVenta {
    Products products;
    private Integer cantidad;

    public ItemVenta() {
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
