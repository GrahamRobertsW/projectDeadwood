package Group9_Deadwood;
import java.util.HashMap;
public class MainStTile{
	private String[] names = {"Main Street", "Saloon", "Trailers"};
	private HashMap <String, Room>Rooms;
	private Role[][] tempRoles = {{new Role("Railroad Worker", "I'm a steel-drivin' man!", 1, 0), new Role("Falls off Roof", "Aaaaiiiiigggghh!", 2, 0), new Role("woman in Black Dress", "Well, I'll be!", 2, 0), new Role("Mayor McGinty", "People of Deadwood!", 4, 0)},{new Role("Woman in Red Dress", "Come up and see me!", 2,0), new Role("reluctant Farmer", "I ain't so sure about that!", 1, 0)}};
	private int[] shots ={3,2};

	MainStTile(int pos){
		for (int i=0; i<names.length; i++){
		   Room temp=new Room(names[i], tempRoles[i], shots[i]);
			this.Rooms.put(temp.getName(), temp);
		}
	}
}
