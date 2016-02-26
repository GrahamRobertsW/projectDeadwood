package Group9_Deadwood;
import java.util.*;
public class Board{
	private HashMap<String, Tile> tiles;
	private String[] keys;
	private int sceneCount;
   Board(){
		sceneCount=0;
		tiles.put("Train Station",new TrainTile(0));
		tiles.put("Main Street",new MainStTile(1));
		tiles.put("Hotel",new HotelTile(2));
		tiles.put("Secret Hideout",new SecretTile(3));
		keys = new String[] {"Train Station", "Main Street", "Hotel", "Secret Hideout"};
		for (String i: keys){
			tiles.get(i).setDoors();
	   }
	}
   public Tile getTile(int i){
	   String K = keys[i];
		return tiles.get(K);
	}
	public Room findTrailers(){
		return this.tiles.get("Main Street").findTrailers();
	}
	public void success(){
		sceneCount=sceneCount+1;
      return;
	}
	public int sceneCount(){
		return sceneCount;
   }
}
