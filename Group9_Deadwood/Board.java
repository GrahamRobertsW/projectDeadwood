package Group9_Deadwood;
import java.util.*;
public class Board{
	private HashMap<String, Object> tiles;
	private String[] keys;
   Board(){
		tiles.put("Train Station",new TrainTile(0));
		tiles.put("Main Street",new MainStTile(1));
		tiles.put("Hotel",new HotelTile(2));
		tiles.put("Secret Hideout",new SecretTile(3));
		keys = new String[] {"Train Station", "Main Street", "Hotel", "Secret Hideout"};
	}
   public Object getTile(int i){
	   String key = keys[i];
		return tiles.get(key);
	}
}
