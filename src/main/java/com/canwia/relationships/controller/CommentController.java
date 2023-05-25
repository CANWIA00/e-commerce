package com.canwia.relationships.controller;

import com.canwia.relationships.Service.CommentService;
import com.canwia.relationships.dto.CommentDto;
import com.canwia.relationships.dto.request.CommentCreateRequest;
import com.canwia.relationships.dto.request.CommentUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @GetMapping("/getAll/product/{id}")
    public ResponseEntity<List<CommentDto>> getAllCommentByProductId(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getAllCommentByProductId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return ResponseEntity.ok(commentService.createComment(commentCreateRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable Long id, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return ResponseEntity.ok(commentService.updateCommentById(id,commentUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long id){
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }
}
