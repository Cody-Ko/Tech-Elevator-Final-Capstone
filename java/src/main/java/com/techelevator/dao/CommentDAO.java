package com.techelevator.dao;

import com.techelevator.model.Comment;

import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment);
    Comment getCommentId(int commentID);
    List<Comment> getAllComments();
    List<Comment> getCommentsByPostId(int postID);
    List<Comment> getRepliesByCommentId(int commentID);
    void updateComment(Comment comment);
    void deleteComment(int commentID);


}
