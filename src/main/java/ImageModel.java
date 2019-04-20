import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageModel implements Serializable {

    private String path;
    private int rating;
    private String creationDate;
    private String name;
    private transient BufferedImage data;
    private transient List<Observer> observers;

    public ImageModel() {
        this.observers = new ArrayList();
        this.rating = -1;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        creationDate = dateFormat.format(date);

    }

    /**
     * Add an observer to be notified when this model changes.
     */
    public void addObserver(Observer observer) {
        if (this.observers == null) {
            this.observers = new ArrayList();
        }
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

    public void createImage(File f) {
        this.path = f.getPath();
        this.name = f.getName();

        if (this.name.length() > 10) {
            this.name = this.name.substring(0,9) + "...";
        }

        try {
            this.data = ImageIO.read(f);
        } catch (IOException e) {
        }
    }

    public  BufferedImage getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setRating(int r) {
        rating = r;
        notifyObservers();
    }

    public String getPath() {
        return path;
    }

}
