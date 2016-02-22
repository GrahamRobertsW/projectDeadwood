package Group9_Deadwood;
import java.util.HashMap;
public class HotelTile extends Tile{
	private String[] names = {"Hotel", "Bank", "Church"};
	private HashMap<String, Room> Rooms;
	private Role[][] tempRoles = {{new Role("Faro Player", "Hit Me!", 1, 0), new Role("Sleeping Drunkard", "Zzzzzz Whiskey", 1,0), new Role("Australian Bartender", "What'll it be, mate?", 3, 0), new Role("Falls from Balcony", "Arrrgghh!!", 2, 0)},{new Role("Flustered Teller", "Would you like a large bill, sir?", 3, 0), new Role("Suspicious Gentleman", "Can you be more specific?", 2, 0)},{new Role("Dead Man", "...", 1, 0), new Role("Crying Woman", "oh, the humanity!", 2, 0)}};	
   private int[] shots = {3,1,2};
   private Room[] outDoors={Rooms.get("Bank"), Rooms.get("Hotel"), Rooms.get("Hotel"), Rooms.get("Hotel"), Rooms.get("Hotel"), Rooms.get("Church"), Rooms.get("Church"), Rooms.get("Bank")};

	HotelTile(int pos){
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i]);
			this.Rooms.put(temp.getName(), temp);
		}

	}
}
