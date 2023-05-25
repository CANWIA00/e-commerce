package com.canwia.relationships.repository;

import com.canwia.relationships.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

    @Query(value = "SELECT * FROM likes WHERE comment_id=:id",nativeQuery = true)
    Optional<List<Like>> findAllLikeByCommentId(Long id);
}
