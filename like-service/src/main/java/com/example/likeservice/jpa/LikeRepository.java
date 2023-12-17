package com.example.likeservice.jpa;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<LikeEntity, Long> {
    Iterable<LikeEntity> findByUserId(String userId);
}
