package com.akasharavinth.library.login;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.models.Book;
import com.akasharavinth.library.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserLoginModel {
    private UserLoginView userLoginView;
    UserLoginModel(UserLoginView userLoginView){
        this.userLoginView = userLoginView;
    }

    public void validateUser(String userName) {
        for (User u : Database.getInstance().getUserList()){
            if (u.getUserName().equals(userName)){
                userLoginView.showAlert("Successfully Login");
                userLoginView.libraryHome();
                u.setUser(u);
            }
        }
        userLoginView.showAlert("please Enter Valid userId Password");
        userLoginView.init();
    }

    public void showBooks() {
        Database.getInstance().showBooks();
    }

    public void getRequestBook(String bookName, String bookAuthor) {
        for (Book book : Database.getInstance().getBookList()){
            if (book.getBookAuthor().equals(bookAuthor) && book.getBookName().equals(bookName)){
                if (book.getNoOfBooks() > 0){

                }
            }
        }
    }
}
