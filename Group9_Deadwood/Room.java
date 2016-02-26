package Group9_Deadwood;
//import Group9_Deadwood.Role;
import java.util.*;
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
// complete a boolean describing whether or not a scene has been completed that dfay
   private int shots;
	private int maxShots;
	private HashMap<String, Role> extraRoles;
	private Scene Scene;
	private String name;
	private HashMap<String, Room> rooms;
	private Room[] doors;
	private Random generator;
	private ArrayList<Players> players;
	private boolean complete;

//	private Scene[] Scenes;
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
		for (Role R : Roles){
			extraRoles.put(R.getName(),R);
		}
		this.rooms=null;
		this.generator = new Random();
	}

	Room(String N){
		this.name=N;
		this.shots=0;
		this.maxShots=0;
		this.extraRoles=null;
		this.Scene = null;
		this.rooms=null;
		this.complete=false;
		this.generator = new Random();
	}

	public String getName(){
		return name;
	}

	public int getShots(){
		return this.shots;
	}

	public int decShots(){
		this.shots--;
		return this.shots;
	}

	public int reset(){
		this.shots=this.maxShots;
		return this.shots;
	}

   public int getBudget(){
		return this.Scene.getBudget();
	}

   public Room[] getDoors(){
		return this.doors;
	}

	public void roleSort(ArrayList<Players> Ps){
		Players temp;
		for (int i=Ps.size(); i>1; i--){
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
	   ArrayList<Players> scenePlayers = this.Scene.getPlayers();
      if (scenePlayers.size()>0){
         int[] randomized = new int[5];
         for (int i=0; i<5; i++){
            randomized[i]=generator.nextInt(5)+1;
        }
        Collections.sort(randomized);
        roleSort(scenePlayers);
        for (int i=0; i<5; i++){
           scenePlayers.get(i%scenePlayers.size()).setDollars(randomized[i]);
        }
     }
	  ArrayList extraPlayers = new ArrayList<Players>();
	  for (Role role : extraRoles){
		  if (role.getPlayer()!=null){
			  extraPlayers.add(role.getPlayer());
	  for (Players P: extraPlayers){
		  P.setDollars(P.role.getRank());
	  }
     board.success();
     for (Players P: players){
        P.setRole(null);
        P.setScene(null);
     }
     this.scene=null;
	  this.complete=true;
     }  
   }
	}      
 

	public void setDoors(Room[] Rs){
		for (Room R: Rs){
			rooms.put(R.getName(), R);
		}
	   return;
	}

	public HashMap<String, Room> getMoves(){
		return this.rooms;
	}
/*

	public void displayScene(){
		System.out.print("%s : %s.", this.Scene.getName() this.Scene.getDesc());
	}

	public void setScene(Scene set){
		this.Scene = set;
		this.Scene.used(true);
	}

	public boolean checkSuccess(){
		return this.Scene.getSuccess();
	}
	
	public Room getRoomKey(string input){
		for(Room key : rooms.keyset()){
			if(rooms.get(key).equals(input)){
				return key;
			}
		}
		return null;
	}	
*/
}
