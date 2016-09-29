package com.michael.Ideas;

import java.util.ArrayList;
import java.util.Date;

public class Notebook
{
    private ArrayList<Note> notes;

    public Notebook()
    {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note)
    {
        notes.add(note);
    }

    public void removeNote(int id)
    {
        notes.remove(id);
    }

    public Note getNote(int id)
    {
        return notes.get(id);
    }

    @Override
    public String toString()
    {
        String result = "";

        for (int i = 0; i < notes.size(); i++)
            result += "ID: " + i + "\n" + notes.get(i) + "\n-------------------------------\n";

        return result;
    }
}
