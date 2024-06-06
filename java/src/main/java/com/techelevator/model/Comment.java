package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Comment {
    @JsonProperty("comment_id")
    private int commentID;
    @JsonProperty("user_id")
    private int userID;
    @JsonProperty("reply_to")
    private int replyToID; //null if replying to a post
    @JsonProperty("post_id")
    private int postID;
    @JsonProperty("message")
    private String messageDetails;
    @JsonProperty("time_stamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;

    @JsonProperty("location")
    private String location;
    //Getters

    public int getCommentID() {
        return commentID;
    }

    public int getUserID(){
        return userID;
    }

    public int getReplyToID(){
        return replyToID;
    }

    public int getPostID(){
        return getPostID();
    }

    public String getMessageDetails(){
        return getMessageDetails();
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public String getLocation(){
        return location;
    }

    //Setters
    public void setCommentID(int commentID){
        this.commentID = commentID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setReplyToID(int replyToID) {
        this.replyToID = replyToID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setMessageDetails(String messageDetails){
        this.messageDetails = messageDetails;
    }

    public void setTimeStamp(LocalDateTime  timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
