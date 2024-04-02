package com.akasharavinth.library.manageuser;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.managebooks.ManageBookModel;
import com.akasharavinth.library.managebooks.ManageBookView;
import com.akasharavinth.library.models.User;

public class ManageUserModel {
    private ManageUserView manageUserView;
    ManageUserModel(ManageUserView manageUserView){
        this.manageUserView = manageUserView;
    }

    public void giveAddBook(User user) {
        Database.getInstance().addUser(user);
    }

    public User gettingUpdateUser(long userId) {
        for (User u : Database.getInstance().getUserList()){
            if (u.getUserId() == userId){
                return u;
            }
        }
        return null;
    }

    public void giveUpdateUser(User user) {
        System.out.println("1");
        Database.getInstance().updateUser(user);
    }

    public void getShowUser() {
        Database.getInstance().showUser();
    }

    public void giveRemoveUser(long userId) {
        User user = null;
        for (User u : Database.getInstance().getUserList()){
            if (u.getUserId() == userId){
                user = u;
            }
        }
        if (user == null){
            System.out.println("Please Enter Valid UserId : ");
            manageUserView.getUpdateUser();
        }
        Database.getInstance().removeUser(user);
    }
}
