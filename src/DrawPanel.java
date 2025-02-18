import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage volvoImage;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;
    ArrayList<BufferedImage> carImages = new ArrayList<>();

    Map<Car, Point> carPositions = new HashMap<>();


    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    void addCarToDictionary(Car car, Point coords){
        carPositions.put(car,coords);
    }

    void moveit(Car car, int x, int y){
        Point point = carPositions.get(car);
        point.x = x;
        point.y = y;
    }

    // OBJ(saab) : Point(0,100)
    // carPositions.get(OBJ(saab))


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // TODO: loop through image

        for (Car car : carPositions.keySet()){
            BufferedImage carImage = null;
            try{
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream(car.getImageDirectory()));
            }catch (IOException ex)
            {
                ex.printStackTrace();
            }
            if(!car.isLoaded()) {
                g.drawImage(carImage, carPositions.get(car).x, carPositions.get(car).y, null);
            }
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
