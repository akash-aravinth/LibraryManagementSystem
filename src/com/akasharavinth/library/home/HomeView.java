package com.akasharavinth.library.home;

import com.akasharavinth.library.LibraryManagement;
import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.login.AdminLoginView;
import com.akasharavinth.library.managebooks.ManageBookView;
import com.akasharavinth.library.manageuser.ManageUserView;

import java.util.Scanner;

public class HomeView {

    Scanner scanner = new Scanner(System.in);
    public void init() {
        System.out.println("Welcome To : "+ LibraryManagement.getInstance().getAppName());
        System.out.println("And the Version : "+LibraryManagement.getInstance().getAppVersion());
        runApp();
    }
    public void runApp(){
        ManageUserView manageUserView = new ManageUserView();
        System.out.println("1 --> Admin Login\n2 --> User Login\n3 --> SignUp\n4 --> GoBack");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                AdminLoginView adminLoginView = new AdminLoginView();
                adminLoginView.init();
                break;
            }
            case 2 : {
                System.out.println("User Login");
                break;
            }
            case 3 : {
                System.out.println("Sign Up");
                break;
            }
            case 4 : {
                System.out.println("ThankYou For Using Our "+LibraryManagement.getInstance().getAppName());
                init();
                break;
            }
            default:{
                System.out.println("Please Enter Correct Choice");
                runApp();
                break;
            }
        }
    }
}
