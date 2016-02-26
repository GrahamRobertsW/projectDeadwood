package Group9_Deadwood;
import java.util.HashMap;
public class SecretTile extends Tile{
	private String[] names={"Secret Hideout", "Ranch"};
	private int[]shots={3,2};
	private Room outDoors[]=new Room[] {Rooms.get("Casting Office"), Rooms.get("Ranch"), Rooms.get("Ranch"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Casting Office")};
   private Board board;
	private Role[][]tempRoles={{new Role("clumsy Pit Fighter", "Hit Me!", 1, 0), new Role("Thug with Knife", "Meet Suzy, mu murderin' knife.", 2,0), new Role("Dangerous Tom", "/ther's two ways we can do this....", 3, 0), new Role("Penny, who is Lost", "Oh, woe! For I am Lost!", 4, 0)}, {new Role("Shot in Leg", "Ow, Me Leg!", 1, 0), new Role("Saucy Fred", "That's what she said!", 2, 0), new Role("Man Under Horse", "A little help here!", 3, 0)}};
	SecretTile(int pos, Board B){
		this.borad=B;
		for(int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i]);
			this.Rooms.put(temp.getName(), temp);
		}
		this.Rooms.put("Casting Office",new Room("Casting Office", B));
	}
}
