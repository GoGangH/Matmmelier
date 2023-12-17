package com.example.likeservice.service;

import com.example.likeservice.dto.LikeDto;
import com.example.likeservice.jpa.LikeEntity;

public interface LikeService {
    LikeDto createLike(LikeDto likeDetails);
    Iterable<LikeEntity> getLikesByUserId(String userId);
}
