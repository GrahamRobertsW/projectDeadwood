package Group9_Deadwood;
import java.util.Random.*;

public class role{
	private int rank;
	private int taken;
	private int star;
	private String name;
	private String quip;

	role(String N,String Q,int R,int S){
		this.name=N;
		this.quip=Q;
		this.rank=R;
		this.star=S;
		this.taken=0;
	}

	public String name(){
		return this.name;
	}

	public String quip(){
		return this.quip;
	}

	public int rank(){
		return this.rank;
	}

	public int isTaken(){
		return this.taken;
	}

	public void setPlayer(){
		this.taken=1;
	}
}
