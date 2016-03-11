/* Board sets the tiles and puts them in the correct places.
 * See Tile for explanation on how they are placed. Our tiles
 * are put in the same order every time.
 */


package Group9_Deadwood;
import java.util.*;
public class Board{
	private HashMap<String, Tile> tiles;
	private String[] keys;
	private int sceneCount;
   public Board(){
		sceneCount=0;
		this.tiles=new HashMap<String, Tile>();
      Tile TrainTile = new Tile("TrainTile.png");
		tiles.put("Train Station",TrainTile);
      Tile MainTile = new Tile("MainStTile.png");
		tiles.put("Main Street",MainTile);
      Tile HotelTile = new Tile("HotelTile.png");
		tiles.put("Hotel",HotelTile);
      Tile SecretTile = new Tile("SecretTile.png");
		tiles.put("Secret Hideout",SecretTile);
		keys = new String[] {"Train Station", "Main Street", "Secret Hideout", "Hotel"};
		   
	}
   public void initializeBoard(){
	   for (String i: keys){
			tiles.get(i).setBoard(this);
      }
	}

   public void initializeTiles(){
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
