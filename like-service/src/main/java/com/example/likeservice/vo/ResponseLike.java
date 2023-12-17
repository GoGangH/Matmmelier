package com.example.likeservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLike {
    private String productId;
    private String rstName;
    private String location;
    private Integer stars;
}
