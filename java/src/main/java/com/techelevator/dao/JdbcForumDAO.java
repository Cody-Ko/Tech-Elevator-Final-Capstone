package com.techelevator.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class JdbcForumDAO implements ForumDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcForumDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
                "JOIN user_form ON user_id.users = user_id.user_form\n" +
                "JOIN forum ON forum_id.user_form = forum_id.forum\n" +
                "WHERE forum_name = ?";

        try{
            return jdbcTemplate.queryForObject(sql, String.class, name);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Forum " + name + " was not found.");
        }
    }

    public List<String> getForumsByUsername(String username) {
        String sql = "SELECT forum_name FROM forum\n" +
                "JOIN user_form ON forum_id.forum = forum_id.user_form\n" +
                "JOIN users ON user_id.user_form = user_id.users\n" +
                "WHERE username = ?";

        try{
            return jdbcTemplate.queryForList(sql, new Object[]{username}, String.class);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
    }
}
