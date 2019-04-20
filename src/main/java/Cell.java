import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JPanel {

    public Cell(ImageModel im, boolean isgridLayout) {
        ImageView iv = new ImageView(im);
        Rating rt = new Rating(im);
        JLabel name = new JLabel(im.getName());
        JLabel date = new JLabel(im.getCreationDate());

        JButton clear = new JButton("clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                im.setRating(-1);
            }
        });

        if (isgridLayout) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        } else {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }

        this.add(iv);
        iv.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel Infogroup = new JPanel();
        Infogroup.setLayout(new BoxLayout(Infogroup,BoxLayout.Y_AXIS));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        date.setAlignmentX(Component.CENTER_ALIGNMENT);
        rt.setAlignmentX(Component.CENTER_ALIGNMENT);
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);
        Infogroup.add(name);
        Infogroup.add(date);
        Infogroup.add(rt);
        Infogroup.add(clear);

        this.add(Infogroup);

        Border line = BorderFactory.createLineBorder(Color.GRAY);
        this.setBorder(line);

    }

    public void changeLayout(boolean isgridLayout) {
        if (isgridLayout) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        } else {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }
    }
}
