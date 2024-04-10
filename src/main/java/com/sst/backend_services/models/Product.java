package com.sst.backend_services.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Product {
    @Id
    private int id;
    private String title;
    private int price;
    @ManyToOne
    private Category category;
    private String description;
    private String imageURL;

    public Product(int id, String title, int price, String category, String description, String image) {
    }
}