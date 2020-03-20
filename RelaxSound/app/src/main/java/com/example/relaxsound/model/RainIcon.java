package com.example.relaxsound.model;

public class RainIcon {
    private int id;
    private int mp3Uri;
    public RainIcon(int id , int mp3Uri) {
        this.id = id;
        this.mp3Uri = mp3Uri;
    }
    public RainIcon(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMp3Uri() {
        return mp3Uri;
    }

    public void setMp3Uri(int mp3Uri) {
        this.mp3Uri = mp3Uri;
    }
}
