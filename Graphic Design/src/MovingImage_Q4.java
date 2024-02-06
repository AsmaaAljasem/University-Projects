/* in this class we will draw a circle that we can see how it's drawing 
and with image moves as the circle is been drawn then the whole action will be reapeted till we close the window*/
// here we imported all the libraries wa want to use classes from
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

// the start of our class
// we drfined it by writing the key word class
// then we gave it a name which is MovingImage_Q4
// it's a subclass from JPanel and uses the ActionListener interface
public class MovingImage_Q4 extends JPanel implements ActionListener {
    // here we declared a variable from double type and we put a number in it
    // the number repreasents the value of the radius, since we know that each circle has a radius so this variable is the radius
    // we chose a value of the radius and by this value we can control the size of the circle
    // if the value is big, then the circle is big, if the value is small then the circle is small
    private double radius1 = 247; // radius should be big value to draw a big circle
    // here we defiend a variable for the number of the points of our circle and we put it zero because we will give it later another value
    private int numberOfThePoints = 0;  
     /* we took an object from Timer class and we give it the speed of our drawing circle
    if the value was high then the drawing will be slow so we chose a suitable value*/
    Timer circleTime = new Timer(36, this);  
  
    public MovingImage_Q4() {
        circleTime.start(); // we are telling the timer to start, without it it won't work
    } // end of method
    
    // now the paintComponent method to write our code in
    // as needed, we took an object from Graphics class and named it aGobj
    public void paintComponent(Graphics aGobj) {
        super.paintComponent(aGobj);
        // we casted aGobj , we made it from type Graphics to type Graphics2D and it's name now the2DGraph
        Graphics2D the2DGraph = (Graphics2D) aGobj;
        the2DGraph.translate(337,266); // we translated to the point x=337 y=266 to start drawing our circle from there
 
        // we are asked in the tma to use an image that maves as we draw the circle so here we are putting the image
        BufferedImage myPhoto = null;
        try {
            myPhoto = ImageIO.read(new File("myFlower.jpg")); // here we wrote the path of our image
        } // end of try
        // incase we faced an error
        catch (IOException anError) {
        } // end of catch
        int coordinateForX1 = (int) radius1; // we defined x1 and stored the raduis in it after we cast it to int type, because radius from double type
        int coordinateForY1 = 0; // y is 0 as an initial value
        int coordinateForStartingX =(int)  radius1; // the point where we will start to draw
        int coordinateForStartingY = 0; // it's y coordinate
        int coordinateForX2; int coordinateForY2; // point 2 (x2,y2) we will give them a value in the for loop
        // we want to draw many points to make them seem a circle so we need a for loop
        for (int zCounter = 0; zCounter < numberOfThePoints; zCounter++) {
            double tWithValue = zCounter / (Math.PI * 2); // here's the value of T , from the question
            coordinateForX2 = (int) ((radius1) * Math.cos(tWithValue)); // x for point 2, we casted the result to int because the value of t is double
            coordinateForY2 = (int) ((radius1) * Math.sin(tWithValue)); // y for point 2, we casted the result to int because the value of t is double
            the2DGraph.drawLine(coordinateForX1, coordinateForY1, coordinateForX2, coordinateForY2); // for drawing the circle
            // we will start the next first point from the last point we stopped at which wae the point 2
            coordinateForX1 = coordinateForX2; coordinateForY1 = coordinateForY2;
        } // end of for loop
        the2DGraph.drawLine(coordinateForStartingX, coordinateForStartingY, coordinateForX1, coordinateForY1); // for drawing the line that show the drawing of the circle
        the2DGraph.drawImage(myPhoto, coordinateForX1, coordinateForY1, this); // our image will move with point 1

    }
    // now we need to override the actionPerformed method to do the animation
    public void actionPerformed(ActionEvent obj) {
       theMovement(); // the method were we draw the circle, here it will be able to be drawn again
        repaint(); // will keep repeating the drawing action till we close the window
    } // the end of overriden method

    // in this method we will write the number of points that are needed to complete the circle
    public void theMovement() {
        if (numberOfThePoints <= 120.5) // the number of points is 120.5 , this will draw the circle 3 times
        {
            numberOfThePoints += 1;
        } // end of if
        else {
            numberOfThePoints = 0; // after the number of points become greater than 12.5 it'll be reset to zero
        } // end of else
    } // end of theMovement method

    // the main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Asma Aljasem , moving circle");
                MovingImage_Q4 asm = new MovingImage_Q4();
                frame.add(asm); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // once we close, the data will be removed from memory
                frame.setSize(989, 996); // the size of the window that we will draw our project on
                frame.setVisible(true); // and it's surely visible
            } // end of run method
        });// end of runnable
    } // end of main method
} // end of the whole class

