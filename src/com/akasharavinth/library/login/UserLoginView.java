package com.akasharavinth.library.login;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.home.HomeView;

import java.util.Scanner;

public class UserLoginView {
    Scanner scanner = new Scanner(System.in);
    private UserLoginModel userLoginModel;
    UserLoginView(){
        userLoginModel = new UserLoginModel(this);
    }
    public void init(){
        System.out.println("Welcome to "+ Database.getInstance().getLibrary().getLibraryName());
        System.out.println("You Must Login First");
        startLoginUser();
    }
    public void showAlert(String alert){
        System.out.println(alert);
    }

    private void startLoginUser() {
        System.out.println("Enter the UserName");
        String userName = scanner.next();
        userLoginModel.validateUser(userName);
    }

    public void libraryHome() {
        System.out.println("1 --> ShowBook\n2 --> Request a Book\n3 --> Show Due Books\n4 --> Show FavoriteBook\n5 --> ShowFavorite Book\n" +
                "6 --> LogOut\n7 --> GoBack");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                showBooks();
                libraryHome();
                break;
            }
            case 2 : {
                System.out.println("Request a Book");
                break;
            }
            case 3 : {
                System.out.println("Show Due Book");
                break;
            }
            case 4 : {
                System.out.println("Add FavoriteBook");
                break;
            }
            case 5 : {
                System.out.println("Show FavoriteBook");
                break;
            }
            case 6 : {
                System.out.println("Logout");
                break;
            }
            case 7 : {
                HomeView homeView = new HomeView();
                homeView.runApp();
            }
            default:{
                System.out.println("Please Enter Valid Option");
                libraryHome();
            }
        }
    }
    public void showBooks(){
        userLoginModel.showBooks();
    }
    public void requestBook(){
        System.out.println("Enter Book Name : ");
        String bookName = scanner.next();
        System.out.println("Enter Book Author : ");
        String bookAuthor = scanner.next();
        userLoginModel.getRequestBook(bookName,bookAuthor);
    }

}
