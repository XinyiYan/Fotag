import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ImageView extends JPanel implements Observer{

    private ImageModel imageModel;

    private Dimension imageDim = new Dimension(300, 250);


    public ImageView(ImageModel imodel) {

        this.imageModel = imodel;
        this.imageModel.addObserver(this);

        this.setPreferredSize(imageDim);
        this.setMaximumSize(imageDim);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ImageIcon enlarge = new ImageIcon(imageModel.getData().getScaledInstance(600,500,Image.SCALE_SMOOTH));
                String name = imodel.getName();
                JOptionPane.showMessageDialog(ImageView.this, new JLabel(enlarge), name, JOptionPane.PLAIN_MESSAGE);
            }
        });

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imageModel.getData(), 0, 0, getWidth(), getHeight(), this);
        this.revalidate();
    }



    public void update(Object observable) {
       // System.out.println("ImageView");
    }
}
