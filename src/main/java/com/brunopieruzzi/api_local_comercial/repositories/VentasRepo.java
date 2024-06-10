package com.brunopieruzzi.api_local_comercial.repositories;

import com.brunopieruzzi.api_local_comercial.models.Ventas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VentasRepo extends MongoRepository<Ventas,String> {
}
