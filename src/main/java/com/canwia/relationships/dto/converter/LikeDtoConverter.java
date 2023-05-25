package com.canwia.relationships.dto.converter;

import com.canwia.relationships.dto.LikeDto;
import com.canwia.relationships.model.Like;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikeDtoConverter {

    public LikeDto convert(Like like){
        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setCommentId(like.getComment().getId());
        likeDto.setAccountId(like.getAccount().getId());
        return likeDto;
    }

    public List<LikeDto> convertList(List<Like> likeList){
        return new ArrayList<>(likeList).stream().map(this::convert).collect(Collectors.toList());
    }
}
