package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/*
    Creating the frame when we press CreateRecipe.
 */

public class CreateRecipe {
    CreateRecipe(Panel newrcp, JTextField newRecipeTitle, JPanel newRcpPanel, JScrollPane scrollPane) {

        newRcpPanel.setLayout(new GridBagLayout());
        newRcpPanel.setBorder(LineBorder.createBlackLineBorder());

        newrcp.setLayout(null);
        newrcp.setVisible(true);
        newrcp.setBounds(0, 0, 360, 500);

        newRecipeTitle.setBounds(35, 25, 200, 35);
        newRecipeTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
        newrcp.add(newRecipeTitle);
        newrcp.setBackground(Color.decode("#D5C7BC"));

        scrollPane.setBounds(35, 75, 220, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        newRcpPanel.setBounds(35, 75, 220, 300);
        scrollPane.getViewport().add(newRcpPanel);
        newrcp.add(scrollPane);
    }
}
