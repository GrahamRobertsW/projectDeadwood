package Group9_Deadwood;
import java.util.Random.*;

public class Role{
	private int rank;
	private int taken;
	private int star;
	private String name;
	private String quip;

	Role(String N,String Q,int R,int S){
		this.name=N;
		this.quip=Q;
		this.rank=R;
		this.star=S;
		this.taken=0;
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

	public int isTaken(){
		return this.taken;
	}

	public void setPlayer(){
		this.taken=1;
		return;
	}

	public int isStarring(){
		return this.star;
	}
}