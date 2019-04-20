import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar implements Observer {

    private Model model;

    private JButton gridButton = new JButton("");
    private JButton listButton = new JButton("");
    private JButton upload = new JButton("");
    private JButton clearFilter = new JButton("clear");

    private ImageIcon gridIcon = new ImageIcon("src/grid1.png");
    private ImageIcon listIcon = new ImageIcon("src/list1.png");
    private ImageIcon uploadIcon = new ImageIcon("src/import.png");


    public ToolBar(Model model) {
        this.model = model;
        this.model.addObserver(this);

        gridButton.setIcon(gridIcon);
        gridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setGridView(true);
            }
        });

        listButton.setIcon(listIcon);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setGridView(false);
            }
        });

        JLabel fotag = new JLabel("Fotag!");

        upload.setIcon(uploadIcon);
        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.loadImage();
            }
        });

        clearFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setFilter(-1);
            }
        });

        Filter myfilter = new Filter(model);

        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.add(gridButton);
        p1.add(Box.createRigidArea(new Dimension(15,40)));
        p1.add(listButton);
        p1.add(Box.createRigidArea(new Dimension(15,40)));
        p1.add(upload);
        p1.add(Box.createRigidArea(new Dimension(20,40)));
        this.add(p1, BorderLayout.WEST);

        fotag.setHorizontalAlignment(JLabel.CENTER);
        this.add(fotag, BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        JLabel text = new JLabel("Filter by:");
        p2.add(text);
        p2.add(myfilter);
        p2.add(Box.createRigidArea(new Dimension(2,25)));
        p2.add(clearFilter);
        this.add(p2, BorderLayout.EAST);


    }

    public void update(Object observable) {
        //System.out.println("Tool bar Model changed!");
    }
}