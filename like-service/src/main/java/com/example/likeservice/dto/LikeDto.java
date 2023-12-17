package com.example.likeservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LikeDto implements Serializable {
    private String productId;
    private String rstName;
    private String location;
    private Integer stars;

    private String userId;
}
