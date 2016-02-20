package Group9_Deadwood;
import java.util.HashMap;
public class SecretTile extends tile{
	private String[] names={"Secret Hideout", "Ranch"};
	private HashMap<String, room> rooms;
	private int[]shots={3,2};
	private role[][]tempRoles={{new role("clumsy Pit Fighter", "Hit Me!", 1, 0), new role("Thug with Knife", "Meet Suzy, mu murderin' knife.", 2,0), new role("Dangerous Tom", "/ther's two ways we can do this....", 3, 0), new role("Penny, who is Lost", "Oh, woe! For I am Lost!", 4, 0)}, {new role("Shot in Leg", "Ow, Me Leg!", 1, 0), new role("Saucy Fred", "That's what she said!", 2, 0), new role("Man Under Horse", "A little help here!", 3, 0)}};
	SecretTile(int pos){
		for(int i=0; i<names.length; i++){
			room temp=new room(names[i], tempRoles[i], shots[i]);
			this.rooms.put(temp.getName(), temp);
		}
	}
}
