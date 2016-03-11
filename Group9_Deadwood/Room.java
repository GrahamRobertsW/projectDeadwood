package Group9_Deadwood;
//import Group9_Deadwood.Role;
import java.util.*;
import java.util.Arrays;
public class Room{
// class Room
// This class represents the various rooms on the board
// Attributes: shots, the number of shot counters on the scene
// maxShotts the number of shot counters each scene resets to at the beginning of the day
// extraRoles a hashmap of strings to Role class for the extra roles available
// Scene the scene object currently in the room
// name this Room's name and its key into any HashMaps
// rooms a hashmap of rooms adjacent to this one
// doors an array of doors that this room is connected to
// generator a random number generator 
// complete a boolean describing whether or not a scene has been completed that day
   private int shots;
   private int maxShots;
   private HashMap<String, Role> extraRoles;
   private Scene Scene;
   private String name;
   private HashMap<String, Room> rooms;
   private Room[] doors = new Room[10];
   private Random generator;
   private HashMap<String, Players> players = new HashMap<String, Players>();
   private boolean complete;
   private Board board;
   private Tile tile;

   private Scene[] Scenes;
   Room(String N, Role[] Roles, int S){
   // Constructor
   // passes hardcoded values for a rooms and its scene from the hardcoded Tile class extensions
   // passes a name N,
   // an array of preconstructed Roles that turn into the extras HashMap
   // and the maxShots associated
      this.name=N;
      this.maxShots=S;
      this.shots=this.maxShots;
      this.complete=false;
      this.extraRoles = new HashMap<String, Role>();
      for (Role R : Roles){
      //			System.out.printf("%s\n", R.getName());
         extraRoles.put(R.getName(),R);
      }
      this.rooms=new HashMap<String, Room>();
      this.generator = new Random();
   	//this.board=B;
   }
   
   Room(String N){
      this.name=N;
      this.shots=0;
      this.maxShots=0;
      this.extraRoles=null;
      this.Scene = null;
      this.rooms=new HashMap<String,Room>();
      this.complete=false;
      this.generator = new Random();
   }
   public void setBoard(Board B){
      this.board=B;
   }
   public String getName(){
      return this.name;
   }

   public int getShots(){
      return this.shots;
   }

   public void printRoles() {
      for (Role entry : this.extraRoles.values()){
         if (entry != null) {
            System.out.print(entry.getName()+ ": " + entry.getRank()+ " Extra Role \n");
         } 
      }
      for (Role sceneR:this.Scene.getRoles().values()){
         System.out.println(sceneR.getName()+ ": "+sceneR.getRank() + " Starring Role");
      }
   }

   public int decShots(){
      this.shots--;
      return this.shots;
   }
   
   public boolean isComplete(){
      return this.complete;
   }
   public int reset(){
      this.shots=this.maxShots;
	this.complete = false;
      return this.shots;
   }

   public int getBudget(){
      return this.Scene.getBudget();
   }
   public String getRoomName(){
      return this.name;
   }

   public Room[] getDoors(){
      return this.doors;
   }

   public boolean printDoors() {
      for (int i =0; i < doors.length; i++) {
         if (doors[i] != null) {
            System.out.println(doors[i].getName());
         }
      }
      return true;
   }
   
   public void roleSort(ArrayList<Players> Ps){
      Players temp;
      for (int i=Ps.size(); i>2; i--){
         int j=i;
         while (Ps.get(i).getRank() > Ps.get(i-1).getRank()){
            temp=Ps.get(i-1);
            Ps.set(i-1,Ps.get(i));
            Ps.set(i,temp);
         }
      }
      return;
   }

   public void success(){
	System.out.println("~~~~~~~~~~Scene.getPlayers(): " + this.Scene.getPlayers() + " ~~~~~~~~~~~");
      ArrayList<Players> scenePlayers = this.Scene.getPlayers();
	/* Handles payout if there are more than 0 starring players on a scene.*/
      if (scenePlayers.size() > 1){
		System.out.println("~~~~~~~~~~~~~~~Starring Player success?~~~~~~~~~~~~~~~~");
         int[] randomized = new int[5];
         for (int i=0; i<5; i++){
            randomized[i]=generator.nextInt(5)+1;
         }
         Arrays.sort(randomized);
         roleSort(scenePlayers);
         for (int i=0; i<5; i++){
           	System.out.println("~~~~~~~~~~~~~~`Starring payout? " + randomized[i] + "~~~~~~~~");
		 scenePlayers.get(i%scenePlayers.size()).setMoney(randomized[i]);
         }
         for (Players P : scenePlayers){
            P.reset();
         }
      }
	/* Handles payout for extra roles. */
      ArrayList<Players> extraPlayers = new ArrayList<Players>();
      for (String key : extraRoles.keySet()){
         Role role = extraRoles.get(key);
         if (role.getPlayer()!=null){
            extraPlayers.add(role.getPlayer());
            for (Players P: extraPlayers){
               P.setMoney(P.getRole().getRank());
               P.reset();
            }
          }	
	}
         //this.board.success();
            System.out.println("Players: " + players);
	/* Resets the scene, role, and rehearsal values for the players on the role. */
	 for (Players P: this.players.values()){
               P.reset();
            }

            this.Scene=null;
            this.complete=true;
           
      
   }      
   
   public void addPlayer(Players p) {
      players.put(p.getName(), p);
   }
   
   public void removePlayer(Players p) {
      players.remove(p.getName());
   }
 

   public void setDoors(Room[] Rs){
      int i = 0;
      for (Room R: Rs){
         if (R != null) {
            //System.out.println("Set Doors " + R.getName());
            this.doors[i] = R;
            this.rooms.put(R.getName(),R);
            i++;
         }
      }
   }

	/*public String[] getMoves(){
		Object[] keys = this.rooms.keySet().toArray();
      String[] setofkeys = new String[keys.length];
      int i=0;
      for (Object S: keys){
         setofkeys[i]=rooms.get(S).getName();
      }
      return setofkeys;
	}*/


   public void displayScene(){
      System.out.printf("%s : %s.\n", this.Scene.getName(), this.Scene.getDesc());
   }

   public void setScene(Scene set){
      this.Scene = set;
      this.Scene.used(true);
   }

   public HashMap<String, Role> getRoles(){
      HashMap<String, Role> ret = new HashMap<String, Role>();
      for (String S: extraRoles.keySet()){
         ret.put(S, extraRoles.get(S));
      }
      if (this.Scene!=null){
         for (String S : this.Scene.getRoles().keySet()){
            ret.put(S, this.Scene.getRoles().get(S));
         }
      }
      return ret;
   }

   public Scene getScene(){
      return this.Scene;
   }
/*
   public boolean checkSuccess(){
      return this.Scene.getSuccess();
   }
*/	
	/*public Room getRoomKey(String input){
		for(String key : rooms.keySet()){
			if(rooms.get(key).equals(input)){
				return rooms.get(key);
			}
		}
		return null;
	}	
	*/

   public Room getRoomKey(String input){
      //System.out.println("Get room key: " + this.rooms/*.get(input).getName()*/);
      return this.rooms.get(input);
   }

}
