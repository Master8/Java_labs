import javax.swing.*;
import java.io.File;

public class Frame extends JFrame
{
    private String[] namesOfFiles;

    public Frame()
    {
        super("Photos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
    }

    public Icon loadImage(String filename)
    {
        Icon image = new ImageIcon(filename);
        return image;
    }

    public String[] getPicturesNames()
    {
        File file = new File("images");
        namesOfFiles = file.list();
        return namesOfFiles;
    }
}
