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
		System.out.println("How many players?");
		NUMBER_OF_PLAYERS = user_input.next();
		
		for(int i; i < NUMBER_OF_PLAYERS; i++){
			TURN_ORDER[i] = new Players(0, 0, 0, 0, PLAYER_NAMES[i], null, null);
		}
		
		//Begin the game
		CURRENT_TURN = 0;
		CURRENT_DAY = 0;
		SCENE_COUNT = 0;
		setDay(CURRENT_DAY);
		setTurn(CURRENT_TURN);
		while(CURRENT_DAY < 3){
			while(SCENE_COUNT < 9) {
				System.out.println("Work, move, or upgrade?(m/w/u)");
				Scanner.user_input = new Scanner (System.in);
				char input = user_input.next();
				
				//current turn options
				switch(input) {
					case 'm': //move stuff
						//check if on a role
						System.out.println("direction? up, left, down, right.(w/a/s/d)");
						char direction = user_input.next();
						
						//check valid direction
						//set room
						//set role?
						//read card?

						break;
					case 'w': //work stuff
						//check if working on a role
						System.out.println("Act or rehearse?(a/r)");
						char work = user_input.next();
						//act
						//rehearse
						break;
					case 'u': //upgrade stuff
						//check room
						System.out.println("How much do you want to raise your rank by? (enter a number)");
						int upgrade = user_input.next();
						//check if eligible
						//upgrade
						//check if player has moved or worked this turn.
							//if not, repeat.
						break;
					//invalid input case
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
	
	private int calculateScore(Players player){
		return player.getMoney() + player.getCredits() +(player.getRank() * 5);
	}
	
	private void setTurn(int turn){
		CURRENT_PLAYER = TURN_ORDER[turn];
	}
	public Player getTurn(){
		return CURRENT_PLAYER.getPlayer();
	}
	
	private void setDay(int day){
		CURRENT_DAY = day;
	}
	
	public void displayRules(){
		//rules
	}

}
