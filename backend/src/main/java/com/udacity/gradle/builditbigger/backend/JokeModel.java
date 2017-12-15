package com.udacity.gradle.builditbigger.backend;

public class JokeModel {
    private String joke;

    JokeModel(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }
}