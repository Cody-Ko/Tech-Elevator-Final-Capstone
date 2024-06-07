package com.techelevator.dao;

import com.techelevator.model.Forum;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ForumDAO {

    int getUserId(String name);

    String getUsername(String name);

    List<Forum> getForumsByUsername(String username);

    void addForum(Forum forum);

    Forum mapRowToForum(SqlRowSet results);

    List<Forum> getFavoriteForums(String username);

    List<Forum> getActiveForums();

    List<Forum> getForumsByKeyword(String keyword);

    List<Forum> getAllForums();

    List<Forum> getForumsByForumName(String name);

    Forum getForumById(int forumId);

    void deleteForumByForumName(String name);

    void deleteForumByForumId(int forumId);

    void deleteForumsByUserId(String username);

}
