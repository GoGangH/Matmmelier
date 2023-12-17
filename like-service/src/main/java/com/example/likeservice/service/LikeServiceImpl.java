package com.example.likeservice.service;

import com.example.likeservice.dto.LikeDto;
import com.example.likeservice.jpa.LikeEntity;
import com.example.likeservice.jpa.LikeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LikeServiceImpl implements LikeService{
    LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    @Override
    public LikeDto createLike(LikeDto likeDto){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        LikeEntity likeEntity = mapper.map(likeDto, LikeEntity.class);

        likeRepository.save(likeEntity);

        return mapper.map(likeEntity, LikeDto.class);
    }

    @Override
    public Iterable<LikeEntity> getLikesByUserId(String userId){
        return likeRepository.findByUserId(userId);
    }

}
