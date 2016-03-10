package swingdemo;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class SwingPlayer extends JPanel implements MouseListener, MouseMotionListener{
   private boolean curo;
	private JLabel label;
	private JFrame master;
      SwingPlayer(String filename, JFrame M){
		this.master=M;
      this.setSize(40,40);
      this.label=new JLabel();
      ImageIcon img = new ImageIcon(filename);
      label.setIcon(img);
      this.add(label);
		this.setVisible(true);
		label.setVisible(true);
   }  

      public void mouseEntered(MouseEvent e){
         this.curo=true;
      }

      public void mouseExited(MouseEvent e){
         this.curo=false;
      }

      public void mouseDragged(MouseEvent e){
         if (this.curo==true){
            this.label.setLocation(e.getX(), e.getY());
				this.master.pack();
         }
      }
      public JLabel getLabel(){
			return this.label;
		}
      public void mouseMoved(MouseEvent e){}
      public void mouseClicked(MouseEvent e){
		   this.label.setLocation(30,30);
		}
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
