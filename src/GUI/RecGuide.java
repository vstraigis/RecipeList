package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/*
    Creates a new frame for our guide when creating a recipe.
 */


public class RecGuide {

    JScrollPane scrollPane = new JScrollPane();
    JLabel label = new JLabel("Write your comments:");


    RecGuide(JFrame frame, JTextArea guideArea) {

        scrollPane.setBounds(25, 70, 250, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        guideArea.setBounds(25, 70, 250, 300);
        guideArea.setBorder(new LineBorder(Color.BLACK));
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(guideArea);

        label.setBounds(15, 5, 250, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));


        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(scrollPane);
        frame.add(label);
        frame.getContentPane().add(scrollPane);
    }

}
