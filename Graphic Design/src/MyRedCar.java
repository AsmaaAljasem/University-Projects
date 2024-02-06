
// the import statements, we can't use the classe without importing them
import java.awt.*;
import java.awt.geom.AffineTransform; // we imported AffineTransform because we want to use it
import java.awt.geom.Area; // we also imported the Area class
import java.awt.geom.Ellipse2D; // Ellipse is so important too
import java.awt.geom.GeneralPath; // we can't draw our car without GeneralPath class, so we import it
import javax.swing.*;

/* 
in this class we want to draw a red car by using java
our class is named MyRedCar because my least significant number in my ID is 2, so i get the red car 
the class is public and it inhertes from the class JApplet, because i have to use some of it's method 
ro make my own car 
*/

public class MyRedCar extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // we made a frame by taking an object from the class JFrame
        JApplet applet = new MyRedCar();
        applet.init();
        // the name that will be written on the window that our graphic will be print on.
        frame.setTitle("20414512 - Asma Aljasem - Red Car"); 
        // in this line we are telling the program to delete the car from the memory once we close the drawing window
        // this is useful and important line because we don't want any unwanted data in the memory
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }// end of main

    public void init() {
        JPanel panel = new PanelMyRedCar();
        getContentPane().add(panel);
    } // end of init  
}//end of applet class

class PanelMyRedCar extends JPanel {

    public PanelMyRedCar() {
        // we set the size of the window
        setPreferredSize(new Dimension(820, 415));
    }

