package com.example.android.thetraveller;

public class UserModel {

    boolean isSelected;
    String username;

    public UserModel(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public UserModel(boolean isSelected, String username) {
        this.isSelected = isSelected;
        this.username = username;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getUsername() {
        return username;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
