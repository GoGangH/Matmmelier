package com.example.likeservice.controller;

import com.example.likeservice.dto.LikeDto;
import com.example.likeservice.jpa.LikeEntity;
import com.example.likeservice.service.LikeService;
import com.example.likeservice.vo.RequestLike;
import com.example.likeservice.vo.ResponseLike;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/like-service")
public class LikeController {
    Environment env;
    LikeService likeService;

    @Autowired
    public LikeController(Environment env, LikeService likeService){
        this.env = env;
        this.likeService = likeService;
    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in Like Service on PORT %s", env.getProperty("local.service.port"));
    }

    @PostMapping("/{userId}/likes")
    public ResponseEntity<ResponseLike> createUser(@PathVariable("userId") String userId,
                                                   @RequestBody RequestLike likeDetails){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        LikeDto likeDto = mapper.map(likeDetails, LikeDto.class);
        likeDto.setUserId(userId);
        LikeDto createLike = likeService.createLike(likeDto);

        ResponseLike responseLike = mapper.map(createLike, ResponseLike.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseLike);
    }

    @GetMapping("/{userId}/likes")
    public ResponseEntity<List<ResponseLike>> getLike(@PathVariable("userId") String userId,
                                                      @RequestBody RequestLike likeDetails) {
        Iterable<LikeEntity> likeList = likeService.getLikesByUserId(userId);

        List<ResponseLike> result = new ArrayList<>();
        likeList.forEach(v ->{
            result.add(new ModelMapper().map(v, ResponseLike.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
