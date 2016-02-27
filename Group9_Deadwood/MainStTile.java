package Group9_Deadwood;
import java.util.HashMap;
import java.util.Map;
public class MainStTile extends Tile{
	private HashMap<String, Room> Rooms;
	private String[] names = {"Main Street", "Saloon"};
	private Role[][] tempRoles = {{new Role("Railroad Worker", "I'm a steel-drivin' man!", 1, 0), new Role("Falls off Roof", "Aaaaiiiiigggghh!", 2, 0), new Role("woman in Black Dress", "Well, I'll be!", 2, 0), new Role("Mayor McGinty", "People of Deadwood!", 4, 0)},{new Role("Woman in Red Dress", "Come up and see me!", 2,0), new Role("reluctant Farmer", "I ain't so sure about that!", 1, 0)}};
	private int[] shots ={3,2};
	private Board board;
   private Room[] outDoors;
	MainStTile(int pos){
		this.Rooms=new HashMap<String, Room>();
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i]);
			this.Rooms.put(temp.getName(), temp);
		}
		this.Rooms.put("Trailers", new Room("Trailers"));
		this.outDoors = new Room[]{Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Trailers"),Rooms.get("Trailers"),Rooms.get("Saloon"),Rooms.get("Saloon"),Rooms.get("Main Street")};

	}

	public Room[] getDoors(){
		return this.outDoors;
	}

	public HashMap<String,Room> returnRooms(){
		return this.Rooms;
	}
   public void setBoard(Board B){
		this.board=B;
		for (Map.Entry<String, Room> entry : Rooms.entrySet()){
			entry.getValue().setBoard(B);
		}
	}

	public Board getBoard(){
		return this.board;
	}
	public Room getRoom(int i){
		return this.outDoors[i];
	}
 }
