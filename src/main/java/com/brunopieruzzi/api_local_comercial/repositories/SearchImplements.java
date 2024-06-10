package com.brunopieruzzi.api_local_comercial.repositories;

import com.brunopieruzzi.api_local_comercial.models.Products;
import com.brunopieruzzi.api_local_comercial.models.Proveedores;
import org.springframework.stereotype.Component;

import java.util.List;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;

@Component
public class SearchImplements implements SearchRepo {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Products> searchByText(String text) {


        final List<Products> products = new ArrayList<>();

        MongoDatabase database = client.getDatabase("Localdb");
        MongoCollection<Document> collection = database.getCollection("Products");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", "nombre")))));


        result.forEach(d -> products.add(converter.read(Products.class, d)));

        return products;
    }

    @Override
    public List<Proveedores> searchProvByText(String text) {
        final List<Proveedores> prov = new ArrayList<>();
        MongoDatabase database = client.getDatabase("Localdb");
        MongoCollection<Document> collection = database.getCollection("proveedores");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", "nombre")))));
        result.forEach(d -> prov.add(converter.read(Proveedores.class, d)));
        return prov;
    }
}
