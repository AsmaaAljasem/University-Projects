// the import statements are used to allow us to use the libraries in java
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
// our class name is EditPictuer_Q1, it extends the JApplet class (JApplet is the father class)
public class EditPictuer_Q1 extends JApplet {
    // main method
    public static void main(String[] args) {
        JFrame usedFrame = new JFrame(); // we took an object from the class JFrame and its name is usedFrame
        usedFrame.setTitle("Asmaa Aljasem ,Edit on image"); // we gave the frame a title
        usedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this method will delete all the data from the memory when we are done
        JApplet usedApplet = new EditPictuer_Q1(); // the usedApplet is an object from the class JApplet that our class inheretes of.
        usedApplet.init();
        usedFrame.getContentPane().add(usedApplet); // we add them together
        usedFrame.pack();
        usedFrame.setVisible(true); // and made it visible
    } // end of the main method
    public void init() {
        JPanel usedPanel = new JAppEditPictuer_Q1(); // an object from JPanel we called it usedPanel
        getContentPane().add(usedPanel); // we added the panel to the frame & applet
    } // end of method init
} // end of the class
class JAppEditPictuer_Q1 extends JPanel {
    public JAppEditPictuer_Q1() {
        setPreferredSize(new Dimension(987, 700)); // the dimention of the winow that we will print the photos on
    } // end of method
    
    // the paintComponent method now will be used to write the code inside it
    public void paintComponent(Graphics usedG) // we took an object from the class Graphics and named it usedG
    {
        super.paintComponent(usedG);
        Graphics2D used2DG = (Graphics2D) usedG; // we changed the usedG from type graphics to type Graphics2D
        /////////////////اخذ اوبجكت وعرض الصورة داخل البرنامج /////////////////////
        BufferedImage theBasePicture = null; // we prepared an object from the class BufferedImage
        try {
            theBasePicture = ImageIO.read(new File("images.jpeg")); // we stored the wanted image inside the object
        } // end of try 
        catch (IOException anError) {
        } // end of catch
        used2DG.drawImage(theBasePicture, 0, 50, this); // now we will print the image exactly as it is without any edit
        usedG.setFont(new Font("Times New Roman",Font.BOLD,20)); // styling my font
        used2DG.drawString("1: Nothing changed", 5, 39); // to inform you what happend
        
         // now we want to make another photo but without noise, so we will apply a the mask
        float[] arrayNoise = {1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
             1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f}; // we made an array to applay the mask, numbers were taking from the slide
        Kernel helpOfKernel = new Kernel(3, 3, arrayNoise); // we took an object to applay the mask on image to remove the noise
        ConvolveOp helpOfConvol = new ConvolveOp(helpOfKernel); // we took an object from the class ConvolOp, now we are ready to print
        BufferedImage picWithoutNoise = helpOfConvol.filter(theBasePicture, null); // we copied our orginal image
        used2DG.drawImage(picWithoutNoise, 0, 266, null);//draw smooth image
        used2DG.drawString("2: Noise deleted", 5, 250); // to inform you about the change


        // now we will apply another filter that will only change the color 
        // choosing the colors and storing the data in the variable convertColors that's from typeRescaleOp     
        RescaleOp convertColors = new RescaleOp(-1.5f, 255f, null); 
        BufferedImage convertedPic= convertColors.filter(theBasePicture,null); // now we put the filter on the image after we took acopy from the orginal image
        used2DG.drawImage(convertedPic, 250,50, this);  // drawing the image
        used2DG.drawString("3: Invertered ", 255, 39); // to inform you what happend
        
        // we want to make the image in only black and white.
        ColorSpace grayColor = ColorSpace.getInstance(ColorSpace.CS_GRAY); // calling the color method
        ColorConvertOp grayIsReady = new ColorConvertOp(grayColor, null); // making the filter
        BufferedImage picinGray = grayIsReady.filter(theBasePicture, null);// takes a copy from orginal pic & makes it in black and white colors
       used2DG.drawImage(picinGray, 250, 266, null);//draw the image 
       used2DG.drawString("4: Changed to black & white", 250, 250); // to inform you about the change  
       
        // since it's reqired from us to shear the image, we need the class AffineTransform
        AffineTransform toShearToX = new AffineTransform(); // we took an object to use it to shear
        // we want to shear to x so we will give x only a value
        toShearToX.setToShear(0.34, 0); // x value should be between 0 to 1
        
        AffineTransformOp forX= new AffineTransformOp(toShearToX, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage picShearedToX = forX.filter(theBasePicture, null); // taking a copy from the orginal pic
        used2DG.drawImage(picShearedToX, 530,50, this); // drawing the sheared pic
        used2DG.drawString("5: Image sheared to X ", 530, 39); // to inform you what happend

        // now we will shear the photo again but to y
        AffineTransform toShearToY = new AffineTransform(); // an object to make the shearing success
        toShearToY.setToShear(0, 0.34); // we gave y a vlaue between 0 to 1 and made x 0
        
        AffineTransformOp forY= new AffineTransformOp(toShearToY, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage shearedim2 = forY.filter(theBasePicture, null); // we copied the orginal pic to shear it
        used2DG.drawImage(shearedim2,  560, 266, this); // to draw the sheared to y pic
        used2DG.drawString("6: Image sheared to Y", 560, 250); // to inform you about the change
        
        // to zoom the image and change it's size
        AffineTransform toZoom = new AffineTransform(); // object from AffineTranfrom to zoom 
        toZoom.setToScale(1.6, 0.88); // zooming values
        AffineTransformOp zoomedPic= new AffineTransformOp(toZoom, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage shearedim3 = zoomedPic.filter(theBasePicture, null); // copying the orginal pic then zoom it
        used2DG.drawImage(shearedim3, 320,511, this); // drawing zoomed pic
        used2DG.drawString("7: The zoomed image: ", 100, 540); // to inform you about the change
        
        // now we want to save one of the pictures we made
        BufferedImage imageToSave = new BufferedImage(444,444,BufferedImage.TYPE_INT_RGB); // first we need an object
        try{
        
            File theSavedImage = new File ("mySavedPicture.jpg"); // then we name the picture an store it in type File
            ImageIO.write(picinGray, "jpg", theSavedImage); // we choose the picture we want from the pre 7 picture in the method that will make the picture
        }// end of try
        catch (IOException theError){}// end of catch
                
        
     
       
    }

}// end of JApp1Panel class

