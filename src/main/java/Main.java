import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Fotag");

        Model model = new Model();

        JToolBar mytoolbar = new ToolBar(model);

        ImageCollectionView displayArea = new ImageCollectionView(model);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.add(mytoolbar, BorderLayout.NORTH);
        panel.add(scrollPane,BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                model.save();
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Dimension newSize = scrollPane.getViewport().getSize();
                model.setScrollPaneWidth(newSize.width);
            }
        });

        frame.getContentPane().add(panel);
        frame.setMinimumSize(new Dimension(600, 450));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
