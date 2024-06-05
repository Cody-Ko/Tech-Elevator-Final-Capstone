package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
public class JdbcCommentDAO implements CommentDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //Add addComment method eventually
    @Override
    public void addComment(Comment comment) {
        String sql = "INSERT INTO comments (user_id, reply_to_id, post_id, message, time_stamp) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, comment.getUserID());
            ps.setInt(2, comment.getPostID());
            ps.setObject(3, comment.getReplyToID() == 0 ? null : comment.getReplyToID());
            ps.setString(4, comment.getMessageDetails());
            ps.setObject(5, comment.getTimeStamp());
            return ps;
        }, keyHolder);

        comment.setCommentID(keyHolder.getKey().intValue());
    }

    @Override
    public Comment getCommentById(int commentID) {
        String sql = "SELECT * FROM comments WHERE comment_id = ?";
        return jdbcTemplate.queryForObject(sql, new CommentRowMapper(), commentID);
    }

    @Override
    public List<Comment> getAllComments(){
        String sql = "SELECT * FROM comments";
        return jdbcTemplate.query(sql, new CommentRowMapper());
    }

    @Override
    public List<Comment> getCommentsByPostId(int postID) {
        String sql = "SELECT * FROM comments WHERE post_id = ? ORDER BY time_stamp";
        return jdbcTemplate.query(sql, new CommentRowMapper(), postID);
    }

    @Override
    public List<Comment> getRepliesByCommentId (int commentID) {
        String sql = "SELECT * FROM comments WHERE reply_to = ? ORDER BY time_stamp";
        return jdbcTemplate.query(sql, new CommentRowMapper(), commentID);
    }

    @Override
    public void updateComment(Comment comment) {
        String sql = "UPDATE comments SET user_id = ?, post_id = ?, reply_to = ?, message = ?, time_stamp = ? WHERE comment_id = ?";
        jdbcTemplate.update(sql, comment.getUserID(), comment.getPostID(), comment.getReplyToID() == 0 ? null : comment.getReplyToID(), comment.getMessageDetails(), comment.getTimeStamp(), comment.getCommentID());
    }

    @Override
    public void deleteComment(int commentID) {
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        jdbcTemplate.update(sql, commentID);
    }
}
