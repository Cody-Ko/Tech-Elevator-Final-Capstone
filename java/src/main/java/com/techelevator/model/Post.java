package com.techelevator.model;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class Post {

    private int postID;
    private int userID;
    private int forumID;
    private String title;
    private String messageDetails;
    private int upVotes;
    private int downVotes;
    private LocalDateTime timeStamp;


    public Post(int postID, int userID, int forumID, String title, String messageDetails, int upVotes, int downVotes, LocalDateTime timeStamp) {
        this.postID = postID;
        this.userID = userID;
        this.forumID = forumID;
        this.title = title;
        this.messageDetails = messageDetails;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.timeStamp = timeStamp;
    }

    //overload the constructor so that it can be declared before setting variables in the DAO
    public Post(){

    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getForumID() {
        return forumID;
    }

    public void setForumID(int forumID) {
        this.forumID = forumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    //overloaded setter for converting Date parameter to LocalDateTime property
    public void setTimeStamp(Date timeStamp){
        LocalDateTime localDateTime = timeStamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.timeStamp = localDateTime;
    }
}
