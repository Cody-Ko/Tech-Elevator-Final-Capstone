package com.techelevator.dao;

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
        try{
            SqlRowSet postRowSet = jdbcTemplate.queryForRowSet(sql, postID);
            if (postRowSet.next()) {
                returnPost = mapRowToPost(postRowSet);
            }

        } catch (NullPointerException e){
            return null;
        }
        return returnPost;
    }
    public Post getPostByTitle(String postTitle){

        String sql = "SELECT * FROM posts" +
                " WHERE title = ?";

        return new Post();
    }

    /*** POST PROPERTY GETTERS ***/
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
        try {
            SqlRowSet result= jdbcTemplate.queryForRowSet(sql);
            while(result.next()){
                postList.add(mapRowToPost(result));
            }
        }
        catch (NullPointerException e){
            return null;
        }

        return postList;
    }
    public List<Post> getPostsByUsername(String Username){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
    }
    public List<Post> getPostsByUserID(int userID){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
    }
    public List<Post> getPostsByForumName(String forumName){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
    }
    public List<Post> getPostsByForumID(int forumID){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
    }

    /*** CREATE AND DELETE POSTS ***/
    public void createPost(Post toPost){

    }
    public void deletePost(int postID){

    }
    public void deletePostsByUserID(int userID){

    }

    /*** METHODS FOR VOTING ON POSTS ***/
    public void upvotePost(int postID){

    }
    public void downvotePost(int postID){

    }
    public int getPostScore(int postID){
        return 999;
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
        post.setTimeStamp(rs.getDate("time_stamp"));
        return post;
    }



}
