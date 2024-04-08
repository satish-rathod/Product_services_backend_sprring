package com.sst.backend_services.controllers;

import com.sst.backend_services.DTOs.ExceptionDto;
import com.sst.backend_services.models.Product;
import com.sst.backend_services.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//        ResponseEntity<Product> responseEntity=null;
//        Product product=null;
//       try {
//           product = productService.getProductById(id);
//           responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//           System.out.println("product is "+product);
//              return responseEntity;
//       }
//         catch (RuntimeException error)
//         {
//             ExceptionDto exceptionDto = new ExceptionDto();
//                exceptionDto.setMessage("Product not found");
//
//             ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//             return response;
//         }
        return productService.getProductById(id);


   }

   @GetMapping
    public List<Product> getAllProduct()
    {
        return productService.getAllProducts();
    }
}