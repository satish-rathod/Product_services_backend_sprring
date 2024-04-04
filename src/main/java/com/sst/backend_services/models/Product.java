package com.sst.backend_services.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product{
    private int id;
    private String title;
    private int price;
    private Category category;
    private String description;
    private String imageURL;

    public Product(int id, String title, int price, String category, String description, String image) {
    }
}