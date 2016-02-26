package Group9_Deadwood;
import java.util.*;

public class Scene{
	private String name;
	private String desc;
	private int budget;
	private HashMap<String, Role> Roles;
	private int index;
<<<<<<< HEAD
//	private boolean use;
//	private boolean success;
      	private List<Players> players = new List<Players>
=======
	private List<Players> players;
//	private boolean use;      
>>>>>>> c88edc63430440d26c99f89de599521b30f0d3aa
	Scene(String input){
		int rank;
		String[] temp;
		Role tempRole;
//		use = false;
//		success = false;
		String[] values= input.split("~");
		name = values[1];
      desc= values[2];
		this.players = new List<Players>;

		try{
			index=Integer.parseInt(values[0]);
			budget=Integer.parseInt(values[3]);
		}
		catch(NumberFormatException e){
			System.out.format("Error parsing String to int is Scene %s",values[1]);
		}
		for (int i=4; i<values.length; i++){
			temp = values[i].split(",");
			try{
				rank=Integer.parseInt(temp[2]);
            tempRole=new Role(temp[0], temp[1], rank, 1);
            Roles.put(temp[0], tempRole);
				}
			catch(NumberFormatException g){
				System.out.format("Error could not parse rank in Scene%s, Role%s", values[1], temp[0]);
			}
		}
	}

	public int getBudget(){
		return this.budget;
	}
	
	public void addPlayer(Player player){		
		players.add(player);
	}
<<<<<<< HEAD
=======
	public List<Players> getPlayers(){
		return this.players()
	}
>>>>>>> c88edc63430440d26c99f89de599521b30f0d3aa
/*
	public boolean used(){
		return this.use;
	}

	public void used(boolean value){
		this.use = value;
	}
<<<<<<< HEAD
	
	public boolean getSuccess(){
		return this.success;
	}
	
	public void setSuccess(boolean val){
		this.success = val;
	}

	public string getName(){
		reutn this.name;
	}

	public string getDesc(){
		return this.desc;
	}
*/
	
}
=======
<<<<<<< HEAD
*/
}	
>>>>>>> c88edc63430440d26c99f89de599521b30f0d3aa
