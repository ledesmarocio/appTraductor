package com.example.apptraductor;

public class Palabra {
    private String spanish, english;
    private int img;

    public Palabra(String spanish, String english, int img){
        this.spanish= spanish;
        this.english=english;
        this.img=img;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getEnglish() {
        return english;
    }

    public int getImg() {
        return img;
    }
}
