package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CommentRowMapper implements RowMapper <Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentID(rs.getInt("comment_id"));
        comment.setUserID(rs.getInt("user_id"));
        comment.setPostID(rs.getInt("post_id"));
        comment.setReplyToID(rs.getObject("reply_to") != null ? rs.getInt("reply_to") : 0); // default 0 if null
        comment.setMessageDetails(rs.getString("message"));
        comment.setTimeStamp(rs.getObject("time_stamp", LocalDateTime.class));
        return comment;
    }

}
