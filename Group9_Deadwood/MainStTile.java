package Group9_Deadwood;
import java.util.HashMap;
public class MainStTile extends Tile{
	private String[] names = {"Main Street", "Saloon", "Trailers"};
	private Role[][] tempRoles = {{new Role("Railroad Worker", "I'm a steel-drivin' man!", 1, 0), new Role("Falls off Roof", "Aaaaiiiiigggghh!", 2, 0), new Role("woman in Black Dress", "Well, I'll be!", 2, 0), new Role("Mayor McGinty", "People of Deadwood!", 4, 0)},{new Role("Woman in Red Dress", "Come up and see me!", 2,0), new Role("reluctant Farmer", "I ain't so sure about that!", 1, 0)}};
	private int[] shots ={3,2};
	private Board board;
   private Room[] outDoors = new Room[]{Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Trailers"),Rooms.get("Trailers"),Rooms.get("Saloon"),Rooms.get("Saloon")};

	MainStTile(int pos, Board B){
		this.board=B;
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i], B);
			this.Rooms.put(temp.getName(), temp);
		}
		this.Rooms.put("trailers", new Room("trailers", B));
	}
 }
