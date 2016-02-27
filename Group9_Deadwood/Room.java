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
	private Board board;

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
        Arrays.sort(randomized);
        roleSort(scenePlayers);
        for (int i=0; i<5; i++){
           scenePlayers.get(i%scenePlayers.size()).setMoney(randomized[i]);
        }
     }
	  ArrayList<Players> extraPlayers = new ArrayList<Players>();
	  for (String key : extraRoles.keySet()){
		  Role role = extraRoles.get(key);
		  if (role.getPlayer()!=null){
			  extraPlayers.add(role.getPlayer());
	  for (Players P: extraPlayers){
		  P.setMoney(P.getRole().getRank());
	  }
     board.success();
     for (Players P: players){
        P.nullRole();
        P.nullScene();
     }
     this.Scene=null;
	  this.complete=true;
     }  
   }
	}      
 

	public void setDoors(Room[] Rs){
		for (Room R: Rs){
			rooms.put(R.getName(), R);
		}
	}

	public HashMap<String, Room> getMoves(){
		return this.rooms;
	}


	public void displayScene(){
		System.out.printf("%s : %s.", this.Scene.getName(), this.Scene.getDesc());
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

	public boolean checkSuccess(){
		return this.Scene.getSuccess();
	}
	
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
		return rooms.get(input);
	}

}
