import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
package Group9_Deadwood;

public class Players {
   private int credits;
   private int rank;
   private double money;
   private int rehearsalVal;
   private String name;
   
   Players(int credits, int rank, double money, int rehearsalVal, String name) {
      this.credits = credits;
      this.money = money;
      this.rehearsalVal = rehearsalVal;
      this.name = name;
   }
   
   public Players getPlayer(){
      return this;
   }
   
  public int getRank() {
      return this.rank;
  }
  public void setRank(int n) {
      this.rank = this.rank + n;
  }
  
  public int getCredits() {
      return this.credits;
  } 
  
  public void setCredits(int n) {
      this.credits = this.credits + n;
  }
  
  public double getMoney() {
      return this.money;
  }
  
  public void setMoney(double n) {
      this.money = this.money + n;
  }
  
  public int getRehearsalVal() {
      return this.rehearsalVal;
  }
  
  public void setRehearsalVal(int n) {
      this.rehearsalVal = n;
  }
  
  public void addRehearsal(int rehearsalValMax) {
      if (this.rehearsalVal < rehearsalValMax){
         this.rehearsalVal++;
      } else {
         //Error handling should be updated at some point 
         System.out.println("Max rehearsals reached.");
      }
  }
   
}