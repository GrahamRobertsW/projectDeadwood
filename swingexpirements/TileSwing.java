import java.util.*;
import javax.swing.*;
import java.awt.*;

public class TileSwing extends JFrame{
   private TileSwing(){
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(1920,1280);
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2,2));
     // panel.setResizeable(true);
      JLabel HotelL = new JLabel();
		temp = new ImageIcon("HotelTile.png");
       HotelI 
      HotelL.setIcon(HotelI);
      panel.add(HotelL);
      JLabel MainStL = new JLabel();
      ImageIcon MainStI = new ImageIcon("MainStTile.png");
      MainStL.setIcon(MainStI);
      panel.add(MainStL);
      JLabel TrainL = new JLabel();
      ImageIcon TrainI = new ImageIcon("TrainTile.png");
      TrainL.setIcon(TrainI);
      panel.add(TrainL);
      JLabel SecretL = new JLabel();
      ImageIcon SecretI = new ImageIcon("SecretTile.png");
      SecretL.setIcon(SecretI);
      panel.add(SecretL);
      this.getContentPane().add(panel);
   }

	private JLabel createImgLabel(String filename, width, height){
		JLabel newLabel = new JLabel();
		ImageIcon initialIcon = new ImageIcon(filename);
		BufferedImage bi = new BufferedImage(initialIcon.getWidth(null), initialIcon.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphiccs g = bi.createGraphics();
		g.drawImage(initialIcon,0,0, width, height, null);
		ImageIcon newIcon = new ImageIcon(bi);

   public static void main(String[] args){
      new TileSwing().setVisible(true);
   }

}
   
