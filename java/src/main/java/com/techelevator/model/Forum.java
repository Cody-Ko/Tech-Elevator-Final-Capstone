package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Forum {
    @JsonProperty("forum_name")
    private String name;
    @JsonProperty("time_stamp")
    private Date timeStamp;
    @JsonProperty("user_id")
    private int userID;
    @JsonProperty("forum_id")
    private int forumId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }


}
