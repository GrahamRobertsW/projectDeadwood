package Group9_Deadwood;
//import Group9_Deadwood.role;
import java.util.HashMap;
public class room{
//	private sceneObject scene;
   private int shots;
	private int maxShots;
	private HashMap<String, role> extraRoles;
	private String name;

	room(String N, role[] roles, int S){
		this.name=N;
		this.maxShots=S;
		this.shots=this.maxShots;
		for (role R : roles){
			extraRoles.put(R.getName(),R);
		}
	}

	public String getName(){
		return name;
	}

	public int getShots(){
		return this.shots;
	}


}
