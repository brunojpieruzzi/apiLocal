package com.brunopieruzzi.api_local_comercial.repositories;

import com.brunopieruzzi.api_local_comercial.models.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoRepo extends MongoRepository<Pago,String> {
}
