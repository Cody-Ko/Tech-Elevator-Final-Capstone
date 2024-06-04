package com.techelevator.dao;

import java.util.List;

public interface ForumDAO {

    int getUserId(String name);

    String getUsername(String name);

    List<String> getForumsByUsername(String username);
}
