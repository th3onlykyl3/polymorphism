import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.*;

/**
   A test program for the basic shape program
   (before adding the interesting buttons)
*/
public class BasicShapeFrameTest
{
   public static void main(String[] args)
   {
      ShapeFrame frame = new ShapeFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WIDTH, HEIGHT);
      frame.setTitle("BasicShapeFrameTest");
      
      compoundShape cs = new compoundShape();
      cs.addShape(new Rectangle2D.Double(10,10,50,30));
      cs.addShape(new Ellipse2D.Double(30,30,40,40));
      cs.addShape(new Line2D.Double(0,0,60,60));
      
      frame.addShape(cs);

      frame.addShape(new Rectangle2D.Double(0.0, 0.0, 20.0, 30.0));
      frame.addShape(new Ellipse2D.Double(0.0, 0.0, 30.0, 30.0));
      frame.addShape(new Line2D.Double(0.0, 0.0, 30.0, 30.0));
      

      frame.setVisible(true);
   }

   public static final int WIDTH = 300;
   public static final int HEIGHT = 300;
}













