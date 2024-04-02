package com.akasharavinth.library.login;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.models.Admin;

public class AdminLoginModel {
    private AdminLoginView adminLoginView;
    AdminLoginModel(AdminLoginView adminLoginView){
        this.adminLoginView = adminLoginView;
    }

    public void validateIdPassword(String adminId, String adminPassword) {
        for (Admin a : Database.getInstance().getAdminList()){
            if (a.getAdminId().equals(adminId)){
                if (a.getAdminPassword().equals(adminPassword)){
                    adminLoginView.showAlert("Admin Login Successfully");

                }else {
                    adminLoginView.showAlert("Please Enter Valid Password");
                    adminLoginView.reLogin();
                }
            }else {
                adminLoginView.showAlert("Please Enter Valid Admin Id");
                adminLoginView.reLogin();
            }
        }
    }

    public void giveReLogin(String choice) {
        if (choice.equalsIgnoreCase("yes")){
            adminLoginView.adminLogin();
        } else if (choice.equalsIgnoreCase("no")) {
            adminLoginView.init();
        }else{
            System.out.println("Please Enter Valid Choice");
            adminLoginView.adminLogin();
        }
    }
}
