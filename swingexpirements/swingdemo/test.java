package swingdemo;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class test extends JFrame impliments MouseListener, MouseMotionListener{
	JLayeredPane layers;
	JLabel pip;
	JPanel deadboard;

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
		Dimension size() = new Dimension(200,200);

		layers=new JLayeredPane();
		this.getContentPane().add(layers);
		layers.addMouseListener(this);
		layers.addMouseMotionListener(this);
		deadBoard=new JPanel();

}
