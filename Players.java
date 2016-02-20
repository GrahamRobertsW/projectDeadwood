import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Players {
   private int credits;
   private int rank;
   private double money;
   private int rehearsalVal;
   private String name;
   
   private Players(int credits, int rank, double money, int rehearsalVal, String name) {
      this.credits = credits;
      this.money = money;
      this.rehearsalVal = rehearsalVal;
      this.name = name;
   }
   
   private Players(){
      this.credits = null;
      this.rank = null;
      this.money = null;
      this.rehearsalVal = null;
      this.name = null;
   }
   
   public Players getPlayer(){
      return this.Player;
   }
   
   public void setPlayer() {
      
   }
   
}