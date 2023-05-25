package com.canwia.relationships.dto.converter;

import com.canwia.relationships.dto.CommentDto;
import com.canwia.relationships.model.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentDtoConverter {


    public CommentDto convert(Comment comment) {
    CommentDto commentDto = new CommentDto();
    commentDto.setId(comment.getId());
    commentDto.setCommentText(comment.getCommentText());
    commentDto.setAccount_id(comment.getAccount().getId());
    commentDto.setProduct_id(comment.getProduct().getId());
    return commentDto;
    }

    public List<CommentDto> convertList (List<Comment> commentList){
        return commentList.stream().map(this::convert).collect(Collectors.toList());
    }
}
