package Group9_Deadwood;
import java.util.*;
public class Board{
	private HashMap<String, Tile> tiles;
	private String[] keys;
	private int sceneCount;
   public Board(){
		sceneCount=0;
		this.tiles=new HashMap<String, Tile>();
		tiles.put("Train Station",new TrainTile(0,this));
		tiles.put("Main Street",new MainStTile(1,this));
		tiles.put("Hotel",new HotelTile(2,this));
		tiles.put("Secret Hideout",new SecretTile(3,this));
		keys = new String[] {"Train Station", "Main Street", "Hotel", "Secret Hideout"};
		for (String i: keys){
			System.out.printf("setting Doors for %s\n", i);
			tiles.get(i).setDoors(tiles.get(i));
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
