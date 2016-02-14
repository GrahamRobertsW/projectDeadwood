package Group9_Deadwood;
import java.util.HashMap;
public class HotelTile extends tile{
	private String[] names = {"Hotel", "Bank", "Church"};
	private HashMap<String, room> rooms;
	private role[][] tempRoles = {{new role("Faro Player", "Hit Me!", 1, 0), new role("Sleeping Drunkard", "Zzzzzz Whiskey", 1,0), new role("Australian Bartender", "What'll it be, mate?", 3, 0), new role("Falls from Balcony", "Arrrgghh!!", 2, 0)},{new role("Flustered Teller", "Would you like a large bill, sir?", 3, 0), new role("Suspicious Gentleman", "Can you be more specific?", 2, 0)},{new role("Dead Man", "...", 1, 0), new role("Crying Woman", "oh, the humanity!", 2, 0)}};
	
   private int[] shots = {3,1,2};



	HotelTile(int pos){
		for (int i=0; i<names.length; i++){
			room temp=new room(names[i], tempRoles[i], shots[i]);
			this.rooms.put(temp.getName(), temp);
		}
	}
}
