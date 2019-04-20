import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ImageCollectionView extends JPanel implements Observer{

    Model model;


    public ImageCollectionView(Model m) {
        this.model = m;
        this.model.addObserver(this);

        this.setLayout(new GridLayout(0,this.model.getColumns()));

    }


    public void update(Object observable) {

        this.removeAll();
        this.setLayout(new GridLayout(0,this.model.getColumns()));
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ArrayList<Cell> cells = this.model.getCells();

        for(Cell cell : cells) {
            this.add(cell);
        }

        this.revalidate();

    }


}
