package com.techelevator.dao;

import com.techelevator.model.Forum;
import com.techelevator.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component

public class JdbcPostDAO implements PostDAO {

    /*** CONSTRUCTOR ***/
    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDAO (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }




    /*** SINGLE POST GETTERS ***/

    @Override
    public Post getPostByID(int postID){
        String sql = "SELECT * FROM posts" +
                " WHERE post_id = ?";
        Post returnPost = new Post();
        SqlRowSet postRowSet = jdbcTemplate.queryForRowSet(sql, postID);
        if (postRowSet.next()) {
            returnPost = mapRowToPost(postRowSet);
        }

        return returnPost;
    }
    @Override
    public Post getPostByTitle(String postTitle){

        String sql = "SELECT * FROM posts" +
                " WHERE title = ?";
        Post returnPost = new Post();


        SqlRowSet postRowSet = jdbcTemplate.queryForRowSet(sql, postTitle);
        if (postRowSet.next()) {
            returnPost = mapRowToPost(postRowSet);
        }

        return returnPost;
    }

    /*** POST PROPERTY GETTERS ***/
    @Override
    public int getUserID(int postID){
        String sql = "SELECT user_id FROM posts" +
                " WHERE post_id = ?";

        return jdbcTemplate.queryForObject(sql, int.class, postID);
    }
    public String getUserName(int postID){
        String sql = "SELECT ";
        // do a join here
        return new String();
    }

    /*** LIST POST GETTERS ***/
    @Override
    public List<Post> getAllPosts(){
        String sql = "SELECT * FROM posts";
        List<Post> postList = new ArrayList<>();
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            postList.add(mapRowToPost(result));
        }
        return postList;
    }
    @Override
    public List<Post> getPostsByUsername(String Username){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
    }
    @Override
    public List<Post> getPostsByUserID(int userID){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
    }

    @Override
    public List<Post> getPostsByKeyword(String keyword) {
        List<Post> posts = new ArrayList<>();

        String sql = "SELECT * FROM posts WHERE title ILIKE CONCAT('%', ? ,'%')" +
                "OR message ILIKE CONCAT('%', ? ,'%')";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, keyword, keyword);

        while(results.next()) {
            Post post = mapRowToPost(results);
            posts.add(post);
        }
        return posts;
    }
    /*********************************************************/
    /***** GET POSTS BY FORUM NAME, GET POSTS BY FORUM ID ***/
    /********************************************************/
    @Override
    public List<Post> getPostsByForumName(String forumName){
        String sql = "SELECT * FROM posts" +
                " JOIN forum ON posts.forum_id = forum.forum_id" +
                " WHERE forum.forum_name = ?";
        List<Post> rtnList = new ArrayList<Post>();

        SqlRowSet postRowSet = jdbcTemplate.queryForRowSet(sql, forumName);
        while (postRowSet.next()) {
            Post post = mapRowToPost(postRowSet);
            rtnList.add(post);
        }
        return rtnList;
    }
    @Override
    public List<Post> getPostsByForumID(int forumID){
        String sql = "SELECT * FROM posts" +
                " WHERE forum_id = ? ";
        List<Post> rtnList = new ArrayList<Post>();
        SqlRowSet postRowSet = jdbcTemplate.queryForRowSet(sql, forumID);
        while (postRowSet.next()) {
            Post post = mapRowToPost(postRowSet);
            rtnList.add(post);
        }
        return rtnList;
    }

    /*** CREATE AND DELETE POSTS ***/
    @Override
    public void createPost(Post toPost){
        String sql = "INSERT INTO posts VALUES (DEFAULT, ?, ?, ?, ? , ?, ?, CURRENT_TIMESTAMP, ?)";
        jdbcTemplate.update(sql, toPost.getUserID(), toPost.getForumID(), toPost.getTitle(),
                toPost.getMessageDetails(), toPost.getUpVotes(), toPost.getDownVotes(),
                toPost.getLocation());
    }
    @Override
    public void deletePost(int postID){

    }
    @Override
    public void deletePostsByUserID(int userID){

    }

    /*** METHODS FOR VOTING ON POSTS ***/
    public void upvotePost(int postID){
        String sql = "UPDATE posts SET up_votes = up_votes + 1 WHERE post_id = ?";
        jdbcTemplate.update(sql, postID);
    }
    public void downvotePost(int postID){
        String sql = "UPDATE posts SET up_votes = up_votes - 1 WHERE post_id = ?";
        jdbcTemplate.update(sql, postID);
    }
    public int getPostScore(int postID){
        String sql = "SELECT * FROM posts WHERE post_id = ?";
        Post returnPost = new Post();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, postID);

        if (rowSet.next()) {
            returnPost = mapRowToPost(rowSet);
        }

        return returnPost.getScore();
    }


    public List<Post> get10MostPopularPosts(){
        String sql = "SELECT * FROM posts order by up_votes-down_votes DESC limit 10 ";
        List<Post> postList = new ArrayList<Post>();
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            postList.add(mapRowToPost(result));
        }
        return postList;
    }

    private Post mapRowToPost(SqlRowSet rs) {
        Post post = new Post();
        post.setPostID(rs.getInt("post_id"));
        post.setUserID(rs.getInt("user_id"));
        post.setForumID(rs.getInt("forum_id"));
        post.setTitle(rs.getString("title"));
        post.setMessageDetails(rs.getString("message"));
        post.setUpVotes(rs.getInt("up_votes"));
        post.setDownVotes(rs.getInt("down_votes"));
        if (rs.getTimestamp("time_stamp") != null) {
            post.setTimeStamp(rs.getTimestamp("time_stamp").toLocalDateTime());
        }
        post.setLocation(rs.getString("location"));
        return post;
    }



}
