package Group9_Deadwood;
//import Group9_Deadwood.role;
import java.util.HashMap;
public class Room{
//	private sceneObject scene;
   private int shots;
	private int maxShots;
	private HashMap<String, role> extraRoles;
	private String name;
   private Scene scene;

	Room(String N, Role[] roles, int S){
		this.name=N;
		this.maxShots=S;
		this.shots=this.maxShots;
		for (Role R : roles){
			extraRoles.put(R.getName(),R);
		}
	}

	public String getName(){
		return name;
	}

	public int getShots(){
		return this.shots;
	}
   
   public int getBudget(){
      return this.scene.getBudget();
   }

}
