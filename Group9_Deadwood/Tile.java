package Group9_Deadwood;
import java.util.*;

public class Tile{
	private HashMap<String, Room> Rooms;
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
	public Room getRoom(int i){
		return outDoors[i];
	}

	private int[] iDoors(Room R){
		ArrayList<Integer> indecies= new ArrayList<Integer>();
		String name = R.getName();
		for (int i=0; i<8; i++){
			if (name == outDoors[i].getName()){
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
   private void vert(ArrayList<Room> list, Room R, int[] doors){
	   if (pos<2){
		   Tile Temp=board.getTile(pos+2);
         for (int i: doors){
				switch(i){
					case 0:
						insertIntoDoors(outDoors[6], list, R);
						break;
					case 1:
                  insertIntoDoors(outDoors[5], list, R);
						break;
					case 4:
						insertIntoDoors(Temp.getRoom(1), list, R);
						insertIntoDoors(outDoors[1], list, R);
						break;
					case 5:
						insertIntoDoors(Temp.getRoom(0), list, R);
						insertIntoDoors(outDoors[0], list, R);
						break;
					default:
					break;
				}
			}
		}
      else{
			Tile Temp=board.getTile(pos-2);
			for (int i: doors){
				switch(i){
					case 0:
                  insertIntoDoors(Temp.getRoom(6), list, R);
						insertIntoDoors(outDoors[6], list, R);
						break;
					case 1:
                  insertIntoDoors(Temp.getRoom(5), list, R);
						insertIntoDoors(outDoors[5], list, R);
						break;
					case 5:
						insertIntoDoors(outDoors[1], list, R);
						break;
					case 6:
						insertIntoDoors(outDoors[0], list, R);
						break;
					default:
						break;
					}
			}
		}
		return;
	}

   private void Hor(ArrayList<Room> list, Room R, int[] doors){
      if ((pos%2)<1){
			Tile temp = board.getTile;
         for (int i: doors){
				switch(i){
					case 2:
	                                   insertIntoDoors(Temp.getRoom(7), list, R);
					   insertIntoDoors(outDoors[7], list, R);
                  break;
					case 3:
						insertIntoDoors(Temp.getRoom(6), list, R);
						insertIntoDoors(outDoors[6], list, R);
						break;
					case 6:
						insertIntoDoors(outDoors[3], list, R);
						break;
					case 7:
						insertIntoDoors(outDoors[2], list, R);
						break;
					default:
						break;
            }
			}
		}
		else{
			for (int j :doors){
                           switch(j){
			      case 2:
                                 insertIntoDoors(outDoors[7], list, R);
                                 break;
                              case 3:
                                 insertIntoDoors(outDoors[6], list, R);
                                 break;
                              case 6:
                                 insertIntoDoors(outDoors[3], list, R);
                                 insertIntoDoors(Temp.getRoom(3), list, R);
                                 break;
                              case 7:
                                 insertIntoDoors(outDoors[2], list, R);
                                 insertIntoDoors(Temp.fetRoom(2), list, R);
                                 break;
                              default:
                                 break;

}
	//Tile(int position, HashMap<String,  R){
	//	this.poition=pos;
	//	this.rooms = new HashMap<String, Room>
	//	for each Room in R{
	//		temp = new Room(
	//		insert into rooms

