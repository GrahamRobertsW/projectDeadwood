package Group9_Deadwood;
import java.util.Scanner;
import java.util.random;
import java.util.HashMap;

public class Deadwood {

	private int NUMBER_OF_PLAYERS;
	private Scene[] SCENES;
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
		createScenes();
		
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
					//Current player turn options.
					switch (user_input) {
						case "move":
							string room_input = user_input.next();
<<<<<<< HEAD
							Room RoomInput = CURRENT_PLAYER.getRoom().getRoomKey(room_input);
							//Check for valid entry.
							if(RoomInput == null){
								System.out.printline("Invalid room name.");
								break;
							}
//							if(room_input != ("Bank" || "Main Street" || "Trailers" || "Saloon" || "Church" || "Scret Hideout" || "Casting Office" || "Train Station" || "Jail" || "General Store" || "Ranch" || "Hotel")){
//								System.out.printline("Invalid room name.");
//								break;
//							}
							//Check if already on a role.
							
=======
							//Check for valid entry.
							if(room_input != ("Bank" || "Main Street" || "Trailers" || "Saloon" || "Church" || "Scret Hideout" || "Casting Office" || "Train Station" || "Jail" || "General Store" || "Ranch" || "Hotel")){
								System.out.printline("Invalid room name.");
								break;
							}
							//Check if already on a role.
>>>>>>> c88edc63430440d26c99f89de599521b30f0d3aa
							if (CURRENT_PLAYER.getRole() != NULL) {
								System.out.println("You are on a role and can't move at this time.");
								break;
							}
							if (Has_Moved == true){
								System.out.println("You have already moved this turn.");
								break;
							}
<<<<<<< HEAD

							//Check valid direction.
							if(!CURRENT_PLAYER.move(RoomInput)){
								break;
							}
							//Move.
							
							CURRENT_PLAYER.setRoom(RoomInput);
=======
							//Check valid direction.
							
							//Move.
							Room roomInput = CURRENT_PLAYER.getRoom().getRoomKey(room_input);
							CURRENT_PLAYER.setRoom(roomInput);
>>>>>>> c88edc63430440d26c99f89de599521b30f0d3aa
							Has_Moved = true;
							//Read card.
							//Check if moving to a room where the scene has already finished.
							if(CURRENT_PLAYER.getRoom().checkSuccess() == true){
								System.out.println("This scene has already been completed.");
								break;
							}
							//Create a new scene, or report the current scene.
							if(CURRENT_PLAYER.getRoom().getScene() == null) {
								setNewScene();
								System.out.println("New Scene: " + CURRENT_PLAYER.getRoom().displayScene());
								break;
							} else {
								System.out.println("The current scene is: " + CURRENT_PLAYER.getRoom().displayScene());
								break;
							}
							
						case "work":
							string role_input = user_input.next();
							//Check if already working on a role.
							if (CURRENT_PLAYER.getRole() != null) {
								System.out.println("You are already working a role.");
								break;
							}
							//Check if someone else is working on the role.
							if(CURRENT_PLAYER.getRole().isTaken() == true) {
								System.out.println("Someone is already on this role.");
								break;
							}
							//Set role.
							CURRENT_PLAYER.setRole(role_input);
							break;
							
						case "upgrade":
							//Check if in the casting office.
							if(CURRENT_PLAYER.getRoom().equals("Casting Office")){
								string currency_input = user_input.next();
								//Check second input and upgade if eligible.
								switch (currency_input){
									case "$":
										int dollar_input = user_input.nextInt();
										CURRENT_PLAYER.rankMoney(dollar_input);
										break;
									case "cr":
										int credit_input = user_input.nextInt();
										CURRENT_PLAYER.rankCredits(credit_input);
										break;
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
								//Check if scene completed.
								if(CURRENT_PLAYER.getRoom().checkSuccess() == true){
									SCENE_COUNT++;
								}
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
			CURRENT_DAY++;
		}
		//Start end game process.
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
	
	//Sets a new scene to a room if the current player goes into a new room
	//where a scene is not yet set.
	private void setNewScene(){
		//Random number between 0 and 39
		int i = (int)(Math.random() * 39);
		if(!SCENES[i].used()){
			CURRENT_PLAYER.getRoom().setScene(SCENES[i]);
		} else {
			setNewScene();
		}
	}
	
	//Create scene objects.
    private void createScenes(){
        try(Scanner input = new Scanner(new File(scenes.txt))){
        	input.useDelimiter("|");
            while(input.hasNext()){
            	SCENES[input.next()] = new Scene();
            }
        } catch (FileNotFoundException ex) { System.err.println("Error: File not found.");}
    }

}
