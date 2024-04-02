package com.akasharavinth.library.login;

import java.util.Scanner;

public class AdminLoginView {
    Scanner scanner = new Scanner(System.in);
    private AdminLoginModel adminLoginModel;
    AdminLoginView(){
        adminLoginModel = new AdminLoginModel(this);
    }
    public void init(){
        System.out.println("Welcome Admin");
        System.out.println("Please Enter Id and Password");
        adminLogin();
    }

    public void adminLogin() {
        System.out.println("Enter Admin Id : ");
        String adminId = scanner.next();
        System.out.println("Enter Admin Password : ");
        String adminPassword = scanner.next();
        adminLoginModel.validateIdPassword(adminId,adminPassword);
    }
    public void showAlert(String alert){
        System.out.println(alert);
    }
    public void reLogin(){
        System.out.println("Type yes for reLogin no for Exit");
        String choice = scanner.next();
        adminLoginModel.giveReLogin(choice);
    }
}
