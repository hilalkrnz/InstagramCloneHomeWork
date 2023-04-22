package com.example.instagramclonehomework.model;

public class PostListData {

    private String postName;
    private int imageId;

    public PostListData(String postName, int imageId) {
        this.postName = postName;
        this.imageId = imageId;

    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
