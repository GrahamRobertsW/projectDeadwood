import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;


public class TileSwing extends JFrame{
   private TileSwing(){
//      int H=1280;
//      int W=1920;
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      this.setSize(W,H);
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2,2));
 //     this.setResizeable(false);
      JLabel HotelL = createImgLabel("HotelTile.png");
      panel.add(HotelL);
      JLabel MainStL = createImgLabel("MainStTile.png");
      panel.add(MainStL);
      JLabel TrainL = createImgLabel("TrainTile.png");
      panel.add(TrainL);
      JLabel SecretL = createImgLabel("SecretTile.png");
      panel.add(SecretL);
      this.getContentPane().add(panel);
//		this.getContentPane().pack();
   }
//   TileSwing(){
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 //     JPanel panel = new JPanel();
//      panel.setLayout(new GridLayout(2,2));

//	private JLabel createImgLabel(String filename,int width,int height){
//		JLabel newLabel = new JLabel();
//		ImageIcon initialIcon = new ImageIcon(filename);
  //              Image img = initialIcon.getImage();
//		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		Graphics g = bi.createGraphics();
//		g.drawImage(img,0,0, width, height, null);
//		ImageIcon newIcon = new ImageIcon(bi);
  //              newLabel.setIcon(newIcon);
  //              return newLabel;
//        }
   private JLabel createImgLabel(String filename){
	   JLabel lab = new JLabel();
		ImageIcon img = new ImageIcon(filename);
		lab.setIcon(img);
		return lab;
	}

   public static void main(String[] args){
      TileSwing deadBoard = new TileSwing();
		deadBoard.validate();
		deadBoard.setResizable(false);
		deadBoard.pack();
		deadBoard.setVisible(true);
   }

}
   
