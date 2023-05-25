package com.canwia.relationships.controller;

import com.canwia.relationships.Service.LikeService;
import com.canwia.relationships.dto.LikeDto;
import com.canwia.relationships.dto.request.LikeCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<LikeDto> getLikeById(@PathVariable Long id){
        return ResponseEntity.ok(likeService.getLikeById(id));
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<List<LikeDto>> getAllLikeByCommentId(@PathVariable Long id){
        return ResponseEntity.ok(likeService.getAllLikeByCommentId(id));
    }
    @PostMapping
    public ResponseEntity<LikeDto> createLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return ResponseEntity.ok(likeService.createLike(likeCreateRequest));
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteLikeById(@PathVariable Long id){
        likeService.deleteLikeById(id);
        return ResponseEntity.noContent().build();
    }
}
