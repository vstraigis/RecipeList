package GUI;

import javax.swing.border.Border;
import java.awt.*;

public class RoundButton extends Rectangle implements Border {

    private int button;

    RoundButton(int button) {
        this.button = button;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.button + 1, this.button + 1, this.button + 2, this.button);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component component, Graphics graphics, int x, int y,
                            int width, int height) {
        graphics.drawRoundRect(x, y, width - 1, height - 1, button, button);
    }
}