package Group9_Deadwood;
import java.util.HashMap;

public class TrainTile{
	private HashMap<String, room> rooms;
	private String[] names={"Train Station","General Store", "Jail"};
	private role[][] tempRoles={{new role("Crusy Prospector", "Aww, peaches!", 1,0), new role("Dragged by Train", "Omgeezers", 1, 0), new role("Preacher with Ba", "The Lord will provide", 2, 0), new role("Cyrus the Gunfighter", "Git to fightin' or git away!", 4,0)},{new role("Man in Overalls", "Look like a storm's comin' in.", 1, 0), new role("Mister Keach", "Howdy, stranger.", 3, 0)}, {new role("Prisoner in Cell", "Zzzzzzz... Whiskey", 2, 0), new role("Feller in Irons", "Ah kilt the wrong man!", 3, 0)}};
	private int[] shots={3,2,1};

	TrainTile(int pos){
		for (int i=0; i<names.length; i++){
			room temp=new room(names[i], tempRoles[i],shots[i]);
			this.rooms.put(temp.getName(), temp);
		}
	}
}
