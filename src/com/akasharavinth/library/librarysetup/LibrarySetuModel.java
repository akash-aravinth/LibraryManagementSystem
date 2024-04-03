package com.akasharavinth.library.librarysetup;

import com.akasharavinth.library.datalayer.Database;
import com.akasharavinth.library.models.Library;

public class LibrarySetuModel {
    private LibrarySetupView librarySetupView;
    LibrarySetuModel(LibrarySetupView librarySetupView){
        this.librarySetupView = librarySetupView;
    }

    public void setLibrary(Library library) {
        Database.getInstance().setLibrary(library);
        librarySetupView.initiateLibrary();
    }
}
