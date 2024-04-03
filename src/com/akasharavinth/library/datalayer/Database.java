package com.akasharavinth.library.datalayer;

import com.akasharavinth.library.models.Book;
import com.akasharavinth.library.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    ObjectMapper objectMapper = new ObjectMapper();
    private static Database database;
    public static Database getInstance(){
        if (database == null){
            database = new Database();
        }
        return database;
    }

    //////////////////////////////             Book             /////////////////////////////////////////

    File bookFile = new File("book.json");
    List<Book> bookList = new ArrayList<Book>();

    public List<Book> getBookList(){
        return bookList;
    }

    public void getBooks(){
        try{
            bookList = objectMapper.readValue(bookFile, new TypeReference<List<Book>>() {});
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public <T> void  manageFile(File f,List<T> list){
        try{
            if (f.exists()){
                f.delete();
                if (f.createNewFile()){
                    objectMapper.writeValue(f,list);
                }
            }else{
                if (f.createNewFile()){
                    objectMapper.writeValue(f,list);
                }
            }
        }catch (IOException i){
            i.printStackTrace();
        }
    }
    public void addBook(Book b){
        bookList.add(b);
       manageFile(bookFile,bookList);
        System.out.println("Book add Successfully");
    }

    public void removeBook(Book b){
         bookList.remove(b);
        manageFile(bookFile,bookList);
        System.out.println("Book Removed Successfully");
    }


    public void updateBook(Book b) {
        for (Book book : bookList){
            if (book.getBookId() == b.getBookId()){
                bookList.remove(book);
                bookList.add(b);
            }
        }
        manageFile(bookFile,bookList);
        System.out.println("Book Updated Successfully");
    }

    public void showBooks() {
        for (Book b : bookList){
            System.out.println(b.getBookName()+"   "+b.getBookAuthor()+"   "+b.getNoOfBooks()+"   "+b.getBookJouner());
        }
    }

    /////////////////////////////////           USER            ////////////////////////////////////////

    File userFile = new File("userFile.json");
    List<User> userList = new ArrayList<>();

    public List<User> getUserList(){
        return userList;
    }
    public void getUsers(){
        try {
            userList = objectMapper.readValue(userFile, new TypeReference<List<User>>() {});
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public void addUser(User u){
        userList.add(u);
        manageFile(userFile,userList);
        System.out.println("User Add Successfully");
    }
    public void removeUser(User u){
        userList.remove(u);
        manageFile(userFile,userList);
        System.out.println("User Removed Successfully");
    }
    public void updateUser(User u) {
        for (User user : userList){
            if (user.getUserId() == u.getUserId()){
                System.out.println(user.getUserName());
                userList.remove(user);
                userList.add(u);
                break;
            }
        }
        manageFile(userFile,userList);
        System.out.println("User Updated Successfully");
    }

    public void showUser(){
        for (User u : userList){
            System.out.println(u.getUserName()+"   "+u.getUserEmailId()+"   "+u.getUserAddress());
        }
    }
}
