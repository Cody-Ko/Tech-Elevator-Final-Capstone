package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment);
    Comment getCommentById(int commentID);
    List<Comment> getAllComments();
    List<Comment> getCommentsByPostId(int postID);
    List<Comment> getRepliesByCommentId(int commentID);
    void updateComment(Comment comment);
    void deleteComment(int commentID);
    //Comment mapRow(SqlRowSet rs, int rowNum) throws SQLException ;



    }
