package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {

    private int commentID;
    private int userID;
    private int replyToID; //null if replying to a post
    private int postID;
    private String messageDetails;
    private LocalDateTime timeStamp;

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
        //this.messageDetails() = messageDetails();
    }

    public void setTimeStamp(LocalDateTime  timeStamp) {
        this.timeStamp = timeStamp;
    }

}
