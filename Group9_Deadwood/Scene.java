/* Scene takes in a .txt file that contains the scene number 1-40, the name and budget, information about the scene, and the roles on the scene with their rank
 * Players are added and removed from scenes as they come and go. 
 */


package Group9_Deadwood;
import java.util.*;

public class Scene{
	private String name;
	private String desc;
	private int budget;
	private HashMap<String, Role> Roles;
	private int index;
	private boolean use;
	private boolean success;
	private ArrayList<Players> players;
	Scene(String input){
		int rank;
		String[] temp;
		Role tempRole;
		use = false;
		this.Roles = new HashMap<String, Role>();
		success = false;
		String[] values= input.split("~");
		name = values[1];
      		desc= values[2];
		this.players = new ArrayList<Players>();

		try{
			index=Integer.parseInt(values[0]);
			budget=Integer.parseInt(values[3]);
		}
		catch(NumberFormatException e){
			System.out.format("Error parsing String to int is Scene %s",values[1]);
		}
		for (int i=4; i<values.length; i++){
			temp = values[i].split("#");
         try{
	    rank=Integer.parseInt(temp[2]);
            String name = temp[0];
            String quip = temp[1];
            tempRole=new Role(name, quip, rank, 1);
            Roles.put(name, tempRole);
				}
			catch(NumberFormatException g){
				System.out.format("Error could not parse rank in Scene: %s\n. Role: %s", values[1], temp[0]);
			}
		}
	}

	public int getBudget(){
		return this.budget;
	}
	
	public void addPlayer(Players player){		
		players.add(player);
	}

	public void removePlayer(Players player) {
		players.remove(player);
		players.trimToSize();
	}
	public ArrayList<Players> getPlayers(){
		return this.players;
	}

	public boolean used(){
		return this.use;
	}

	public void used(boolean value){
		this.use = value;
	}
	public String getName(){
		return this.name;
	}

	public String getDesc(){
		return this.desc;
	}

	public String getQuip() {
		return this.desc;
	}
	
	public HashMap<String, Role> getRoles(){
		return this.Roles;
	}
}
