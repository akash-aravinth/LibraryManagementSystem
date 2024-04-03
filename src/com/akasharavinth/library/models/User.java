package com.akasharavinth.library.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static long id = 0;
    private long userId;
    private String userName;
    private String userEmailId;
    private String userAddress;
    private List<Book> dueBooks;
    private List<Book> favoriteBook;

    public User(){
        setUserId();
        dueBooks = new ArrayList<Book>();
        favoriteBook = new ArrayList<Book>();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = id++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public List<Book> getDueBooks() {
        return dueBooks;
    }

    public void setDueBooks(List<Book> dueBooks) {
        this.dueBooks = dueBooks;
    }

    public List<Book> getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(List<Book> favoriteBook) {
        this.favoriteBook = favoriteBook;
    }
}
