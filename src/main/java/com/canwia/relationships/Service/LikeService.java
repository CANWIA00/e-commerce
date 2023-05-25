package com.canwia.relationships.Service;

import com.canwia.relationships.dto.LikeDto;
import com.canwia.relationships.dto.converter.LikeDtoConverter;
import com.canwia.relationships.dto.request.LikeCreateRequest;
import com.canwia.relationships.exception.ApiRequestException;
import com.canwia.relationships.model.Account;
import com.canwia.relationships.model.Comment;
import com.canwia.relationships.model.Like;
import com.canwia.relationships.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final LikeDtoConverter likeDtoConverter;
    private final  AccountService accountService;
    private final  CommentService commentService;

    public LikeService(LikeRepository likeRepository, LikeDtoConverter likeDtoConverter, AccountService accountService, CommentService commentService) {
        this.likeRepository = likeRepository;
        this.likeDtoConverter = likeDtoConverter;
        this.accountService = accountService;
        this.commentService = commentService;
    }

    public LikeDto getLikeById(Long id) {

        Like like = likeRepository.findById(id).orElseThrow(()->{
            throw new ApiRequestException("There is no like with " + id + " number! ");
        });
        return likeDtoConverter.convert(like);
    }

    public List<LikeDto> getAllLikeByCommentId(Long id) {
        List<Like> likeList = likeRepository.findAllLikeByCommentId(id).orElseThrow(()->{
            throw new ApiRequestException("There is no like list with "+ id + " comment number");
        });
        return likeDtoConverter.convertList(likeList);
    }

    public LikeDto createLike(LikeCreateRequest likeCreateRequest) {
        Account account = accountService.findAccount(likeCreateRequest.getAccountId());
        Comment comment = commentService.findComment(likeCreateRequest.getCommentId());

        Like like = new Like();
        like.setAccount(account);
        like.setComment(comment);

        return likeDtoConverter.convert(likeRepository.save(like));
    }

    public void deleteLikeById(Long id) {
        Optional<Like> like = likeRepository.findById(id);
        if (like.isEmpty()){
            throw new ApiRequestException("There is no like with " + id + "number!");
        }
        likeRepository.deleteById(id);
    }
}
