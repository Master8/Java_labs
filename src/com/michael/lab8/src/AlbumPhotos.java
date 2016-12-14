import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlbumPhotos
{
    public static void main(String[] args)
    {
        Frame frame = new Frame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JButton[] buttons = new JButton[frame.getPicturesNames().length];
        panel1.setPreferredSize(new Dimension(1200, 600));
        panel2.setPreferredSize(new Dimension(200, 600));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        frame.add(panel1, BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                JLabel picture;
                int number = Integer.parseInt(e.getActionCommand());
                picture = new JLabel(frame.loadImage("images\\" + frame.getPicturesNames()[number]));
                picture.setHorizontalAlignment(SwingConstants.LEFT);
                panel1.add(picture);
                panel1.revalidate();
                panel1.repaint();
            }
        };

        for (int i = 0; i < frame.getPicturesNames().length; i++)
        {
            buttons[i] = new JButton("Photo" + i);
            buttons[i].setMaximumSize(new Dimension(100, 60));
            buttons[i].setActionCommand(Integer.toString(i));
            buttons[i].addActionListener(actionListener);
            panel2.add(buttons[i]);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
