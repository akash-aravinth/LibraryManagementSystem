package com.akasharavinth.library.models;

public class Library {
    private String libraryName;
    private String LibraryId;
    private String libraryEmail;
    private String libraryAddress;

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(String libraryId) {
        LibraryId = libraryId;
    }

    public String getLibraryEmail() {
        return libraryEmail;
    }

    public void setLibraryEmail(String libraryEmail) {
        this.libraryEmail = libraryEmail;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }
}
