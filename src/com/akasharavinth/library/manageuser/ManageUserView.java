package com.akasharavinth.library.manageuser;

import com.akasharavinth.library.home.HomeView;
import com.akasharavinth.library.models.User;

import java.util.Scanner;

public class ManageUserView {
    Scanner scanner = new Scanner(System.in);
    private ManageUserModel manageUserModel;
    public ManageUserView(){
        manageUserModel = new ManageUserModel(this);
    }
    public void init(){
        System.out.println("Here You Can addUser,UpdateUser,RemoveUser,showUser");
        startManageUser();
    }

    public void startManageUser() {
        System.out.println("1 --> AddUser\n2 --> UpdateUser\n3 --> RemoveUser\n4 --> ShowUser\n5 --> GoBack");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                getAddUser();
                getMoreUser(" add ");
                break;
            }
            case 2 : {
                getUpdateUser();
                getMoreUser(" Update ");
                break;
            }
            case 3 : {
                getRemoveUser();
                getMoreUser(" Remove ");
                break;
            }
            case 4 : {
                getShowUser();
                startManageUser();
                break;
            }
            case 5 : {
                HomeView homeView = new HomeView();
                homeView.runApp();
            }
            default:{
                System.out.println("Please Enter Valid Choice ");
                startManageUser();
                break;
            }
        }
    }
    public void getAddUser(){
        User user = new User();
        System.out.println("Enter the UserName : ");
        user.setUserName(scanner.next());
        System.out.println("Enter the UserEmailId");
        user.setUserEmailId(scanner.next());
        System.out.println("Enter the UserAddress");
        user.setUserAddress(scanner.next());
        manageUserModel.giveAddBook(user);
    }
    public void getMoreUser(String s){
        System.out.println("Type yes for "+s+"User no for exit");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")){
            getAddUser();
        }else if(choice.equalsIgnoreCase("no")){
            startManageUser();
        }else {
            System.out.println("Please Enter Valid Choice");
            getAddUser();
        }
    }

    public void getUpdateUser(){
        User user = null;
        System.out.println("Enter the UserId for update : ");
        long userId = scanner.nextLong();
        user = manageUserModel.gettingUpdateUser(userId);
        if (user == null){
            System.out.println("Please Enter Valid userId : ");
            getUpdateUser();
        }
        System.out.println("Enter the UserName : ");
        user.setUserName(scanner.next());
        System.out.println("Enter the UserEmailId");
        user.setUserEmailId(scanner.next());
        System.out.println("Enter the UserAddress");
        user.setUserAddress(scanner.next());
        manageUserModel.giveUpdateUser(user);
    }

    public void getRemoveUser(){
        System.out.println("Enter the User Id : ");
        long userId = scanner.nextLong();
        manageUserModel.giveRemoveUser(userId);
    }
    public void getShowUser(){
        manageUserModel.getShowUser();
    }

}
