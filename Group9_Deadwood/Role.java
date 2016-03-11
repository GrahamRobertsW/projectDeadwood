/* Role is simple and requires minimal explanation. 
 *	
 */



package Group9_Deadwood;
import java.util.Random.*;

public class Role{
	private int rank;
	private boolean taken;
	private int star;
	private String name;
	private String quip;
	private Players player;

	Role(String N,String Q,int R,int S){
		this.name=N;
		this.quip=Q;
		this.rank=R;
		this.star=S;
		this.taken=false;
		this.player=null;
	}

	public String getName(){
		return this.name;
	}

	public String getQuip(){
		return this.quip;
	}

	public int getRank(){
		return this.rank;
	}

	public boolean isTaken(){
		return this.taken;
	}

	public void setTaken(Boolean b) {
		this.taken = b;
	}

	public void setPlayer(Players P){
		this.taken=true;
		this.player=P;
		return;
	}

	public Players getPlayer(){
		return this.player;
	}

	public int isStarring(){
		return this.star;
	}
}
