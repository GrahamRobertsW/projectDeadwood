import java.util.*;
import javax.swing.*;
import java.awt.*;

public class TileSwing extends JFrame{
   private TileSwing(){
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(2060,1560);
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2,2));
     // panel.setResizeable(true);
      JLabel HotelL = new JLabel();
      ImageIcon HotelI = new ImageIcon("HotelTile.png");
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

   public static void main(String[] args){
      new TileSwing().setVisible(true);
   }
}
   
