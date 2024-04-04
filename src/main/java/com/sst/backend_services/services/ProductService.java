package com.sst.backend_services.services;

import com.sst.backend_services.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long id);

    List<Product> getAllProducts();


}
