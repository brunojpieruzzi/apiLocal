package com.brunopieruzzi.api_local_comercial.repositories;

import com.brunopieruzzi.api_local_comercial.models.Products;
import com.brunopieruzzi.api_local_comercial.models.Proveedores;

import java.util.List;

public interface SearchRepo {

    List<Products> searchByText (String text);
    List<Proveedores>searchProvByText(String text);

}
