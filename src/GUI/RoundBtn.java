// Could use this class to round a specific button with:
// buttonname.setBorder(new RoundBtn(15)); 15 is the radius of the curve


package GUI;

import javax.swing.border.Border;
import java.awt.*;

public class RoundBtn extends Rectangle implements Border {

    private int r;
    RoundBtn(int r) {
        this.r = r;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}