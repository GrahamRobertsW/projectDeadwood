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
  
  public boolean rehearsal() {
      if (this.role != null) {
         int rehearsalValMax = room.getBudget();
         if (this.rehearsalVal < rehearsalValMax){
            this.rehearsalVal++;
            return true;
         } else {
            //Error handling should be updated at some point 
            System.out.println("Max rehearsals reached.");
            return false;
         }
     } else {
         System.out.println("Please take a role before rehearsing");
         return false;
     }    
  }
  
  public void reset() {
      this.rehearsalVal = 0;
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
  
  public void setRole() {
      setPlayer();
  }
  
  
  public boolean act() {
   if (this.role != null) {
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
      return true; 
   } else {
      System.out.println("Please take a role before acting");
      return false;
   }
 } 
      
   public void rankMoney(int rank) {
      int cost = rank*rank + rank -2;
      if (this.money >= cost) {
          this.money-= cost;
          this.rank = rank;
      } else {
          System.out.println("Not enough money to rank up! Choose another rank, come back later, or try using credits.");
      }
   }
      
   public void rankCredits(int rank){
     int cost = (rank - 1) * 5;
     if (this.credits >= cost) {
         this.credits -= cost;
         this.rank = rank;
     } else {
         System.out.println("Not enough credits to rank up! Choose another rank, come back later, or try using money.");
     }
   }
   
   public boolean move() {
      if (this.room.getShots() == 0) {
         System.out.println("Scene complete. Choose a new room to move to");
         System.out.println(this.room.getMoves());
         Scanner user_choice = new Scanner();
         Room newRoom = user_choice.next();
         if (newRoom.isValid()) {
            this.room = newRoom;
            System.out.println("You are now in room " + this.room);
            return true;
         } else {
            System.out.println("Not a valid room choice.");
            return false;
         }
      } else {
         System.out.println("Scene not yet complete. Act or rehearse until scene is complete then move.");
         return false;
      }
   }
  
   
}
