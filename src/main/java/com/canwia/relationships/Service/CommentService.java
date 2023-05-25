package com.canwia.relationships.Service;

import com.canwia.relationships.dto.CommentDto;
import com.canwia.relationships.dto.converter.CommentDtoConverter;
import com.canwia.relationships.dto.request.CommentCreateRequest;
import com.canwia.relationships.dto.request.CommentUpdateRequest;
import com.canwia.relationships.exception.ApiRequestException;
import com.canwia.relationships.model.Account;
import com.canwia.relationships.model.Comment;
import com.canwia.relationships.model.Product;
import com.canwia.relationships.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentDtoConverter commentDtoConverter;
    private final ProductService productService;
    private final AccountService accountService;

    public CommentService(CommentRepository commentRepository, CommentDtoConverter commentDtoConverter, ProductService productService, AccountService accountService) {
        this.commentRepository = commentRepository;
        this.commentDtoConverter = commentDtoConverter;
        this.productService = productService;
        this.accountService = accountService;
    }

    public CommentDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(()->{
           throw new ApiRequestException("There is not comment with " + id + " number!");
        });

        return commentDtoConverter.convert(comment);
    }

    public List<CommentDto> getAllCommentByProductId(Long id) {
        List<Comment> commentList= commentRepository.findAllCommentByProductId(id).orElseThrow(()->{
            throw new ApiRequestException("There are no comments with " + id + " product number!");
        });

        return commentDtoConverter.convertList(commentList);
    }

    public CommentDto createComment(CommentCreateRequest commentCreateRequest) {
        Product product = productService.findProduct(commentCreateRequest.getProduct_id());
        Account account = accountService.findAccount(commentCreateRequest.getAccount_id());

        Comment comment = new Comment();
        comment.setCommentText(commentCreateRequest.getCommentText());
        comment.setProduct(product);
        comment.setAccount(account);

        return commentDtoConverter.convert(commentRepository.save(comment));
    }

    public void deleteCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isEmpty()){
            throw new ApiRequestException("There is no comment with " + id + " number!");
        }
        commentRepository.deleteById(id);
    }

    public CommentDto updateCommentById(Long id, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(id).orElseThrow(()->{
            throw  new ApiRequestException("There is no comment with " + id + " number!");
        });

        comment.setCommentText(commentUpdateRequest.getCommentText());

        return commentDtoConverter.convert(comment);
    }



    public Comment findComment(Long id){
        return commentRepository.findById(id).orElseThrow(()->{
            throw new ApiRequestException("There is no comment with " + id + "number!");
        });
    }
}
