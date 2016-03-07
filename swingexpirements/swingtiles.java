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
//      private swingtiles(){
//         Container content = this.getContentPane();
//         JPanel main = new JPanel();
//         this.setSize(2060,1560);
//         BoxLayout rows=new BoxLayout(main, BoxLayout.Y_AXIS);
//         JPanel top = new JPanel();
//         JPanel bot = new JPanel();
//        main.setLayout(rows);
//         BoxLayout topBox = new BoxLayout(top,BoxLayout.X_AXIS);
//         BoxLayout botBox = new BoxLayout(bot,BoxLayout.X_AXIS);
//         top.setLayout(topBox);
//         bot.setLayout(botBox);
//         top.add(subtiles("MainStTile.png"));
//         top.add(subtiles("TrainTiles.png"));
//         bot.add(subtiles("SecretTile.png"));
//         bot.add(subtiles("HotelTile.png"));
//         top.setVisible(true);
//         bot.setVisible(true);
//         main.setVisible(true);
//         content.add(main);
//         content.setVisible(true);
//      }
   private swingtiles(){
      JPanel content = this.getContentPane();
      content.setLayout(new GridLayout(2,2));
      content.add(subtiles("HotelTile.png"));
      content.add(subtiles("MainStTile.png"));
      content.add(subtiles("SecretTile.png"));
      content.add(subtiles("TrainTile.png"));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      content.setVisible(true);
      content.setResizeable(true);
   }
      private JPanel subtiles(String arg){
         JPanel panel = new JPanel();
         panel.setSize(1030,780);
         ImageIcon icon = new ImageIcon(arg);
         JLabel label = new JLabel();
         label.setIcon(icon);
         panel.add(label);
         panel.setVisible(true);
      //   panel.setResizeable(true);
         return panel;
      }

   public static void main(String args[]){
      new swingtiles().setVisible(true);
   }
}

