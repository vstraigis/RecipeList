package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CreateButton {

    JButton createSimpleButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(210, 100, 100));
        button.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setFocusable(false);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        // button.setBorder(compound);
        return button;
    }
}