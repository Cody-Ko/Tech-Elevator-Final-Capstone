package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.List;

public class JdbcForumDAO implements ForumDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcForumDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addForum(int forumId, String name, Date timestamp, int userId, boolean favorite) {
        String sql = "INSERT into forum " +
                "(forum_id, forum_name, " +
                "forum_time_stamp, user_id, " +
                "favorite_forum) VALUES " +
                "(?,?,?,?,?);";
        try {
            jdbcTemplate.update(sql, forumId, name, timestamp, userId, favorite);
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch(DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    public int getUserId(String name) {
        String sql = "SELECT user_id from forum WHERE forum_name = ?";

        try{
            return jdbcTemplate.queryForObject(sql, int.class, name);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Forum " + name + " was not found.");
        }
    }

    public String getUsername(String name) {
        String sql = "SELECT username from users\n" +
                "JOIN user_forum ON user_id.users = user_id.user_forum\n" +
                "JOIN forum ON forum_id.user_forum = forum_id.forum\n" +
                "WHERE forum_name = ?";

        try{
            return jdbcTemplate.queryForObject(sql, String.class, name);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Forum " + name + " was not found.");
        }
    }

    public List<String> getForumsByUsername(String username) {
        String sql = "SELECT forum_name FROM forum\n" +
                "JOIN user_forum ON forum_id.forum = forum_id.user_forum\n" +
                "JOIN users ON user_id.user_forum = user_id.users\n" +
                "WHERE username = ?";

        try{
            return jdbcTemplate.queryForList(sql, new Object[]{username}, String.class);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
    }

    public List<String> getFavoriteForums(String username) {
        return null;
    }

    public List<String> getActiveForums() {
        return null;
    }

    public List<String> getForumsByKeyword(String keyword) {
        return null;
    }
}
