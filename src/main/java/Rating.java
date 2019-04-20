import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rating extends JPanel implements Observer {
    private Star[] stars = new Star[5];
    private ImageModel imodel;



    public Rating(ImageModel model) {
     //   this.setBackground(Color.CYAN);
        this.setMaximumSize(new Dimension(200,50));
        this.imodel = model;
        this.imodel.addObserver(this);

        int rating = model.getRating();
        if (rating < 0) {
            for (int i = 0; i < 5; ++i) {
                stars[i] = new Star(false, i);
                stars[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setRating(((Star)e.getSource()).getPos());
                    }
                });
                this.add(stars[i]);
            }
        } else {
            for (int i = 0; i <=rating; ++i) {
                stars[i] = new Star(true, i);
                stars[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setRating(((Star)e.getSource()).getPos());
                    }
                });
                this.add(stars[i]);
            }

            for (int i = rating + 1; i < 5; ++i) {
                stars[i] = new Star(false, i);
                stars[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setRating(((Star)e.getSource()).getPos());
                    }
                });
                this.add(stars[i]);
            }
        }



    }

    public void update(Object observable) {
        int val = this.imodel.getRating();
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
