package com.akasharavinth.library;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.home.HomeView;

public class LibraryManagement {
    public static LibraryManagement libraryManagement;

    public static LibraryManagement getInstance(){
        if (libraryManagement == null)
            libraryManagement = new LibraryManagement();
        return libraryManagement;
    }

    public void init(){
        Database.getInstance().getBooks();
        HomeView homeView = new HomeView();
        homeView.init();
    }
    public static void main(String[] args) {
        LibraryManagement.getInstance().init();
    }
    private String appName = "LibraryManagementSystem";
    private String appVersion = "1.0.1";

    public String getAppName() {
        return appName;
    }
    public String getAppVersion() {
        return appVersion;
    }
}
