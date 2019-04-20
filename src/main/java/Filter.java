import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Filter extends JPanel implements Observer {
    private Star[] stars = new Star[5];
    private Model model;


    public Filter(Model model) {
        this.model = model;
        this.model.addObserver(this);

        for (int i = 0; i < 5; ++i) {
            stars[i] = new Star(false, i);
            stars[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setFilter(((Star)e.getSource()).getPos());
                }
            });
            this.add(stars[i]);
        }


    }

    public void update(Object observable) {
        int val = this.model.getFilterby();
        if (val < 0) {
            for (int i = 0; i < 5; ++i) {
                stars[i].setState(false);
            }
        } else {
            for (int i = 0; i <= val; ++i) {
                stars[i].setState(true);
            }
            for (int i = val + 1; i < 5; ++i) {
                stars[i].setState(false);
            }
        }

        this.revalidate();
        this.repaint();
    }


}
