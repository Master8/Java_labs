package com.michael.Ideas;

import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Notebook notebook = new Notebook();
        boolean isContinue = true;

        while(isContinue)
        {
            switch (ConsoleHelper.askAction())
            {
                case 1:
                    notebook.addNote(ConsoleHelper.inputNote());
                    ConsoleHelper.writeMessage("Заметка добавлена!");
                    break;
                case 2:
                    ConsoleHelper.inputNote(notebook.getNote(ConsoleHelper.askID()));
                    break;
                case 3:
                    notebook.removeNote(ConsoleHelper.chooseNoteForDelete());
                    ConsoleHelper.writeMessage("Заметка удалена!");
                    break;
                case 4:
                    ConsoleHelper.writeMessage(notebook.toString());
                    break;
                default:
                    isContinue = false;
                    break;
            }
        }
    }
}
