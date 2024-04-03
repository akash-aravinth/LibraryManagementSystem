package com.akasharavinth.library.librarysetup;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.home.HomeView;
import com.akasharavinth.library.managebooks.ManageBookView;
import com.akasharavinth.library.manageuser.ManageUserView;
import com.akasharavinth.library.models.Library;

import java.util.Scanner;

public class LibrarySetupView {
    private LibrarySetuModel librarySetuModel;
    public LibrarySetupView(){
        librarySetuModel = new LibrarySetuModel(this);
    }
    Scanner scanner = new Scanner(System.in);
    public void init(){
        System.out.println("Welcome To LibraryManagement System");
        if (Database.getInstance().getLibrary() == null){
            startSetup();
        }else{
            initiateLibrary();
        }
    }

    public void startSetup() {
        Library library = new Library();
        System.out.println("Enter LibraryId");
        library.setLibraryId(scanner.next());
        System.out.println("Enter Library Name");
        library.setLibraryName(scanner.next());
        System.out.println("Enter Library EmailId");
        library.setLibraryEmail(scanner.next());
        System.out.println("Enter Library Address");
        library.setLibraryAddress(scanner.next());
        librarySetuModel.setLibrary(library);
    }

    public void initiateLibrary() {
        System.out.println("Welcome To "+Database.getInstance().getLibrary().getLibraryName());
        System.out.println("Here You can Manage User,Manage Book");
        gettingChoice();
    }

    private void gettingChoice() {
        System.out.println("1 --> ManageUser\n2 --> ManageBook\n3 --> GoBack");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                ManageUserView manageUserView = new ManageUserView();
                manageUserView.init();
                break;
            }
            case 2 : {
                ManageBookView manageBookView = new ManageBookView();
                manageBookView.init();
                break;
            }
            case 3 : {
                HomeView homeView = new HomeView();
                homeView.runApp();
                break;
            }
            default:{
                System.out.println("Enter Valid Choice");
                gettingChoice();
                break;
            }
        }
    }
}
