package group9swingwood;
import java.util.*;

public class Tile{
	//The four quarters of the board are named as follows clockwise and 0-indexed
	// 0|1
	// 2|3
	//
	private int pos;

	//Doors follow array like naming scheme going clockwise from top-right
	//     |0|______|1|
	//    _|          |_
	//    7            2
	//    _            _
	//    _|          |_
	//    6            3
	//    _  _______   _
	//     |5|      |4|

	private Room[] outDoors;
	private Board board;
	private HashMap<String, Room> Rooms;
//ublic Room getRoom(int i){
//		return outDoors[i];
//	}
   Tile(String filename){
		this.Rooms=new HashMap<String, Room>;
		Role[][] tempRoles;
		int[] shots;
		String names;
		switch(filename){
			case "HotelTile.png":
         	names = new String[] {"Hotel", "Bank", "Church"};
         	tempRoles = new Role[][]{{new Role("Faro Player", "Hit Me!", 1, 0), new Role("Sleeping Drunkard", "Zzzzzz Whiskey", 1,0), new Role("Australian Bartender", "What'll it be, mate?", 3, 0), new Role("Falls from Balcony", "Arrrgghh!!", 2, 0)},{new Role("Flustered Teller", "Would you like a large bill, sir?", 3, 0), new Role("Suspicious Gentleman", "Can you be more specific?", 2, 0)},{new Role("Dead Man", "...", 1, 0), new Role("Crying Woman", "oh, the humanity!", 2, 0)}};	
            shots = {3,1,2};
				populateRooms(shots,names,tempRoles,this.Rooms);
            this.outDoors =new Room[] {this.Rooms.get("Bank"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Church"), this.Rooms.get("Church"), this.Rooms.get("Bank")};
				break;

			case "SecretTile.png":
            tempRoles=new Room[][]{{new Role("clumsy Pit Fighter", "Hit Me!", 1, 0), new Role("Thug with Knife", "Meet Suzy, mu murderin' knife.", 2,0), new Role("Dangerous Tom", "/ther's two ways we can do this....", 3, 0), new Role("Penny, who is Lost", "Oh, woe! For I am Lost!", 4, 0)}, {new Role("Shot in Leg", "Ow, Me Leg!", 1, 0), new Role("Saucy Fred", "That's what she said!", 2, 0), new Role("Man Under Horse", "A little help here!", 3, 0)}};
				shots=new int[]{3,2};
				names=newString[]{"Secret Hideout", "Ranch"};
            this.Rooms.put("Casting Office",new Room("Casting Office"));
				populateRooms(shots,names,tempRoles,this.Rooms);
		      this.outDoors =new Room[] {Rooms.get("Casting Office"), Rooms.get("Ranch"), Rooms.get("Ranch"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Casting Office")};
            break;

			case "MainStTile.png":
				names = String{"Main Street", "Saloon"};
	         tempRoles = new Role[][]{{new Role("Railroad Worker", "I'm a steel-drivin' man!", 1, 0), new Role("Falls off Roof", "Aaaaiiiiigggghh!", 2, 0), new Role("woman in Black Dress", "Well, I'll be!", 2, 0), new Role("Mayor McGinty", "People of Deadwood!", 4, 0)},{new Role("Woman in Red Dress", "Come up and see me!", 2,0), new Role("reluctant Farmer", "I ain't so sure about that!", 1, 0)}};
	         shots ={3,2};
            this.Rooms.put("Trailers", new Room("Trailers"));
				populateRooms(shots,names,tempRoles,this.Rooms);
		      this.outDoors = new Room[]{Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Trailers"),Rooms.get("Trailers"),Rooms.get("Saloon"),Rooms.get("Saloon"),Rooms.get("Main Street")};
            break;

			case "TrainTile.png":
            names=new String[]{"Train Station","General Store", "Jail"};
	         tempRoles=new Role[][]{{new Role("Crusty Prospector", "Aww, peaches!", 1,0), new Role("Dragged by Train", "Omgeezers", 1, 0), new Role("Preacher with Ba", "The Lord will provide", 2, 0), new Role("Cyrus the Gunfighter", "Git to fightin' or git away!", 4,0)},{new Role("Man in Overalls", "Look like a storm's comin' in.", 1, 0), new Role("Mister Keach", "Howdy, stranger.", 3, 0)}, {new Role("Prisoner in Cell", "Zzzzzzz... Whiskey", 2, 0), new Role("Feller in Irons", "Ah kilt the wrong man!", 3, 0)}};
	         shots=new int[]{3,2,1};
				populateRooms(shots,names,tempRoles,this.Rooms);
            this.outDoors=new Room[] {Rooms.get("Train Station"), Rooms.get("Jail"), Rooms.get("Jail"), Rooms.get("General Store"), Rooms.get("General Store"), Rooms.get("Train Station"), Rooms.get("Train Station"), Rooms.get("Train Station")};
            break;
         }
	   }
   
   private void populateRooms(int[] shots, String[] names, Role[][] temp, HashMap<String, Room> hashbrowns){
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i]);
			hashbrowns.put(names[i],temp);
		return;
	   }
	}
	private int[] iDoors(Room R, Tile thisTile){
		ArrayList<Integer> indecies= new ArrayList<Integer>();
		String name = R.getName();
		for (int i=0; i<8; i++){
			if (name == thisTile.getDoors()[i].getName()){
				indecies.add(i);
			}
		}
		int tempsize=indecies.size();
		int[] DoorList=new int[tempsize];
		for(int j=0; j<tempsize; j++){
			DoorList[j]=(int)indecies.get(j);
		}
		return DoorList;
	}

	private boolean RoomCMP(Room a, Room b){
		return(a.getName().equals(b.getName()));
	}

	private void insertIntoDoors(Room newRoom, ArrayList<Room> list, Room me){
		if (!(RoomCMP(newRoom, me)||list.contains(newRoom))){
			list.add(newRoom);
		}
		return;
	}
	private void vert(ArrayList<Room> list, Room R, int[] doors, Tile thisTile){
		if (pos<2){
//n			System.out.println("board is: "+ thisTile.getBoard());
			Tile Temp=thisTile.getBoard().getTile(pos+2);
			for (int i: doors){
				switch(i){
					case 0:
						insertIntoDoors(thisTile.getDoors()[6], list, R);
						break;
					case 1:
						insertIntoDoors(thisTile.getDoors()[5], list, R);
						break;
					case 4:
						insertIntoDoors(Temp.getRoom(1), list, R);
						insertIntoDoors(thisTile.getDoors()[1], list, R);
						break;
					case 5:
						insertIntoDoors(Temp.getRoom(0), list, R);
						insertIntoDoors(thisTile.getDoors()[0], list, R);
						break;
					default:
						break;
				}
			}
		}
		else{
			Tile Temp=getBoard().getTile(pos-2);
			for (int i: doors){
				switch(i){
					case 0:
						insertIntoDoors(Temp.getRoom(6), list, R);
						insertIntoDoors(thisTile.getDoors()[6], list, R);
						break;
					case 1:
						insertIntoDoors(Temp.getRoom(5), list, R);
						insertIntoDoors(thisTile.getDoors()[5], list, R);
						break;
					case 5:
						insertIntoDoors(thisTile.getDoors()[1], list, R);
						break;
					case 6:
						insertIntoDoors(thisTile.getDoors()[0], list, R);
						break;
					default:
						break;
				}
			}
		}
		return;
	}

	private void hor(ArrayList<Room> list, Room R, int[] doors,Tile thisTile){
		Tile temp;
		if ((pos%2)<1){
			temp = getBoard().getTile(pos+1);
			for (int i: doors){
				switch(i){
					case 2:
						insertIntoDoors(temp.getRoom(7), list, R);
						insertIntoDoors(thisTile.getDoors()[7], list, R);
						break;
					case 3:
						insertIntoDoors(temp.getRoom(6), list, R);
						insertIntoDoors(thisTile.getDoors()[6], list, R);
						break;
					case 6:
						insertIntoDoors(thisTile.getDoors()[3], list, R);
						break;
					case 7:
						insertIntoDoors(thisTile.getDoors()[2], list, R);
						break;
					default:
						break;
				}
			}
		}
		else{
			temp = getBoard().getTile(pos-1);
			for (int j :doors){
				switch(j){
					case 2:
						insertIntoDoors(thisTile.getDoors()[7], list, R);
						break;
					case 3:
						insertIntoDoors(thisTile.getDoors()[6], list, R);
						break;
					case 6:
						insertIntoDoors(thisTile.getDoors()[3], list, R);
						insertIntoDoors(temp.getRoom(3), list, R);
						break;
					case 7:
						insertIntoDoors(thisTile.getDoors()[2], list, R);
						insertIntoDoors(temp.getRoom(2), list, R);
						break;
					default:
						break;
				}
			}
			return;
		}
	}

	public Room[] getRooms(Room R, Tile thisTile){
		ArrayList<Room> list = new ArrayList<Room>();
		int[] doors = iDoors(R, thisTile);
		vert(list, R, doors, thisTile);
		hor(list, R, doors, thisTile);
		Room[] newArray=new Room[list.size()];
		list.toArray(newArray);
		for (Room r : newArray){
		   System.out.printf(r.getName());
		}
		return newArray;
	}
   

	public void setDoors(Tile thisTile){
		Room[] doors = null;
		Room temp;
//		System.out.println("thisTile.getDoors: " + Arrays.toString(thisTile.getDoors()));
		for (Room R : thisTile.getDoors()){
		//	System.out.printf("%s",R.getName());
			if (!(thisTile.returnRooms().containsKey(R.getName()))){
				thisTile.returnRooms().put(R.getName(),R);
			}
		}
		for (String R : thisTile.returnRooms().keySet()){
			temp = thisTile.returnRooms().get(R);
			doors=getRooms(temp, thisTile);
			temp.setDoors(thisTile.getDoors());
		}
		return;
	}

   public Room findTrailers(){
   		return this.Rooms.get("Trailers");
   	}
   public abstract Board getBoard();
   
   public abstract Room[] getDoors();
   
   public abstract void setBoard(Board B);
   
   public abstract HashMap<String, Room> returnRooms();

   public abstract Room getRoom(int i);
}
   //Tile(int position, HashMap<String,  R){
   //	this.poition=pos;
   //	this.rooms = new HashMap<String, Room>
   //	for each Room in R{
   //		temp = new Room(
   //		insert into rooms
   
                     
