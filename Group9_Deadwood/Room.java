package Group9_Deadwood;
//import Group9_Deadwood.Role;
import java.util.HashMap;
public class Room{
//	private sceneObject scene;
   private int shots;
	private int maxShots;
	private HashMap<String, Role> extraRoles;
	private Scene Scene;
	private String name;
	private Room[] doors;

	Room(String N, Role[] Roles, int S){
		this.name=N;
		this.maxShots=S;
		this.shots=this.maxShots;
		for (Role R : Roles){
			extraRoles.put(R.getName(),R);
		}
	}

	Room(String N){
		this.name=N;
		this.shots=0;
		this.maxShots=0;
		this.extraRoles=null;
		this.Scene = null;
	}

	public setDoors(Room[] newDoors){
		this.doors=newDoors;
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
		return;
	}
/*
	public boolean getSceneUsed(){
		return this.Scene.used();
	}
	
	public void setSceneUsed(boolean value){
		this.Scene.used(value);
	}

	public void getScene(){
		System.out.print("%s : %s.", this.Scene.getName() this.Scene.getDesc());
	}
*/
}
