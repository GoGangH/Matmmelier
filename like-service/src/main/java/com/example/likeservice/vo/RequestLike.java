package com.example.likeservice.vo;

import lombok.Data;

@Data
public class RequestLike {
    private String productId;
    private String rstName;
    private String location;
    private Integer stars;
}
