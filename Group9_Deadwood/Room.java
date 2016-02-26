package Group9_Deadwood;
//import Group9_Deadwood.Role;
import java.util.HashMap;
import java.math.util.Random;
public class Room{
   private int shots;
	private int maxShots;
	private HashMap<String, Role> extraRoles;
	private Scene Scene;
	private String name;
	private HashMap<String, Room> rooms;
	private Room[] doors;
	private Random generator;
//	private Scene[] Scenes;
	Room(String N, Role[] Roles, int S){
		this.name=N;
		this.maxShots=S;
		this.shots=this.maxShots;
		for (Role R : Roles){
			extraRoles.put(R.getName(),R);
		}
		this.rooms=null;
		this.generator = new Random()
	}

	Room(String N){
		this.name=N;
		this.shots=0;
		this.maxShots=0;
		this.extraRoles=null;
		this.Scene = null;
		this.rooms=null;
		this.generator = new Random()
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

   public void success(){
		if this.Scene.
	}

<<<<<<< HEAD


	

=======
   public void getMoves(){
		return this.doors;
	}

	public void success(){
		return;
	}
/* public void success(){
 * if (this.scene.getPlayers.size()>0){
 *    int[] randomized = new int[];
 *       for (int i=0; i<5; i++){
 *          randomized[i]=generator.nextInt(5)+1;
 *       }
 *       sort(randomized);
 *       ArrayList <Player>
 *
 */

	public void setDoors(Room[] Rs){
		for (Room R: Rs){
			rooms.put(R.getName(), R);
		}
	   return;
	}

	public HashMap<String, Room>{
		return this.rooms;
	}
>>>>>>> c88edc63430440d26c99f89de599521b30f0d3aa
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
