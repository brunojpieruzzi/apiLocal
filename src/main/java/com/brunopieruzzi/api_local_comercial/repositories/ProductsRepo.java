package com.brunopieruzzi.api_local_comercial.repositories;

import com.brunopieruzzi.api_local_comercial.models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepo extends MongoRepository <Products, String> {
}
