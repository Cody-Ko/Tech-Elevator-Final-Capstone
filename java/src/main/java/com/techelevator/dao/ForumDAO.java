package com.techelevator.dao;

import java.util.Date;
import java.util.List;

public interface ForumDAO {

    int getUserId(String name);

    String getUsername(String name);

    List<String> getForumsByUsername(String username);

    void addForum(int forumId, String name, Date timestamp, int userId, boolean favorite);
}
