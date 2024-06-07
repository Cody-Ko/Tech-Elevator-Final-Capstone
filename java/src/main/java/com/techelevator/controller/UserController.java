package com.techelevator.controller;

// import data access objects for comment, forum, post, and user
import com.techelevator.dao.CommentDAO;
import com.techelevator.dao.ForumDAO;
import com.techelevator.dao.PostDAO;
import com.techelevator.dao.UserDAO;

//import spring framework resources
import com.techelevator.model.Comment;
import com.techelevator.model.Forum;
import com.techelevator.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final CommentDAO commentDAO;
    private final ForumDAO forumDAO;
    private final PostDAO postDAO;
    private final UserDAO userDAO;

    public UserController(com.techelevator.dao.CommentDAO commentDAO,
                          com.techelevator.dao.ForumDAO forumDAO,
                          com.techelevator.dao.PostDAO postDAO,
                          com.techelevator.dao.UserDAO userDAO

                          ) {
        this.commentDAO = commentDAO;
        this.forumDAO = forumDAO;
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }

    // GETS ALL FORUMS
    @RequestMapping(value = "/forums", method = RequestMethod.GET)
    public List<Forum> getAllForums() {
        return forumDAO.getAllForums();
    }

    // GETS FORUMS BY KEYWORD
    @RequestMapping(value = "/forums/keyword/{keyword}", method = RequestMethod.GET)
    public List<Forum> getForumsByKeyword(@PathVariable String keyword) {
        return forumDAO.getForumsByKeyword(keyword);
    }

    // GETS FORUMS BY FORUM NAME
    @RequestMapping(value = "/forums/{name}", method = RequestMethod.GET)
    public List<Forum> getForumsByForumName(@PathVariable String name) {
        return forumDAO.getForumsByForumName(name);
    }

    // GETS FORUMS BY FORUM ID
    @RequestMapping(value = "/forums/{forumId}", method = RequestMethod.GET)
    public List<Forum> getForumsByForumId(@PathVariable int forumId) {
        return forumDAO.getForumsByForumId(forumId);
    }

    // GETS FORUMS BY USERNAME
    @RequestMapping(value = "/forums/{username}", method = RequestMethod.GET)
    public List<Forum> getForumsByUsername(@PathVariable String username) {
        return forumDAO.getForumsByUsername(username);
    }

    // CREATES FORUM
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/forums", method = RequestMethod.POST)
    public void addForum(@Valid @RequestBody Forum forum) {
        forumDAO.addForum(forum);
    }

    /*** CREATE A NEW POST ***/
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/forums/{forumId}/posts", method = RequestMethod.POST)
    public void createPost(@Valid @RequestBody Post post) {
        postDAO.createPost(post);
    }

    /*** GET POSTS BY FORUM ***/
    @RequestMapping(value = "/forums/{forumId}/posts", method = RequestMethod.GET)
    public List<Post> getPostsByForumId(@PathVariable int forumId) {
        return postDAO.getPostsByForumID(forumId);
    }

    //AMBIGUOUS SPRING MAPPING ERROR
    /*@RequestMapping(value = "/forums/{forumName}/posts", method = RequestMethod.GET)
    public List<Post> getPostsByForumName(@PathVariable String forumName){
        return postDAO.getPostsByForumName(forumName);
    }*/

    /*** GET ALL POSTS ***/
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    /*** GET POST BY POST_ID ***/
    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public Post getPostByPostId(@PathVariable int postId) {
        return postDAO.getPostByID(postId);
    }

    /*** GET POSTS BY KEYWORD ***/
    @RequestMapping(value = "/posts/keyword/{keyword}", method = RequestMethod.GET)
    public List<Post> getPostsByKeyword(@PathVariable String keyword) {
        return postDAO.getPostsByKeyword(keyword);
    }

    /*** GET POST BY POST_ID ***/
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/posts/{postId}/upvote", method = RequestMethod.PUT)
    public void upvotePost(@PathVariable int postId) {
        postDAO.upvotePost(postId);
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/posts/{postId}/downvote", method = RequestMethod.PUT)
    public void downvotePost(@PathVariable int postId) {
        postDAO.downvotePost(postId);
    }
    @RequestMapping(value = "/posts/{postId}/getscore", method = RequestMethod.GET)
    public int getPostScore(@PathVariable int postId) {
        return postDAO.getPostScore(postId);
    }
    @RequestMapping(value = "/posts/topvoted", method = RequestMethod.GET)
    public List<Post> get10MostPopularPosts() {
        return postDAO.get10MostPopularPosts();
    }

    /*** GET COMMENTS BY POST ID ***/
    @RequestMapping(value = "/posts/{postId}/comments", method = RequestMethod.GET)
    public List<Comment> getCommentsByPostId(@PathVariable int postId){
        return commentDAO.getCommentsByPostId(postId);
    }
}
