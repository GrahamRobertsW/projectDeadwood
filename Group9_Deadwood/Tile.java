package Group9_Deadwood;
import java.util.HashMap;

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

	public Room getRoom(int i){
		return outDoors[i];
	}

	private int[] iDoors(Room R){
		ArrayList<Room> = list;
		List<int> = indecies;
		String name = R.getName();
		for (int 1=0; i<8; i++){
			if name == outDoors[i].getName(){
				List.add(i);
      }
      return List.toArray(int[0]);
   }
}

   private vert(int[] list, Room R){
	   <? extends Tile> Temp;
	   if pos<2{
		   Temp=Board.getTile(pos+2);
         for (int i: list){
				switch(i){
					case 0:
						insertIntoDoors(outDoors[6], list, R);
					case 1:
                  insertIntoDoors(outDoors[5], list, R);
					case 4:
						insertIntoDoors(Temp.getRoom[1], list, R);
						insertIntoDoorsw(outDoors[1], list, R);
					case 5:
						insertIntoDoors(Temp.getRoom[0], list, R);
						insertIntoDoors(outDoors[0], list, R);
					default:
					
				}
			}
		}
      else{
			Temp=Board.getTile(pos-2);
			for (int i: list){
				switch{
					case 0:
         
       
}   
	//Tile(int position, HashMap<String,  R){
	//	this.poition=pos;
	//	this.rooms = new HashMap<String, Room>
	//	for each Room in R{
	//		temp = new Room(
	//		insert into rooms

