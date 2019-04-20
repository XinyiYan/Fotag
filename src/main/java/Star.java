import javax.swing.*;
import java.awt.*;

public class Star extends JButton {
    private ImageIcon white = new ImageIcon("src/whitestar.png");
    private ImageIcon yellow = new ImageIcon("src/yellowstar.png");

    private boolean isfilled;
    private int pos;

    public Star(boolean t, int p) {
        this.isfilled = t;
        this.pos = p;

        if (this.isfilled) {
            this.setIcon(this.yellow);
        } else {
            this.setIcon(this.white);
        }

        this.setPreferredSize(new Dimension(30, 30));
    }

    public void setState(boolean t) {
        isfilled = t;
        //repaint();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.isfilled) {
            this.setIcon(yellow);
        } else {
            this.setIcon(white);
        }

        this.revalidate();
    }

    int getPos() {
        return this.pos;
    }


}
