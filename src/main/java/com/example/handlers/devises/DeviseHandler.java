package com.example.handlers.devises;

import java.util.List;

public class DeviseHandler {
    private final List<String> deviseList;

    public DeviseHandler(List<String> deviseList) {
        this.deviseList = deviseList;
    }

    public boolean isDeviseValid(String devise) throws NullPointerException{
        if (this.deviseList.contains(devise.toUpperCase())) return true;

        throw new NullPointerException("This devise doesn't exist: ->" + devise+"<-");
    }
}
