package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Forum;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcForumDAO implements ForumDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcForumDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addForum(int forumId, String name, LocalDateTime timestamp, int userId) {
        String sql = "INSERT into forum " +
                "(forum_id, forum_name, " +
                "forum_time_stamp, user_id " +
                "VALUES " +
                "(?,?,?,?,?);";
        try {
            jdbcTemplate.update(sql, forumId, name, timestamp, userId);
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch(DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }
    @Override
    public Forum mapRowToForum(SqlRowSet results) {
        Forum forum = new Forum();
        forum.setForumId(results.getInt("forum_id"));
        forum.setName(results.getString("forum_name"));
        //forum.setTimestamp(results.getDate("time_stamp"));    //COMMENTED OUT -- NEED TO FIX LATER
        forum.setUserID(results.getInt("user_id"));
        return forum;
    }

    // GETS USER ID OF PERSON WHO CREATED FORUM
    @Override
    public int getUserId(String name) {
        String sql = "SELECT user_id from forum WHERE forum_name = ?";

        try{
            return jdbcTemplate.queryForObject(sql, int.class, name);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Forum " + name + " was not found.");
        }
    }

    // GETS USERNAME OF PERSON WHO CREATED FORUM
    @Override
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
    @Override
    public List<Forum> getForumsByUsername(String username) {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT forum_name FROM forum\n" +
                "JOIN user_forum ON forum_id.forum = forum_id.user_forum\n" +
                "JOIN users ON user_id.user_forum = user_id.users\n" +
                "WHERE username = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
    @Override
    public List<Forum> getForumsByForumName(String name) {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT * FROM forum WHERE forum_name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
    @Override
    public List<Forum> getForumsByForumId(int forumId) {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT * FROM forum WHERE forum_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, forumId);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
    @Override
    public List<Forum> getFavoriteForums(String username) {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT forum_name FROM forum\n" +
                "JOIN user_favorite_forums ON forum_id.forum = forum.id.user_favorite_forums\n" +
                "JOIN users ON forum_user_id = user_id.users\n" +
                "WHERE username = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
    @Override
    public List<Forum> getActiveForums() {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT forum_name, time_stamp " +
                "FROM forum " +
                "ORDER BY time_stamp DESC " +
                "LIMIT 5";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
    @Override
    public List<Forum> getForumsByKeyword(String keyword) {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT forum_name FROM forum WHERE forum_name LIKE ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, keyword);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
    @Override
    public List<Forum> getAllForums() {
        List<Forum> forums = new ArrayList<>();
        String sql = "SELECT * FROM forum";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Forum forum = mapRowToForum(results);
            forums.add(forum);
        }
        return forums;
    }
}
