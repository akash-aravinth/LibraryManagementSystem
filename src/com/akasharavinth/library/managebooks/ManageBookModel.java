package com.akasharavinth.library.managebooks;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.models.Book;

import javax.xml.crypto.Data;

public class ManageBookModel {
    private ManageBookView manageBookView;
    ManageBookModel(ManageBookView manageBookView){
        this.manageBookView = manageBookView;
    }

    public void giveAddBook(Book book) {
        Database.getInstance().addBook(book);
    }

    public Book getUpdateBook(long id){
        System.out.println("Book2");
        for (Book b : Database.getInstance().getBookList()){
            if (b.getBookId() == id){
                return b;
            }
        }
        return null;
    }

    public void giveUpdateBook(Book book) {
        Database.getInstance().updateBook(book);
    }

    public void giveRemoveBook(long bookId) {
        Book book = null;
        for (Book b : Database.getInstance().getBookList()){
            if (b.getBookId() == bookId){
                book = b;
            }
        }
        if (book == null){
            System.out.println("Please Enter Valid BookName And BookAuthor");
            manageBookView.getUpdateBook();
        }
        Database.getInstance().removeBook(book);
    }

    public void giveShowBook() {
        Database.getInstance().showBooks();
    }
}
