// the import statements, we can't use a class developed in java without importing it from the library
// we write the key word import then the name of what we want to use

import javax.swing.JFrame;
import java.awt.geom.Ellipse2D;
import javax.swing.JApplet;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.GeneralPath;
// the class is public which means it can be used any where in the packages
// we wrote the key word class because we can't make a class without it and after writing the key word class we named our class
// the class inheartes from the class JApplet because we want to use the class JApplet in this class
public class RepeatedDraw_Q3 extends JApplet 
/*the start of the class*/{
   public static void main(String[] args) {
        JApplet theAppLet = new RepeatedDraw_Q3(); // mw made a variable from type JApplet and stored in it an object from our class
        JFrame theNeededFrame = new JFrame(); // we took an object from class JFrame
        theNeededFrame.getContentPane().add(theAppLet); // the frame and the applet are now together by the methods add() and getContentPane
        theAppLet.init();
        theNeededFrame.setTitle("Asma aljasem question 3"); // we wrote a title 
        theNeededFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this will delete the data from the memory once we close
        theNeededFrame.pack();
        theNeededFrame.setVisible(true); 
    }// end of main method

    public void init() {
        JPanel myPanel = new PanelRepeatedDraw_Q3();
        getContentPane().add(myPanel);
    } // end of method

}// end of class

class PanelRepeatedDraw_Q3 extends JPanel {

    public PanelRepeatedDraw_Q3() {
        setPreferredSize(new Dimension(744, 511)); // the domination for our drawing window
    } 
    
    // we are using the paintComponent method and here we will write our code
    public void paintComponent(Graphics ofg) // it's named ofg as a shortcut of Object from Graphics
       // the start for our method
       {
        super.paintComponent(ofg); // we used the word super to send our obect to a method in the father class
        Graphics2D my2dGraph = (Graphics2D) ofg; // we conevert the ofg and made from type Graphics2D by useing Casting
        my2dGraph.translate(322, 188); // we stepped away from the starting point and now our new starting point is x = 200 y=200
       
        my2dGraph.setColor(new Color(155,100,133)); // we changed the color , because i want to ^.^
        int numberOfPoints = 300000; // here we chose the number of points we wnat the program to draw
        int size = 55; // the size of our drawing, if it's big value the drawing will be big, if it's small value it will be small
        int x1Coordinate = 0; // x coordinate for the first point
        int y1Coordinate = 0; // y coordinate for the first point
        int x2Coordinate, y2Coordinate; // the the coordinates for the second point will be specified inside the for loop
        GeneralPath pathBody = new GeneralPath(); // we took an object from the class Genearal path to start our drawing
        pathBody.moveTo(x1Coordinate, y1Coordinate); // the drawing will start from the first point where x =0 and y=0
        // we need to repeat drawing the points so the best way is using for loop
        // the loop will keep drawing till it ends the number of points we want
        for (int counter = 0; counter < numberOfPoints; counter++) 
        // it will start from point 0 and each time it will be increased by one till the loop draws 300000 point as we wanted
        /*the start of for loop*/{
            // we declared the value of t as it's in the question
            // we multiplied 12 with 7 to make the drawing thick
            // we used math.pi to get the value of pi 
            double tValue = counter * 7 * 12 * Math.PI / numberOfPoints;
            // here we are getteing the values for the second point by applying the function we took from the question.
            // we casted the result to int because the variables is from type int 
            x2Coordinate = (int) (size * Math.sin(tValue) * (Math.exp(Math.cos(tValue)) - 2 * Math.cos(4 * tValue) - Math.pow(Math.sin(tValue / 12), 5)));
            y2Coordinate = (int) (size * Math.cos(tValue) * (Math.exp(Math.cos(tValue)) - 2 * Math.cos(4 * tValue) - Math.pow(Math.sin(tValue / 12), 5)));
            // here we got our second point and now a line will be drawen betwwen the two points
            pathBody.lineTo(x2Coordinate,y2Coordinate);
            // the loop will keep drawing small lines till it end all the points required
        }
                my2dGraph.draw(pathBody); // here we drew the shape
                
                        // we clipped the shape because we need to put noise through it and the easiest way to do it is be using cliping
         my2dGraph.setClip(pathBody); 
                 // at the begening we translated to the point x = 322 y=188
                 // now we are turning back to the orginal point to draw the noise
                 my2dGraph.translate(-322, -188); // getting back to the orginal point where x=0 y=0
              // the for loop is to draw many small circles
          for (int counteNoise = 0; counteNoise < 8000; counteNoise++) {
              // we will draw small circles that will seem as if they are points
              // we will draw then by using Ellipse2D
              /* we want our little circles with a small x and y coordinates and also with
              diffrente valuse for each point so that's we we used the math.random and multiply it with 711 , 520
              because math.random brings a number that is between 0 and 1 */
            Shape aNoise = new Ellipse2D.Double(Math.random() * 711,
                    Math.random() * 520, 1.8, 1.8); 
                   /* the loop will draw each circle in a width = 1.8 and a highet = 1.8 and that's how
                   we made the circles seem so small as if they are points*/
                  
            my2dGraph.draw(aNoise); // we draw the noise and the graph is complete
            
        } // end of for loop 
         
    
    } // end of method paint component
} // end of class