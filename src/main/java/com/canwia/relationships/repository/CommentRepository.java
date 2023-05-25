package com.canwia.relationships.repository;

import com.canwia.relationships.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT * FROM comments WHERE product_id =:id ",nativeQuery = true)
    Optional<List<Comment>> findAllCommentByProductId(Long id);
}
