package swingdemo;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class SwingPlayer extends JPanel implements MouseListener, MouseMotionListener{
   private boolean curo;
      SwingPlayer(String filename){
      this.setSize(40,40);
      JLabel label=new JLabel();
      ImageIcon img = new ImageIcon(filename);
      label.setIcon(img);
      this.add(label);
   }  

      public void mouseEntered(MouseEvent e){
         this.curo=true;
      }

      public void mouseExited(MouseEvent e){
         this.curo=false;
      }

      public void mouseDragged(MouseEvent e){
         if (this.curo==true){
            this.setLocation(e.getX(), e.getY());
         }
      }

      public void mouseMoved(MouseEvent e){}
      public void mouseClicked(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
      public void mousePressed(MouseEvent e){}
}
//   public static void main(String[] args){
 //  JFrame frame=new Jframe();
//   frame.setsize(400,400);
//   frame.add(new SwingPlayer("bluepip.png"));
//   frame.setDefaultCloseOperator(JFrame.CLOSE_ON_EXIT());
//   frame.setVisible(true);
//   }
//}
