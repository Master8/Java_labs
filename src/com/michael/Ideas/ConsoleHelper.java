package com.michael.Ideas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static int askAction() throws IOException
    {
        System.out.println("\nВвыберите действие:\n1 - добавить заметку" +
                "\n2 - редактировать заметку" +
                "\n3 - удалить заметку" +
                "\n4 - просмотреть все заметки" +
                "\n0 - выход");

        return Integer.parseInt(reader.readLine());
    }

    public static Note inputNote() throws IOException
    {
        return inputNote(new Note());
    }

    public static Note inputNote(Note note) throws IOException
    {
        System.out.println("Введите заголовок: ");
        note.setTitle(reader.readLine());

        note.setDate(new Date());

        System.out.println("Введите текст заметки");
        note.setText(reader.readLine());

        System.out.println("Выберите категорию:\n1 - Работа\n2 - Семья\n3 - Другое");

        switch(reader.readLine())
        {
            case "1":
                note.setCategory(Category.WORK);
                break;
            case "2":
                note.setCategory(Category.FAMILY);
                break;
            case "3":
                note.setCategory(Category.OTHER);
                break;
            default:
                note.setCategory(Category.OTHER);
                break;
        }

        return note;
    }

    public static int askID() throws IOException
    {
        System.out.println("Введите ID");

        return Integer.parseInt(reader.readLine());
    }

    public static int chooseNoteForDelete() throws IOException
    {
        System.out.println("Введите ID заметки которую необходимо удалить");
        return Integer.parseInt(reader.readLine());
    }
}
