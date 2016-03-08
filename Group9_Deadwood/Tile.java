package Group9_Deadwood;
import java.util.*;

public abstract class Tile{
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
//	public Room getRoom(int i){
//		return outDoors[i];
//	}

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
   
                     