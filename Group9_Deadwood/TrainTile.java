package Group9_Deadwood;
import java.util.HashMap;

public class TrainTile extends Tile{
	private String[] names={"Train Station","General Store", "Jail"};
	private Role[][] tempRoles={{new Role("Crusy Prospector", "Aww, peaches!", 1,0), new Role("Dragged by Train", "Omgeezers", 1, 0), new Role("Preacher with Ba", "The Lord will provide", 2, 0), new Role("Cyrus the Gunfighter", "Git to fightin' or git away!", 4,0)},{new Role("Man in Overalls", "Look like a storm's comin' in.", 1, 0), new Role("Mister Keach", "Howdy, stranger.", 3, 0)}, {new Role("Prisoner in Cell", "Zzzzzzz... Whiskey", 2, 0), new Role("Feller in Irons", "Ah kilt the wrong man!", 3, 0)}};
	private int[] shots={3,2,1};
   private Room[] outDoors=new Room[] {Rooms.get("Train Station"), Rooms.get("jail"), Rooms.get("Jail"), Rooms.get("General Store"), Rooms.get("General Store"), Rooms.get("Train Station"), Rooms.get("train Station"), Rooms.get("Train Station"), Rooms.get("Train Station")};
	TrainTile(int pos){
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i],shots[i]);
			this.Rooms.put(temp.getName(), temp);
		}
	}
}
