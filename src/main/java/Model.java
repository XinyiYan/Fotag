
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.*;
import java.util.List;

public class Model {
    /** The observers that are watching this model for changes. */
    private List<Observer> observers;
    private ArrayList<ImageModel> uploadedImages;
    private ArrayList<ImageModel> imagesDisplayed;
    private ArrayList<Cell> cells;


    private boolean gridView = true;

    private JFileChooser jfc = new JFileChooser();
    private int filterby = -1;

    private File file = new File("./state.bin");

    private int scrollPaneWidth;


    /**
     * Create a new model.
     */
    public Model() {

        this.observers = new ArrayList();
        this.uploadedImages = new ArrayList<>();
        this.imagesDisplayed = new ArrayList<>();
        this.cells = new ArrayList<>();

        this.load();


        jfc.setDialogTitle("Select image(s)");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image", "png","jpg");
        jfc.addChoosableFileFilter(filter);
    }

    /**
     * Add an observer to be notified when this model changes.
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Notify all observers that the model has changed.
     */
    public void notifyObservers() {
        for (Observer observer: this.observers) {
            observer.update(this);
        }
    }


    public void setGridView(boolean t) {
        this.gridView = t;
        for (Cell cell : cells) {
            cell.changeLayout(t);
        }

        notifyObservers();

    }

    public void loadImage() {
        int ret = jfc.showOpenDialog(null);

        if(ret == JFileChooser.APPROVE_OPTION) {
            File[] files = jfc.getSelectedFiles();

            for (File selectedFile : files) {
                ImageModel image = new ImageModel();
                image.createImage(selectedFile);

                this.uploadedImages.add(image);

                if (this.filterby < 0) {
                    this.imagesDisplayed.add(image);
                    Cell newcell = new Cell(image, this.gridView);
                    this.cells.add(newcell);
                }
            }
            notifyObservers();

        }
    }

    public void setFilter(int val) {
        this.filterby = val;
        this.imagesDisplayed.clear();
        this.cells.clear();


        for (ImageModel i : uploadedImages) {
            if (val < 0) {
                this.imagesDisplayed.add(i);
                Cell newcell = new Cell(i, this.gridView);
                this.cells.add(newcell);
            } else {
                if (i.getRating() >= val) {
                    this.imagesDisplayed.add(i);
                    Cell newcell = new Cell(i, this.gridView);
                    this.cells.add(newcell);
                }
            }
        }
        notifyObservers();
    }

    public int getFilterby() {
        return this.filterby;
    }


    public ArrayList<Cell> getCells() {
        return cells;
    }


    public int getColumns() {
        if (gridView) {
            int cols = Math.min(scrollPaneWidth / 358, imagesDisplayed.size());
            cols = Math.max(cols,1);
            return cols;
        } else {
            return 1;
        }
    }

    public void save() {
        try {
            ObjectOutputStream writeTo = new ObjectOutputStream(new FileOutputStream(file));

            writeTo.writeObject(uploadedImages);

            writeTo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void load() {
        try {
            ObjectInputStream readIn = new ObjectInputStream(new FileInputStream(file));

            uploadedImages = (ArrayList<ImageModel>)readIn.readObject();

            readIn.close();

            for (ImageModel i : uploadedImages) {
                i.createImage(new File(i.getPath()));
                imagesDisplayed.add(i);
                Cell newcell = new Cell(i, this.gridView);
                this.cells.add(newcell);
            }

            notifyObservers();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setScrollPaneWidth(int d) {
        scrollPaneWidth = d;
        notifyObservers();
    }

}
