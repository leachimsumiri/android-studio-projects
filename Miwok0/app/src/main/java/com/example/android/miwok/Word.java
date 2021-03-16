package com.example.android.miwok;

public class Word {
    public int imageCount;
    public String english;
    public String miwok;
    public int rawResId;

    public Word(int imgc, String english, String miwok, int rawResId){
        this.imageCount = imgc;
        this.english = english;
        this.miwok = miwok;
        this.rawResId = rawResId;
    }

    public Word(int imgc, String english, String miwok){
        this.imageCount = imgc;
        this.english = english;
        this.miwok = miwok;
    }


    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMiwok() {
        return miwok;
    }

    public void setMiwok(String miwok) {
        this.miwok = miwok;
    }

    public int getRawResId() {
        return rawResId;
    }

    public void setRawResId(int rawResId) {
        this.rawResId = rawResId;
    }
}
