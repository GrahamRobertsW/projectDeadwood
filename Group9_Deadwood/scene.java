package Group9_Deadwood;
import java.util.HashMap;

public class scene{
	private String name;
	private String desc;
	private int budget;
	private HashMap<String, role> roles;
	private int index;
      
	scene(String input){
		int rank;
		String[] temp;
		role tempRole;
		String[] values= input.split("~");
		name = values[1];
      desc= values[2];
		try{
			index=Integer.parseInt(values[0]);
			budget=Integer.parseInt(values[3]);
		}
		catch(NumberFormatException e){
			System.out.format("Error parsing String to int is scene %s",values[1]);
		}
		for (int i=4; i<values.length; i++){
			temp = values[i].split(",");
			try{
				rank=Integer.parseInt(temp[2]);
            tempRole=new role(temp[0], temp[1], rank, 1);
            roles.put(temp[0], tempRole);
				}
			catch(NumberFormatException g){
				System.out.format("Error could not parse rank in scene%s, role%s", values[1], temp[0]);
			}
		}

	}

	
}	
