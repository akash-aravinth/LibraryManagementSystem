package com.akasharavinth.library.managebooks;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.home.HomeView;
import com.akasharavinth.library.models.Book;

import java.util.Scanner;

public class ManageBookView {
    Scanner scanner = new Scanner(System.in);
    private ManageBookModel manageBookModel;
    public ManageBookView(){
        manageBookModel = new ManageBookModel(this);
    }
    public void init(){
        System.out.println("Here You Can AddBook,UpdateBook,RemoveBook");
        startManageBookView();
    }

    private void startManageBookView() {
        System.out.println("1 --> AddBook\n2 --> UpdateBook\n3 --> RemoveBook\n4 --> ShowBook\n5 --> GoBack");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                getAddBook();
                getMoreBook(" Add ");
                break;
            }
            case 2 : {
                getUpdateBook();
                getMoreBook(" Update ");
                break;
            }
            case 3 : {
                getRemoveBook();
                getMoreBook(" Remove ");
                break;
            }
            case 4 : {
                getShowBook();
                startManageBookView();
                break;
            }
            case 5 : {
                HomeView homeView = new HomeView();
                homeView.runApp();
                break;
            }
            default:{
                System.out.println("Please Enter Valid Choice");
                startManageBookView();
                break;
            }
        }
    }

    public void getAddBook(){
        Book book = new Book();
        System.out.println("Enter Book Name : ");
        book.setBookName(scanner.next());
        System.out.println("Enter Book Author : ");
        book.setBookAuthor(scanner.next());
        System.out.println("Enter Book Publication : ");
        book.setBookPublication(scanner.next());
        System.out.println("Enter No Of Books : ");
        book.setNoOfBooks(scanner.nextInt());
        System.out.println("Enter Book Journer : ");
        book.setBookJouner(scanner.next());
        manageBookModel.giveAddBook(book);
    }
    public void getMoreBook(String s){
        System.out.println("Type yes for "+s+" More Books");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")){
            getAddBook();
        }else if(choice.equalsIgnoreCase("no")){
            startManageBookView();
        }else{
            System.out.println("Please Enter Valid Choice");
            startManageBookView();
        }
    }
    public void getUpdateBook(){
        Book book = null;
        System.out.println("Enter Book Id : ");
        long bookId = scanner.nextLong();
        book = manageBookModel.getUpdateBook(bookId);
        if (book == null){
            System.out.println("Book ID not found please give a valid bookid");
            getUpdateBook();
        }
        System.out.println("Enter Book Name : ");
        book.setBookName(scanner.next());
        System.out.println("Enter Book Author : ");
        book.setBookAuthor(scanner.next());
        System.out.println("Enter Book Publication : ");
        book.setBookPublication(scanner.next());
        System.out.println("Enter No Of Books : ");
        book.setNoOfBooks(scanner.nextInt());
        System.out.println("Enter Book Journer : ");
        book.setBookJouner(scanner.next());
        manageBookModel.giveUpdateBook(book);
    }
    public void getRemoveBook(){
        System.out.println("Enter the book Id : ");
        long bookId = scanner.nextLong();
        manageBookModel.giveRemoveBook(bookId);
    }
    public void getShowBook(){
        manageBookModel.giveShowBook();
    }
}
