package com.akasharavinth.library.models;

public class Book {
    private static long id = 0;
    private long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublication;
    private String bookJouner;
    private int noOfBooks;
    public Book(){
       setBookId();
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId() {
        this.bookId = id++;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublication() {
        return bookPublication;
    }

    public void setBookPublication(String bookPublication) {
        this.bookPublication = bookPublication;
    }

    public String getBookJouner() {
        return bookJouner;
    }

    public void setBookJouner(String bookJouner) {
        this.bookJouner = bookJouner;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }
}
