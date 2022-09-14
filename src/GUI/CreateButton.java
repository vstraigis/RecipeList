package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateButton {

    JButton createSimpleButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(210, 100, 100));
        button.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setFocusable(false);
        return button;
    }
}