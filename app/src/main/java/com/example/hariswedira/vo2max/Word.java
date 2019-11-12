package com.example.hariswedira.vo2max;

public class Word {
    private String miwokWord;
    private String defaultWord;
    private int imageResId = -1;

    public Word(String miwokWord, String defaultWord) {
        this.miwokWord = miwokWord;
        this.defaultWord = defaultWord;
    }

    public Word(String miwokWord, String defaultWord, int imageResId) {
        this.miwokWord = miwokWord;
        this.defaultWord = defaultWord;
        this.imageResId = imageResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public boolean hasImage(){
        return imageResId != -1;
    }
}
