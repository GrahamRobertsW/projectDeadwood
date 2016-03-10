package swingdemo;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class test{
   public static void main(String[] args){
   JFrame frame=new Jframe();
   frame.setsize(400,400);
   frame.add(new SwingPlayer("bluepip.png"));
   frame.setDefaultCloseOperator(JFrame.CLOSE_ON_EXIT());
   frame.setVisible(true);
   }
}
