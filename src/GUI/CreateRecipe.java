package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class CreateRecipe {
    CreateRecipe(Panel newRecipe, JTextArea newRecipeTitle, JPanel newRecipePanel, JScrollPane scrollPane) {

        newRecipePanel.setLayout(new GridBagLayout());
        newRecipePanel.setBorder(LineBorder.createBlackLineBorder());

        newRecipe.setLayout(null);
        newRecipe.setVisible(true);
        newRecipe.setBounds(0, 0, 360, 500);

        newRecipeTitle.setBounds(35, 25, 200, 35);
        newRecipeTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
        newRecipe.add(newRecipeTitle);
        newRecipe.setBackground(Color.decode("#D5C7BC"));

        scrollPane.setBounds(35, 75, 220, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        newRecipePanel.setBounds(35, 75, 220, 300);
        scrollPane.getViewport().add(newRecipePanel);
        newRecipe.add(scrollPane);
    }
}
