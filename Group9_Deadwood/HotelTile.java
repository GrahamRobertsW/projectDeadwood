package Group9_Deadwood;
import java.util.HashMap;
public class HotelTile extends Tile{
	private HashMap<String, Room> Rooms = null;
	private String[] names = {"Hotel", "Bank", "Church"};
	private Role[][] tempRoles = {{new Role("Faro Player", "Hit Me!", 1, 0), new Role("Sleeping Drunkard", "Zzzzzz Whiskey", 1,0), new Role("Australian Bartender", "What'll it be, mate?", 3, 0), new Role("Falls from Balcony", "Arrrgghh!!", 2, 0)},{new Role("Flustered Teller", "Would you like a large bill, sir?", 3, 0), new Role("Suspicious Gentleman", "Can you be more specific?", 2, 0)},{new Role("Dead Man", "...", 1, 0), new Role("Crying Woman", "oh, the humanity!", 2, 0)}};	
   private int[] shots = {3,1,2};
   private Board board;
	private Room[] Doors;
	HotelTile(int pos, Board B){
		this.board=B;
		this.Rooms=new HashMap<String, Room>();
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i],B);
			this.Rooms.put(temp.getName(), temp);
			setOutDoors();
		}
   
	}
   private Room[] setOutDoors(){
		this.Doors =new Room[] {this.Rooms.get("Bank"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Church"), this.Rooms.get("Church"), this.Rooms.get("Bank")};
      return Doors;
	}

}
