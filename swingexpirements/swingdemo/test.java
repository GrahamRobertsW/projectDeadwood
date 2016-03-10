package swingdemo;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class test extends JFrame implements MouseListener, MouseMotionListener{
	JLayeredPane layers;
	JLabel pip;
	JPanel deadBoard;

   //public static void main(String[] args){
   //JFrame frame=new JFrame();
	//frame.setLayout(new FlowLayout());
   //frame.setSize(400,400);
	//JPanel pan = new JPanel();
	//pan.setLayout(new FlowLayout());
	//pan.setVisible(true);
	//SwingPlayer lab = new SwingPlayer("bluepip.png", frame);
	//pan.add(lab.getLabel());
   //frame.getContentPane().add(pan);
   //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  // f//rame.setVisible(true);
   //}
	public test(){
		layers=new JLayeredPane();
		this.getContentPane().add(layers);
		layers.addMouseListener(this);
		layers.addMouseMotionListener(this);
		deadBoard=new JPanel();
                layers.add(deadBoard, JLayeredPane.DEFAULT_LAYER);
                JLabel piece = new JLabel( new ImageIcon("bluepip.png"));
                JPanel panel = (JPanel) deadBoard.getComponent(0);

        }
        
        public static void main(String args[]){
           JFrame frame = new test();
           frame.setResizable(false);
           frame.setVisible(true);
        }

        public void mousePressed(MouseEvent e){
           pip=null;
           Component comp = deadBoard.findComponentAt(e.getX()-20, e.getY()-20);
           if (comp instanceof JLabel){
              pip = (JLabel)comp;
           }
           return;
        }
        
        public void mouseReleased(MouseEvent e){
           pip=null;
        }
 
        public void mouseDragged(MouseEvent e){
           if (pip==null){
              return;
           }
           pip.setLocation(e.getX()-20, e.getY()-20);
           return;
        }
 
        public void mouseClicked(MouseEvent e){}
        public void mouseMoved(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}

}


