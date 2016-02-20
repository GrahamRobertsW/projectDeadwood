package Group9_Deadwood;
import java.util.HashMap;
public class MainStTile{
	private String[] names = {"Main Street", "Saloon", "Trailers"};
	private HashMap <String, room>rooms;
	private role[][] tempRoles = {{new role("Railroad Worker", "I'm a steel-drivin' man!", 1, 0), new role("Falls off Roof", "Aaaaiiiiigggghh!", 2, 0), new role("woman in Black Dress", "Well, I'll be!", 2, 0), new role("Mayor McGinty", "People of Deadwood!", 4, 0)},{new role("Woman in Red Dress", "Come up and see me!", 2,0), new role("reluctant Farmer", "I ain't so sure about that!", 1, 0)}};
	private int[] shots ={3,2};

	MainStTile(int pos){
		for (int i=0; i<names.length; i++){
		   room temp=new room(names[i], tempRoles[i], shots[i]);
			this.rooms.put(temp.getName(), temp);
		}
	}
}
