package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Forum {
    @JsonProperty("forum_name")
    private String name;
    @JsonProperty("time_stamp")
    private LocalDateTime timestamp;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("forum_id")
    private int forumId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public void setTimestamp(Date timestamp) {
        LocalDateTime localDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.timestamp = localDateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserID(int userId) {
        this.userId = userId;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }


}
