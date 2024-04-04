package com.sst.backend_services.controllers;

import com.sst.backend_services.DTOs.FakestoreProductDto;
import com.sst.backend_services.models.Product;
import com.sst.backend_services.services.FakeStoreProductService;
import com.sst.backend_services.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
class ProductController {

    private ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/{id}")
   public Product getProductById(@PathVariable("id") long id){
       return productService.getProductById(id);
   }

   @GetMapping
    public List<Product> getAllProduct()
    {
        return productService.getAllProducts();
    }
}