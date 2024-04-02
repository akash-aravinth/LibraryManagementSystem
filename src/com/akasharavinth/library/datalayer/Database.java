package com.akasharavinth.library.datalayer;

import com.akasharavinth.library.models.Book;
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




}
