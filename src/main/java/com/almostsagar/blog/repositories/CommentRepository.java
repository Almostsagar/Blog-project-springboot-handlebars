package com.almostsagar.blog.repositories;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almostsagar.blog.entities.Comment;
import com.almostsagar.blog.entities.Post;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    LinkedList<Comment> findByFkPostId(Post post);

    @Modifying
    @Query("update Comment c set c.commentApproved = ?1 where c.commentId = ?2 and c.fkPostId.postId = ?3")
    int setCommentApprovedForCommentId(Boolean approve, Integer commentId, Integer postId);
}
