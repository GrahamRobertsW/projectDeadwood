package Group9_Deadwood;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Players {
   private int credits;
   private int rank;
   private double money;
   private int rehearsalVal;
   private String name;
   private Room room;
   private Role role;
   
   Players(int credits, int rank, double money, int rehearsalVal, String name, Room room, Role role) {
      this.credits = credits;
      this.money = money;
      this.rehearsalVal = rehearsalVal;
      this.name = name;
      this.room = room;
      this.role = role;
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
  
  public String getName() {
      return this.name;
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
  
  public Room getRoom() {
      return this.room;
  }
  
  public void setRoom(Room n) {
      this.room = n;
  }
  
  public Role getRole() {
      return this.role;
  }
  
  public void setRole(Role n) {
      this.role = n;
  }
  
  public void act() {
      int budget = this.room.getBudget();
      Random dice = new Random();
      int roll = dice.nextInt(5) + 1;
      if (roll >= budget) {
         if (room.decShots() == 0) {
            room.success();
         }
         else if (this.role.isStarring() == 1) {
            this.credits+= 2;
         } else {
            this.credits++;
            this.money++;
         }
      } else {
         if (this.role.isStarring() == 1) {
            System.out.println("Role failed. Better luck next time");
         } else {
            this.money++;
         }
      }   
  }
   
}