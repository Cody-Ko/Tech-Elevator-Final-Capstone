package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.ArrayList;
import java.util.List;

public class JdbcPostDAO implements PostDAO {

    /*** SINGLE POST GETTERS ***/

    public Post getPostByID(int postID){
        return new Post();
    }
    public Post getPostByTitle(String postTitle){
        return new Post();
    }
    public int getUserID(int postID){

        return 999;
    }
    public String getUserName(int postID){
        return new String();
    }

    /*** LIST POST GETTERS ***/
    public List<Post> getAllPosts(){
        List<Post> rtnList = new ArrayList<Post>();
        return rtnList;
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

}
