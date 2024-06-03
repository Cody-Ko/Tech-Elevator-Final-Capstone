package com.techelevator.controller;

// import data access objects for comment, forum, post, and user
import com.techelevator.dao.CommentDAO;
import com.techelevator.dao.ForumDAO;
import com.techelevator.dao.PostDAO;
import com.techelevator.dao.UserDAO;

//import spring framework resources
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
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

}
