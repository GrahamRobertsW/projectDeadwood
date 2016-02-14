package Group9_Deadwood;
//import Group9_Deadwood.role;
import java.util.HashMap;
public class room{
//	private sceneObject scene;
   private int shots;
	private HashMap<String, role> extraRoles;
	private String name;

	room(String N, role[] roles, int S){
		this.name=N;
		this.shots=S;
		for (role R : roles){
			extraRoles.put(R.name(),R);
		}
	}
}
