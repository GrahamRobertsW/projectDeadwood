package Group9_Deadwood;
import java.util.Scanner;
import java.util.random;
import java.util.HashMap;


public class Deadwood {

	private int NUMBER_OF_PLAYERS;
	private int CURRENT_DAY;
	private Players[] TURN_ORDER;
	private Players CURRENT_PLAYER;
	private int SCENE_COUNT;
	private String[] PLAYER_NAMES = ["blue","red","yellow","orange","green","violet","pink","cyan"]

	public static void main(String[] args) {
		newGame();
	}
	
	private void newGame(){
		Scanner user_input = new Scanner(System.in);
		System.out.print("Start a new game? (y/n)");
		char new_game = user_input.next();
		if(new_game == 'y'){
			// initialize variables here.
			NUMBER_OF_PLAYERS = null;
			CURRENT_DAY = 0;
			TURN_ORDER = null;
			CURRENT_PLAYER = null;
			SCENE_COUNT = 0;
			startGame();
		} else {
			System.exit(0);
		}
	}
	
	private void startGame(){
		//Initialize the board pseudo-randomly
		/*int tile_order = (int)(Math.random() * 4);
		HotelTile = new HotelTile(tile_order);
		MainStTile = new MainStTile((tileorder+1) % 3);
		SecretTile = new SecretTile((tileorder+2) % 3);
		TrainTile = new TrainTile((tileorder+3) % 3);*/
		
		Board = new Board();
		
		//Set player count and initialize
		System.out.println("How many players?");
		NUMBER_OF_PLAYERS = user_input.next();
		
		//Initialize the players. Still needs randomization.
		for(int i; i < NUMBER_OF_PLAYERS; i++){
			TURN_ORDER[i] = new Players(0, 0, 0, 0, PLAYER_NAMES[i], null, null);
		}
		
		//Begin the game
		setTurn(0);
		while(CURRENT_DAY < 3){
			while(SCENE_COUNT < 9) {
				System.out.println(CURRENT_PLAYER.getName() + "'s turn. Enter an action.");
				boolean Valid_Entry = false;
				boolean Has_Moved = false;
				boolean Has_Worked = false;
				while(!Valid_Entry){
					System.out.printline("Enter a command.");
					Scanner.user_input = new Scanner (System.in);
					string input = user_input.next();
					//current turn options
					switch (user_input) {
						case "move":
							string room_input = user_input.next();
							//check if valid entry
							if(room_input != ("Bank" || "Main Street" || "Trailers" || "Saloon" || "Church" || "Scret Hideout" || "Casting Office" || "Train Station" || "Jail" || "General Store" || "Ranch" || "Hotel")){
								System.out.printline("Invalid room name.");
								break;
							}
							//check if on a role
							if (CURRENT_PLAYER.getRole() != NULL) {
								System.out.println("You are on a role and can't move at this time.");
								break;
							}
							if (Has_Moved == true){
								System.out.println("You have already moved this turn.");
								break;
							}
							//check valid direction.
							
							//move
							CURRENT_PLAYER.setRoom(room_input);
							Has_Moved = true;
							//read card
							if(!CURRENT_PLAYER.getRoom.getSceneUsed()){
								CURRENT_PLAYER.getRoom.getSceneUsed(true);
								SCENE_COUNT++;
							}
							System.out.println("The current scene is " + CURRENT_PLAYER.getRoom.getScene());
							break;
							
						case "work":
							string role_input = user_input.next();
							//check if working on a role
							if (CURRENT_PLAYER.getRole() != NULL) {
								System.out.println("You are already working a role.");
								break;
							}
							//set a role
							CURRENT_PLAYER.setRole(role_input);
							break;
							
						case "upgrade":
							//check room
							if(CURRENT_PLAYER.getRoom().equals("Casting Office")){
								string currency_input = user_input.next();
								switch (currency_input){
									case "$":
										int dollar_input = user_input.nextInt();
										CURRENT_PLAYER.rankMoney(dollar_input);
										
									case "cr":
										int credit_input = user_input.nextInt();
										CURRENT_PLAYER.rankCredits(credit_input);
										
									default:
										System.out.println("Invalid input.");
										break;
								}
							} else {
								System.out.println("You are not in the Casting Office.");
								break;
							}
							break;
							
						case "who":
							System.out.println(CURRENT_PLAYER.getName() + " " + CURRENT_PLAYER.getRole());
							break;
							
						case "where":
							System.out.println(CURRENT_PLAYER.getRoom() + " " + CURRENT_PLAYER.getScene());
							break;
							
						case "rehearse":
							if(Has_Worked == true){
								System.out.println("You've already worked this turn.");
								break;
							}
							if(!CURRENT_PLAYER.rehearsal()) {
								break;
							} else {
								Has_Worked = true;
								break;
							}
							
						case "act":
							if(Has_Worked == true){
								System.out.println("You've already worked this turn.");
								break;
							}
							if(!CURRENT_PLAYER.act()){
								break;
							} else {
								Has_Worked = true;
								break;
							}
							
						case "end":
							setTurn(CURRENT_PLAYER++);
							Valid_Entry = true;
							break;
							
						default:
							System.out.println("Invalid input.");
							break;
					}
				}
			}
			setDay(CURRENT_DAY++);
			//Create new scenes from room class?
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
		newGame();
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
}
