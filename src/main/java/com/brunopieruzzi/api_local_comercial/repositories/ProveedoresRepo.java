package com.brunopieruzzi.api_local_comercial.repositories;

import com.brunopieruzzi.api_local_comercial.models.Proveedores;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProveedoresRepo extends MongoRepository<Proveedores,String> {

}
