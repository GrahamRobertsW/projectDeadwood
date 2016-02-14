package Group9_Deadwood;
import java.util.HashMap;

public class tile{
	private HashMap<String, room> rooms;
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
	//     |          |
	//     |          |  
	//    _|          |_
   //    6            3 
	//    _  _______   _
	//     |5|      |4|

	private String[] doors;
   private String[] outDoors;
}   
	//Tile(int position, HashMap<String,  R){
	//	this.poition=pos;
	//	this.rooms = new HashMap<String, Room>
	//	for each Room in R{
	//		temp = new Room(
	//		insert into rooms

