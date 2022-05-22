package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateRecipe {
    CreateRecipe(Panel newrcp, JTextField newRecipeTitle, JPanel newRcpPanel){
        newrcp.setLayout(null);
        newrcp.setVisible(true);
        newrcp.setBounds(0,0,360, 500);

        newRecipeTitle.setBounds(35, 25, 200, 35);
        newRecipeTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
        //newRecipeTitle.setBackground(Color.LIGHT_GRAY);
        newrcp.add(newRecipeTitle);
        newrcp.setBackground(Color.decode("#D5C7BC"));

        newRcpPanel.setBounds(35, 75, 220, 300);
        newrcp.add(newRcpPanel);


    }
}
