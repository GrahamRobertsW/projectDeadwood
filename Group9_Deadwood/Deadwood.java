package Group9_Deadwood;
import java.util.Scanner;
import java.util.random;
import java.util.HashMap;


public class Deadwood {

	private int NUMBER_OF_PLAYERS;
	private int NUMBER_OF_DAYS;
	private int CURRENT_DAY;
	private Players[] TURN_ORDER;
	private int CURRENT_TURN;
	private Players CURRENT_PLAYER;
	private int SCENE_COUNT;
	private String[] PLAYER_NAMES = ["blue","red","yellow","orange","green","purple","gray","cyan"]

	public static void main(String[] args) {
		
		Scanner user_input = new Scanner(System.in);
		
		System.out.print("Start a new game? (y/n)");
		char new_game = user_input.next();
		if(new_game == 'y'){
			startGame();
		} else {
			System.exit(0);
		}
		
	}
	
	private void startGame(){
		
		//Initialize the board pseudo-randomly
		int tile_order = (int)(Math.random() * 4);
		HotelTile = new HotelTile(tile_order);
		MainStTile = new MainStTile((tileorder+1) % 3);
		SecretTile = new SecretTile((tileorder+2) % 3);
		TrainTile = new TrainTile((tileorder+3) % 3);
		
		//Set player count and initialize
		System.out.print("How many players?");
		NUMBER_OF_PLAYERS = user_input.next();
		
		for(int i; i < NUMBER_OF_PLAYERS; i++){
			TURN_ORDER[i] = new Players(0, 0, 0, 0, PLAYER_NAMES[i], null, null);
		}
		
		//Begin the game
		CURRENT_TURN = 0;
		CURRENT_DAY = 0;
		setDay(CURRENT_DAY);
		setTurn(CURRENT_TURN);
		while(CURRENT_DAY < 3){
			while(Scene.getSceneNumber < 9) {
				System.out.print("Work, move, or upgrade?(w/m/u)");
				Scanner.user_input = new Scanner (System.in);
				char input = user_input.next();
				
				//current turn options
				switch (user_input) {
					case 1: input = "w";
						//work
						break;
					case 2: input = "m";
						//move
						break;
					case 3: input = "u";
						//upgrade
						break;
				}
				//new turn
				setTurn(CURRENT_TURN++)
			}
			setDay(CURRENT_DAY++);
		}
		
		//Start end game process
		endGame();
		
	}
	
	private void endGame(){
		private HashMap <Player, int> score;
		for(int i; i < NUMBER_OF_PLAYERS; i++){
			score.put(TURN_ORDER[i], calculateScore(TURN_ORDER[i]);
		}
		
		String winner = score.get(TURN_ORDER[0]);
		for(int i = 1; i < score.length; i++){
			if(score.get(TURN_ORDER[i]) > max){
				winner = score.get(TURN_ORDER[i].getName())
			}
		}
		System.out.print(winner + " is the winner!");
		
		// initialize variables to 0 here.
		
		Scanner user_input = new Scanner(System.in);
		
		System.out.print("Start a new game? (y/n)");
		char new_game = user_input.next();
		if(new_game == 'y'){
			NUMBER_OF_PLAYERS = null;
			NUMBER_OF_DAYS = null;
			CURRENT_DAY = null;
			TURN_ORDER = null;
			CURRENT_TURN = null;
			CURRENT_PLAYER = null;
			SCENE_COUNT = null;
			startGame();
		} else {
			System.exit(0);
		}
		
	}
	
	public int calculateScore(Players player){
		return player.getMoney() + player.getCredits() +(player.getRank() * 5);
	}
	
	public void setTurn(int turn){
		CURRENT_PLAYER = TURN_ORDER[turn];
	}
	public Player getTurn(){
		return CURRENT_PLAYER.getPlayer();
	}
	
	public void setDay(int day){
		CURRENT_DAY = day;
	}
	
	public void displayRules(){
		//rules
	}

}
