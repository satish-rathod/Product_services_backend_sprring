package com.sst.backend_services.services;

import com.sst.backend_services.DTOs.FakestoreProductDto;
import com.sst.backend_services.exceptions.ProductNotFoundException;
import com.sst.backend_services.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakestoreProductDto fakestoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakestoreProductDto.class);

       try {
              return convertProductDtoToProduct(fakestoreProductDto);
         }
         catch (RuntimeException error)
         {
              throw new ProductNotFoundException(id,"Product not found");
       }

    }

    public List<Product> getAllProducts()
    {
        RestTemplate restTemplate = new RestTemplate();
        FakestoreProductDto[] fakestoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakestoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakestoreProductDto fakestoreProductDto : fakestoreProductDtos)
        {
            products.add(convertProductDtoToProduct(fakestoreProductDto));
        }
        return products;
    }

    private Product convertProductDtoToProduct(FakestoreProductDto fakestoreProductDto)
    {
        return new Product((int) fakestoreProductDto.getId(), fakestoreProductDto.getTitle(), (int) fakestoreProductDto.getPrice(), fakestoreProductDto.getCategory(), fakestoreProductDto.getDescription(), fakestoreProductDto.getImage());
    }


}
