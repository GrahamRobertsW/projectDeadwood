package Group9_Deadwood;
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
	private String FN;
//ublic Room getRoom(int i){
//		return outDoors[i];
//	}
   Tile(String filename){
		this.Rooms=new HashMap<String, Room>();
		this.FN=filename;
		Role[][] tempRoles;
		int[] shots;
		String[] names;
		switch(filename){
			case "HotelTile.png":
         	names = new String[] {"Hotel", "Bank", "Church"};
         	tempRoles = new Role[][]{{new Role("Faro Player", "Hit Me!", 1, 0), new Role("Sleeping Drunkard", "Zzzzzz Whiskey", 1,0), new Role("Australian Bartender", "What'll it be, mate?", 3, 0), new Role("Falls from Balcony", "Arrrgghh!!", 2, 0)},{new Role("Flustered Teller", "Would you like a large bill, sir?", 3, 0), new Role("Suspicious Gentleman", "Can you be more specific?", 2, 0)},{new Role("Dead Man", "...", 1, 0), new Role("Crying Woman", "oh, the humanity!", 2, 0)}};	
            shots = new int[] {3,1,2};
            pos = 3;
				populateRooms(shots,names,tempRoles,this.Rooms);
            this.outDoors =new Room[] {this.Rooms.get("Bank"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Hotel"), this.Rooms.get("Church"), this.Rooms.get("Church"), this.Rooms.get("Bank")};
				break;

			case "SecretTile.png":
            tempRoles=new Role[][]{{new Role("clumsy Pit Fighter", "Hit Me!", 1, 0), new Role("Thug with Knife", "Meet Suzy, my murderin' knife.", 2,0), new Role("Dangerous Tom", "/ther's two ways we can do this....", 3, 0), new Role("Penny, who is Lost", "Oh, woe! For I am Lost!", 4, 0)}, {new Role("Shot in Leg", "Ow, Me Leg!", 1, 0), new Role("Saucy Fred", "That's what she said!", 2, 0), new Role("Man Under Horse", "A little help here!", 3, 0)}};
				shots=new int[]{3,2};
            pos = 2;
				names=new String[]{"Secret Hideout", "Ranch"};
            this.Rooms.put("Casting Office",new Room("Casting Office"));
				populateRooms(shots,names,tempRoles,this.Rooms);
		      this.outDoors =new Room[] {Rooms.get("Casting Office"), Rooms.get("Ranch"), Rooms.get("Ranch"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Secret Hideout"), Rooms.get("Casting Office")};
            break;

			case "MainStTile.png":
				names = new String[] {"Main Street", "Saloon"};
	         tempRoles = new Role[][]{{new Role("Railroad Worker", "I'm a steel-drivin' man!", 1, 0), new Role("Falls off Roof", "Aaaaiiiiigggghh!", 2, 0), new Role("Woman in Black Dress", "Well, I'll be!", 2, 0), new Role("Mayor McGinty", "People of Deadwood!", 4, 0)},{new Role("Woman in Red Dress", "Come up and see me!", 2,0), new Role("Reluctant Farmer", "I ain't so sure about that!", 1, 0)}};
	         shots = new int[] {3,2};
            pos = 1;
            this.Rooms.put("Trailers", new Room("Trailers"));
				populateRooms(shots,names,tempRoles,this.Rooms);
		      this.outDoors = new Room[]{Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Main Street"),Rooms.get("Trailers"),Rooms.get("Trailers"),Rooms.get("Saloon"),Rooms.get("Saloon"),Rooms.get("Main Street")};
            break;

			case "TrainTile.png":
            names=new String[]{"Train Station","General Store", "Jail"};
	         tempRoles=new Role[][]{{new Role("Crusty Prospector", "Aww, peaches!", 1,0), new Role("Dragged by Train", "Omgeezers", 1, 0), new Role("Preacher with Ba", "The Lord will provide", 2, 0), new Role("Cyrus the Gunfighter", "Git to fightin' or git away!", 4,0)},{new Role("Man in Overalls", "Look like a storm's comin' in.", 1, 0), new Role("Mister Keach", "Howdy, stranger.", 3, 0)}, {new Role("Prisoner in Cell", "Zzzzzzz... Whiskey", 2, 0), new Role("Feller in Irons", "Ah kilt the wrong man!", 3, 0)}};
	         shots=new int[]{3,2,1};
            pos = 0;
				populateRooms(shots,names,tempRoles,this.Rooms);
            this.outDoors=new Room[] {Rooms.get("Train Station"), Rooms.get("Jail"), Rooms.get("Jail"), Rooms.get("General Store"), Rooms.get("General Store"), Rooms.get("Train Station"), Rooms.get("Train Station"), Rooms.get("Train Station")};
            break;
         }
	   }
   
   private void populateRooms(int[] shots, String[] names, Role[][] tempRoles, HashMap<String, Room> hashbrowns){
		for (int i=0; i<names.length; i++){
			Room temp=new Room(names[i], tempRoles[i], shots[i]);
			hashbrowns.put(names[i],temp);
         System.out.println("populateRooms " + names[i]);
	   }
	}
	private int[] iDoors(Room R){
		ArrayList<Integer> indecies= new ArrayList<Integer>();
		String name = R.getName();
		for (int i=0; i<8; i++){
			if (this.outDoors[i] != null)  {
            if (name == this.outDoors[i].getName()){
				   indecies.add(i);
            }
			}
		}
		int tempsize=indecies.size();
		int[] DoorList=new int[tempsize];
		for(int j=0; j<tempsize; j++){
			DoorList[j]=(int)indecies.get(j);
		}
		return DoorList;
	}
   
   public String getFN(){
      return this.FN;
   }
   
	private boolean RoomCMP(Room a, Room b){
      if (a != null && b != null) {
   		return(a.getName().equals(b.getName()));
      }
      else {
         return false;
      }
	}
   //Is this an and??? or is it an or????? Find out the hard way
	private void insertIntoDoors(Room newRoom, ArrayList<Room> list, Room me){
		if (!(RoomCMP(newRoom, me))&& !(list.contains(newRoom))){
			list.add(newRoom);
		}
		return;
	}
	private void vert(ArrayList<Room> list, Room R, int[] doors){
		if (pos<2){
         //System.out.println("Hello from vert! " + R.getName() + "\n");
//n			System.out.println("board is: "+ thisTile.getBoard());
         Tile Temp= this.getBoard().getTile(pos+2);
			for (int i: doors){
				switch(i){
					case 0:
						insertIntoDoors(this.outDoors[5], list, R);
						break;
					case 1:
						insertIntoDoors(this.outDoors[4], list, R);
						break;
					case 4:
						insertIntoDoors(Temp.getRoom(1), list, R);
						insertIntoDoors(this.outDoors[1], list, R);
						break;
					case 5:
						insertIntoDoors(Temp.getRoom(0), list, R);
						insertIntoDoors(this.outDoors[0], list, R);
						break;
					default:
						break;
				}
			}
		}
		else{
         //System.out.println("Hello from the bottom of the board in vert " + R.getName() + "\n");
			Tile Temp=getBoard().getTile(pos-2);
			for (int i: doors){
				switch(i){
					case 0:
						insertIntoDoors(Temp.getRoom(5), list, R);
						insertIntoDoors(this.outDoors[5], list, R);
						break;
					case 1:
						insertIntoDoors(Temp.getRoom(4), list, R);
						insertIntoDoors(this.outDoors[4], list, R);
						break;
					case 4:
						insertIntoDoors(this.outDoors[1], list, R);
						break;
					case 5:
						insertIntoDoors(this.outDoors[0], list, R);
						break;
					default:
						break;
				}
			}
		}
		return;
	}

	private void hor(ArrayList<Room> list, Room R, int[] doors){
		Tile temp;
      //System.out.println("int doors " + Arrays.toString(doors));
      //System.out.println("POS " + pos);
		//if ((pos%2)<1){
      if ((pos%2)<1) {
         //System.out.println("Hor %2???? " + R.getName() + "\n");
			temp = getBoard().getTile(pos+1);
			for (int i: doors){
				switch(i){
					case 2:
						insertIntoDoors(temp.getRoom(7), list, R);
						insertIntoDoors(this.outDoors[7], list, R);
						break;
					case 3:
						insertIntoDoors(temp.getRoom(6), list, R);
						insertIntoDoors(this.outDoors[6], list, R);
						break;
					case 6:
						insertIntoDoors(this.outDoors[3], list, R);
						break;
					case 7:
						insertIntoDoors(this.outDoors[2], list, R);
						break;
					default:
						break;
				}
			}
		}
		else{
        // System.out.println("Hor pt 2. Anyone home????? " + R.getName() + "\n");
			temp = getBoard().getTile(pos-1);
			for (int j :doors){
				switch(j){
					case 2:
						insertIntoDoors(this.outDoors[7], list, R);
						break;
					case 3:
						insertIntoDoors(this.outDoors[6], list, R);
						break;
					case 6:
						insertIntoDoors(this.outDoors[3], list, R);
						insertIntoDoors(temp.getRoom(3), list, R);
						break;
					case 7:
						insertIntoDoors(this.outDoors[2], list, R);
						insertIntoDoors(temp.getRoom(2), list, R);
						break;
					default:
						break;
				}
			}
			return;
		}
	}

	public Room[] getRooms(Room R){
		ArrayList<Room> list = new ArrayList<Room>();
		int[] doors = iDoors(R);
		vert(list, R, doors);
		hor(list, R, doors);
		Room[] newArray=new Room[list.size()];
		list.toArray(newArray);
		for (int i =0; i < newArray.length; i++){
         Room r = list.get(i);
         if (r != null) {
            newArray[i] = r;
   		   //System.out.printf(r.getName());
         }
		}
		return newArray;
	}
   

	public void setDoors(){
		Room[] doors;
		Room temp;
		for (Room R : this.outDoors){
         // System.out.println("Outdoors in first loop: " + this.outDoors + "\n");
			if (( R != null) && !(this.Rooms.containsKey(R))){
          //  System.out.println("Bitches and ho's: " + R.getName() + "\n");
				this.Rooms.put(R.getName(),R);
			}
		}
      //System.out.println("Key set " + this.Rooms.keySet());
		for (String R : this.Rooms.keySet()){
        // System.out.println("Second for looooooooop: " + R + "\n");
			temp = this.Rooms.get(R);
			doors=getRooms(temp);
			//temp.setDoors(this.outDoors);
         temp.setDoors(doors);
		}
	}

   public Room findTrailers(){
   		return this.Rooms.get("Trailers");
   	}
   public Board getBoard(){
		return this.board;
	}

   public Room[] getDoors(){
		return this.outDoors;
	}
   
   public void setBoard(Board B){
		this.board=B;
	}
   
   public HashMap<String, Room> returnRooms(){
		return this.Rooms;
	}

   public Room getRoom(int i){
		return this.outDoors[i];
	}
}
   //Tile(int position, HashMap<String,  R){
   //	this.poition=pos;
   //	this.rooms = new HashMap<String, Room>
   //	for each Room in R{
   //		temp = new Room(
   //		insert into rooms
   
                     
