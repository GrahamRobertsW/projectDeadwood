package Group9_Deadwood;
import java.util.*;

public class Scene{
	private String name;
	private String desc;
	private int budget;
	private HashMap<String, Role> Roles = new HashMap();
	private int index;
	private boolean use;
	private boolean success;
	private ArrayList<Players> players;
//	private boolean use;      
	Scene(String input){
//		System.out.println(input);
		int rank;
		String[] temp;// = new String[3];
		Role tempRole;
		use = false;
		success = false;
		String[] values= input.split("~");
		/*for (String S : values){
			System.out.println(S);
		}*/
		name = values[1];
      desc= values[2];
		this.players = new ArrayList<Players>();

		try{
			index=Integer.parseInt(values[0]);
			//System.out.printf("%d",index);
			budget=Integer.parseInt(values[3]);
			//System.out.printf("%d", budget);
		}
		catch(NumberFormatException e){
			System.out.format("Error parsing String to int is Scene %s",values[1]);
		}
		for (int i=4; i<values.length; i++){
			temp = values[i].split("#");
         //rank = Integer.parseInt(temp[2]);
         try{
				//System.out.printf("%s", temp[2]);
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
/*	
	public boolean getSuccess(){
		return this.success;
	}
	
	public void setSuccess(boolean val){
		this.success = val;
	}
*/
	public String getName(){
		return this.name;
	}

	public String getDesc(){
		return this.desc;
	}

   public HashMap<String, Role> getRoles(){
		return this.Roles;
	}
}
