package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class RecGuide {

    JFrame frame = new JFrame();
    JTextArea comments = new JTextArea("my guide goes here");
    JScrollPane scrollPane = new JScrollPane();
    JLabel label = new JLabel("Write your comments:");

    RecGuide(){

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

        scrollPane.setBounds(25, 70, 250, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        comments.setBounds(25, 70, 250, 300);
        comments.setBorder(new LineBorder(Color.BLACK));
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(comments);

        label.setBounds(15, 5, 250, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(scrollPane);
        //frame.add(comments);
        frame.add(label);

       // frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(scrollPane);
    }
}
