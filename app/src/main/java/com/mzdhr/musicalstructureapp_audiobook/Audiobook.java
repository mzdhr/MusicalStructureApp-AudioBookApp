package com.mzdhr.musicalstructureapp_audiobook;

/**
 * Created by mohammad on 11/18/17.
 */

public class Audiobook {
    private String mTitle;
    private String mAuthor;
    private String mYear;
    private int mImageResourceId;
    private String mDuration;


    public Audiobook(String title, String author, String year, int cover, String duration) {
        mTitle = title;
        mAuthor = author;
        mYear = year;
        mImageResourceId = cover;
        mDuration = duration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }
}
