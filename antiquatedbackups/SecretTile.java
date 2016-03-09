package Group9_Deadwood;
import java.util.HashMap;
import java.util.Map;
public class SecretTile extends Tile{
	private String[] names={"Secret Hideout", "Ranch"};
	private HashMap<String, Room> Rooms;
	private int[]shots={3,2};
	private Room outDoors[];
	private Board board;
	private Role[][]tempRoles={{new Role("clumsy Pit Fighter", "Hit Me!", 1, 0), new Role("Thug with Knife", "Meet Suzy, ma murderin' knife.", 2,0), new Role("Dangerous Tom", "there's two ways we can do this....", 3, 0), new Role("Penny, who is Lost", "Oh, woe! For I am Lost!", 4, 0)}, {new Role("Shot in Leg", "Ow, Me Leg!", 1, 0), new Role("Saucy Fred", "That's what she said!", 2, 0), new Role("Man Under Horse", "A little help here!", 3, 0)}};
	SecretTile(int pos){
		this.Rooms=new HashMap<String, Room>();
		for(int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i]);
			this.Rooms.put(temp.getName(), temp);
		}
		this.Rooms.put("Casting Office",new Room("Casting Office"));
		this.outDoors =new Room[] {Rooms.get("Casting Office"), Rooms.get("Ranch"), Rooms.get("Ranch"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Casting Office")};

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
