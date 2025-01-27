package com.example.maliciousurl.controller;

public class UrlResponse {
    private boolean isSafe;

    public UrlResponse(boolean isSafe) {
        this.isSafe = isSafe;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public void setSafe(boolean isSafe) {
        this.isSafe = isSafe;
    }
}