    // in this method we will write our code and it will print it.
    public void paintComponent(Graphics myG) // we took an object from the class Graphics and we named it myG.
   // the start of paintComponent method
    {
        super.paintComponent(myG); // we used the keyword super to sent our object to the father class
        Graphics2D its2DG = (Graphics2D) myG; // the object myG is from type Graphics so we used casting to make to from type Graphics2D

        /* we have a class called GeneralPath we need it to draw our car so 
        that's why we took an object from it and now we can use all the methods in the class*/
        
        GeneralPath theCarOuterBody = new GeneralPath(); // we named the object theCarOuterBody
        theCarOuterBody = new GeneralPath();
        // the following lines the program will draw them in black since we didn't choose another color
        // and black is initial color fro drawing in java
        theCarOuterBody.moveTo(18, 162); // the starting point
        
        // we need to draw a curve to draw the car so we used curveTo 
        // the curveTo Adds a curved segment, defined by three new points, to the path
        // we need to select three points to draw the curve
        // each point consist of two values, one for x coordinate and the second for y coordinate
        
        // point 1 has x = 50 & y = 100 , point 2 has x= 60 & y = 110 ,finally point 3 with x = 137 & y=92
        theCarOuterBody.curveTo(50, 100, 60, 110, 137, 92);
        // point 1 has x = 240 & y = 0 , point 2 has x= 410 & y = 0 ,finally point 3 with x = 490 & y=100
        theCarOuterBody.curveTo(240, 0, 410, 0, 490, 110);
        // point 1 has x = 520 & y = 120 , point 2 has x= 540 & y = 160 ,finally point 3 with x = 550 & y=200
        theCarOuterBody.curveTo(520, 120, 540, 160, 550, 200);
        // quadTo method adds a curved segment, defined by two new points, to the path by drawing a Quadratic curve 
        // quadTo takes two points the first is the control point, the secont is the point where we want to reach
        // 540 is on x for the control point and 200 is on y coordinate
        // 522 is on x coordinate for second point and 201 is on y coordinate
        theCarOuterBody.quadTo(540, 200, 522, 201);
        // now we will draw a line
        // the starting point is x=522,y=201 since it's the last point where we stoped on
        // the second point is x= 405,y=215
        //we will write only one point in the method and it's the second point where x= 405,y=215
        theCarOuterBody.lineTo(405, 215);
        // another line that starts from x= 405,y=215 and ends in x=143 , y=215
        theCarOuterBody.lineTo(143, 215);
        // a line from x=143 , y=215 to x=37,y=209
        theCarOuterBody.lineTo(37, 209);
        // here again we used the curveTo method and we selected three points
        // the three points we need are : two control points and the end point
        // the start point is the point where we lastly stoped and it wa x = 37 y=209
        // the control points are x= 28 y=195 and the second control point is x= 8 y=170
        // the end point is x = 14 y=160
        theCarOuterBody.curveTo(28, 195, 8, 170, 14, 160);
        /* here we closed our path and the program will initaly draw a  line
         between the first point we started at and the last point we draw*/
        theCarOuterBody.closePath();
        
        
        ///////////////////////////////////////////
        // our car has a thing so the driver can step on to ride the car so now we will draw it since it's required from us
        GeneralPath stepOn = new GeneralPath(); // we took another an object from the class generalPath
        stepOn = new GeneralPath();
        // we started withe moveTo method 
        // the moveTom method adds a point to the path by moving to the specified coordinate
        // we specified our point and it's x= 172 , y=200
        stepOn.moveTo(172, 200);
        // we are drawing a line that starts at point x= 172 , y=200 and ends at x=380 , y=200
        // as we see it's a horizontal line
        stepOn.lineTo(380, 200); 
        // we draw a quad with a control point and end point
        stepOn.quadTo(380, 206, 385, 213); 
        stepOn.lineTo(170, 213);
        stepOn.lineTo(172, 200);
        stepOn.closePath(); // we closed this part of drawing
        
        ///////////////////////////////////////////
        // now we will draw the glass window of the car
        GeneralPath leftWindow = new GeneralPath(); // we took an object
        leftWindow.moveTo(154, 96); // the start point for the glass window
        leftWindow.curveTo(200, 55, 280, 30, 331, 37); // we drew the curve of the window
        leftWindow.lineTo(326, 97);// a line, we will move from the last point we stopped on till the point x=327 , y=97 
        leftWindow.lineTo(154, 96); // the second line for compleating the window
        leftWindow.closePath(); // we finished the first window

        // now we will draw the second window that is on the right.
        GeneralPath rightWindow = new GeneralPath(); // taking an object from GeneralPath class and give it a name
        rightWindow.moveTo(347, 40); // the start
        rightWindow.curveTo(370, 40, 410, 43, 450, 96); // the curve, has 2 control points and one end point
        rightWindow.lineTo(347, 96); // drawing a line
        rightWindow.lineTo(347, 40); // drawing another line
        leftWindow.closePath(); // finishing the second window
/////////////////////////////////////////////////
           // in the asked question, the car has a light over it's tire and now we will draw it
        GeneralPath lightOver1 = new GeneralPath(); // taking an object to start
        lightOver1.moveTo(377, 200); // specifing the starting point
        lightOver1.quadTo(377, 140, 425, 125); // first quad , has only one control point
        lightOver1.quadTo(377, 145, 380, 200); // making another one  with also one control point
        lightOver1.lineTo(377, 200); // drawing a line
        lightOver1.closePath(); // finished
           // drawing the second light thar it's over the other tire
        GeneralPath lightOver2 = new GeneralPath(); // we needed an object so we took one
        lightOver2.moveTo(440, 131); // we started at point x= 440 y=131
        lightOver2.quadTo(490, 95, 526, 150); // a quad had a starting point x= 440 y=131 , control point x=490,y=95 , end point x=526 y=150 
        lightOver2.quadTo(490, 115, 435, 130); // another quad , it's the bottom one
        lightOver2.closePath();
/////////////////////////////////////////
        GeneralPath theInside = new GeneralPath();
        theInside = new GeneralPath();
        theInside.moveTo(420, 213);
        theInside.curveTo(400, 115, 520, 115, 526, 200);
        theInside.lineTo(515, 205);
        theInside.curveTo(490, 125, 440, 130, 440, 213);
        theInside.lineTo(420, 213);
        theInside.closePath();

////////////////////////////////////////////
            // no car without tires, and now we will draw our
        // we will user the class Eliipse2D since it's the better option to draw a circle    
        Ellipse2D tire1 = new Ellipse2D.Double(40, 140, 100, 100); // an object for the first tire
        Ellipse2D tire2 = new Ellipse2D.Double(420, 140, 100, 100); // an object for the second tire
        Ellipse2D ring = new Ellipse2D.Double(55, 155, 70, 70); // an object for the iron tire

        // inside the iron tire there are little circles so now we will draw them
        // we will use the class Ellipse2D
        // to take an object from Ellipse2D, we need to sepicify a starting point , the length and width
        Ellipse2D littleCircle1 = new Ellipse2D.Double(60, 170, 17, 12); //1st little circle
        Ellipse2D littleCircle2 = new Ellipse2D.Double(80, 160, 17, 12); //2nd little circle
        Ellipse2D littleCircle3 = new Ellipse2D.Double(100, 170, 17, 12); // 3rd little circle
        Ellipse2D littleCircle4 = new Ellipse2D.Double(105, 190, 17, 12); //4th little circle
        Ellipse2D littleCircle5 = new Ellipse2D.Double(70, 205, 17, 12); // 5th little circle
        Ellipse2D littleCircle6 = new Ellipse2D.Double(90, 205, 17, 12); // 6th little circle
        Ellipse2D littleCircle7 = new Ellipse2D.Double(60, 190, 17, 12); // 7th little circle

        /* we need the area class because we need to applay the subtract and union methods and we
        cant do it unless we convert our cicles that are from type Ellipse2D to areas from type Area*/
        Area makeItArea = new Area(ring); // an object from area class named makeItArea
        Area ac1 = new Area(littleCircle1); // the area 1 for the first little circle
        Area ac2 = new Area(littleCircle2); // the area 2 for the second little circle
        Area ac3 = new Area(littleCircle3); // the area 3 for the third little circle
        Area ac4 = new Area(littleCircle4); // the area 4 for the 4th little circle
        Area ac5 = new Area(littleCircle5); // the area 5 for the 5th little circle
        Area ac6 = new Area(littleCircle6); // the area 6 for the 6th little circle
        Area ac7 = new Area(littleCircle7); // the area 7 for the 7th little circle
 
        // we used the method subtract to do the little circles 
        makeItArea.subtract(ac1);
        makeItArea.subtract(ac2);
        makeItArea.subtract(ac3);
        makeItArea.subtract(ac4);
        makeItArea.subtract(ac5);
        makeItArea.subtract(ac6);
        makeItArea.subtract(ac7);

        // each car has lights to see the road , and here is our light
        // we will make it from class Eliipse2D
        Ellipse2D lightToSeeTheRoad = new Ellipse2D.Double(20, 120, 20, 30);
        /*we need AffineTransform class because it represents a general mapping from one coordinate system to another. 
        AffineTransform defines a general coordinate-system transformation that can include 
        translation, scaling, rotation, and shearing.*/
        AffineTransform place = its2DG.getTransform();// we took an object from this class
        AffineTransform myCut = new AffineTransform();
        myCut.setToShear(-1, 0);
        its2DG.translate(140, 0);

        its2DG.transform(myCut);
        myG.setColor(new Color(180, 180, 180)); // we are choosing the light of the car using RGB system
        its2DG.fill(lightToSeeTheRoad); // we filled it 
        its2DG.setTransform(place); // Restore transform

        // here we are makeing a color for the car
        // we are using RGB , the first value is for red , the second is for green, the last is for blue
        // since our car is red we made the value of the red high the others a low
        its2DG.setColor(new Color(230, 2, 2));
        //we filled our car
  its2DG.fill(theCarOuterBody);
        // now we are using the black color again
        its2DG.setColor(Color.black);

        its2DG.draw(theCarOuterBody); // we darw our car
        its2DG.setColor(new Color(63, 63, 63)); // we made the color gray red= 92, green=92, blue=92
  its2DG.fill(stepOn); // we filled the step-piece in gray
        its2DG.setColor(Color.black); // it's black again
        its2DG.draw(stepOn);

        its2DG.setColor(new Color(255, 255, 255)); // we made the color white by puttin red,green &blue to their highest value
  its2DG.fill(leftWindow); // we filled the window with white
        its2DG.setColor(Color.black); // bach agin with black
        its2DG.draw(leftWindow); // drawing just lines in black

        its2DG.setColor(new Color(255, 255, 255)); // again the color white for the 2nd window
  its2DG.fill(rightWindow); // we filled it
        its2DG.setColor(Color.black); // we made the color black
        its2DG.draw(rightWindow); // we made a black lines around it
  its2DG.fill(theInside);
        its2DG.draw(theInside);
        myG.setColor(new Color(0, 0, 0)); // making a color to fill the tires
   its2DG.fill(tire1); // filled our 1st tire
     its2DG.fill(tire2); // filled our 2nd tire
        its2DG.draw(tire1); // drew lines around 1st tire
        its2DG.draw(tire2); // drew lines around 2nd tire
        myG.setColor(new Color(192, 197, 201)); // a color for the iron tire

  its2DG.fill(makeItArea); // we filled it
        its2DG.draw(makeItArea); // we drew around it
        its2DG.translate(380, 0); // we moved it to the right place & getting another copy of the shape
  its2DG.fill(makeItArea); // it's filled now
        its2DG.draw(makeItArea); // it's surrounded now
        its2DG.translate(-380, 0);

        myG.setColor(new Color(255, 137, 137)); // almost pink color for the light that is over the tires
  its2DG.fill(lightOver1); // filled the 1st
   its2DG.fill(lightOver2); // filled the 2nd
        its2DG.draw(lightOver1); // we drew around it
        its2DG.draw(lightOver2); // we drew around it

        // changing the place & getting another copy of the shape
        its2DG.translate(-380, 0);
   its2DG.fill(lightOver2); // shape is filled
        its2DG.draw(lightOver2);
        its2DG.translate(380, 0);
        myG.setColor(new Color(0, 0, 0)); // back to black.
        
        myG.setFont(new Font("Times New Roman",Font.BOLD,30));
        its2DG.drawString("Student Name: Asmaa Aljasem  ID: 20414512", 200, 300);

    } //end of panel class
} // end of program

