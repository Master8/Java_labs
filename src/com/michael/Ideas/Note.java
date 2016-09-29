package com.michael.Ideas;

import java.util.Date;

public class Note
{
    private String title;
    private Date date;
    private String text;
    private Category category;

    public Note(String title, Date date, String text, Category category) {
        this.title = title;
        this.date = date;
        this.text = text;
        this.category = category;
    }

    public Note()
    {

    }

    @Override
    public String toString() {
        return title + "\n" + date + "\n" + category + "\n\n" + text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
