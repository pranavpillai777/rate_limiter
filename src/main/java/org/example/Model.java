package org.example;

import org.springframework.stereotype.Service;

@Service
public class Model {

    private final int capacity = 5;
    private int currentToken;
    private long lastRefillTimeStamp;


    public Model() {
        this.currentToken = 5;
        this.lastRefillTimeStamp = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(int currentToken) {
        this.currentToken = currentToken;
    }

    public long getLastRefillTimeStamp() {
        return lastRefillTimeStamp;
    }

    public void setLastRefillTimeStamp(long lastRefillTimeStamp) {
        this.lastRefillTimeStamp = lastRefillTimeStamp;
    }
}