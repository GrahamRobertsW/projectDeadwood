package Group9_Deadwood;

import java.util.*;


public class Players {
   private int credits;
   private int rank;
   private double money;
   private int rehearsalVal;
   private String name;
   private Room room;
   private Role role;
   private Scene scene;
   Players(int credits, int rank, double money, int rehearsalVal, String name) {
      this.credits = credits;
      this.money = money;
      this.rehearsalVal = rehearsalVal;
      this.name = null;;
      this.room = room;
      this.role = null;
		this.scene=null;
   }
   
   public Players getPlayer(){
      return this;
   }
   
  public int getRank() {
      return this.rank;
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
  
  public void setRole(Role R) {
      this.role=R;
		return;
  }
  
  public void nullRole(){
	  this.role=null;
	  return;
  }
  public void setScene(Scene S){
	  this.scene=S;
	  return;
  }

  public void nullScene(){
	  this.scene=null;
	  return;
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
   /* rankMoney and rankCredits take in the rank the player would like to change their rank to.
      They check to see if the player has enough money or credits to buy this rank, and if the player
      has the means to they change the rank to the input and decreas the player's money/credits. 
      Otherwise, it prints a message explaining the error to the user and returns false to Deadwood.   
   */   
   public boolean rankMoney(int newRank) {
      int cost = newRank*newRank + newRank -2;
      if (this.money >= cost) {
          this.money-= cost;
          this.rank = newRank;
          return true;
      } else {
          System.out.println("Not enough money to rank up! Choose another rank, come back later, or try using credits.");
         return false;
      }
   }
      
   public boolean rankCredits(int newRank){
     int cost = (rank - 1) * 5;
     if (this.credits >= cost) {
         this.credits -= cost;
         this.rank = newRank;
         return true;
     } else {
         System.out.println("Not enough credits to rank up! Choose another rank, come back later, or try using money.");
         return false;
     }
   }
   
   public boolean move(Room newRoom) {
      if (this.room.getMoves().get(newRoom) != null) {
         this.room = newRoom;
         return true;
      } else {
         System.out.println("Not a valid room");
         return false;
      }
   }
  
   
}
