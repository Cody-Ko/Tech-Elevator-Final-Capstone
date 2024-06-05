package com.techelevator.controller;

// import data access objects for comment, forum, post, and user
import com.techelevator.dao.CommentDAO;
import com.techelevator.dao.ForumDAO;
import com.techelevator.dao.PostDAO;
import com.techelevator.dao.UserDAO;

//import spring framework resources
import com.techelevator.model.Forum;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
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

    @RequestMapping(value = "/forums", method = RequestMethod.GET)
    public List<Forum> getAllForums() {
        return forumDAO.getAllForums();
    }

    @RequestMapping(value = "/forums/{keyword}", method = RequestMethod.GET)
    public List<Forum> getForumsByKeyword(@PathVariable String keyword) {
        return forumDAO.getForumsByKeyword(keyword);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/forums", method = RequestMethod.POST)
    public void addForum(@Valid @RequestBody Forum forum) {
        //return forumDAO.addForum(forum);
    }


}
