package com.example.catalogservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatalogDto implements Serializable {
    private String productId;
    private String rstName;
    private String location;
    private Integer stars;

    private String userId;
}
