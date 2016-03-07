import java.awt.*;
import javax.swing.*;
import java.util.*;
//blic class swingtiles extends JFrame{
//   private swingtiles(){
//      JPanel panel=new JPanel();
//      this.setSize(2060,1560);
//      ImageIcon Hotel =new ImageIcon("HotelTile.png");
//      JLabel hotelLabel = new JLabel();
//      hotelLabel.setIcon(Hotel);
//      panel.add(hotelLabel);
//      this.getContentPane().add(panel); 
 //     this.setVisible(true);
 //  }
//   public static void main(String[] args){
//      new swingtiles().setVisible(true);
//   }
//}
//Jpanel mainPanel = new JJPanel();
   public class swingtiles extends JFrame{
      private swingtiles(){
         JPanel main = new JPanel();
         this.setSize(2060,1560);
         BoxLayout rows=new BoxLayout(main, BoxLayout.Y_AXIS);
         JPanel top = new JPanel();
         JPanel bot = new JPanel();
         main.setLayout(rows);
         BoxLayout topBox = new BoxLayout(top,BoxLayout.X_AXIS);
         BoxLayout botBox = new BoxLayout(bot,BoxLayout.X_AXIS);
         top.setLayout(topBox);
         bot.setLayout(botBox);
         top.add(subtiles("MainStTile.png"));
         top.add(subtiles("TrainTiles.png"));
         bot.add(subtiles("SecretTile.png"));
         bot.add(subtiles("HotelTile.png"));
         main.setVisible(true);
      }

      private JPanel subtiles(String arg){
         JPanel panel = new JPanel();
         panel.setSize(1030,780);
         ImageIcon icon = new ImageIcon(arg);
         JLabel label = new JLabel();
         label.setIcon(icon);
         panel.add(label);
         return panel;
      }

   public static void main(String args[]){
      new swingtiles().setVisible(true);
   }
}

