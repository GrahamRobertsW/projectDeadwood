package Group9_Deadwood;
import java.util.Scanner;
import java.util.*;
import java.util.HashMap;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Deadwood {

	private int NUMBER_OF_PLAYERS;
	private Scene[] SCENES = new Scene[40];
	private int CURRENT_DAY;
	private Players[] TURN_ORDER;
	private Players CURRENT_PLAYER;
	private int SCENE_COUNT;
	private String[] PLAYER_NAMES = new String[] {"blue","red","yellow","orange","green","violet","pink","cyan"};
   
	public Deadwood(){
		newGame();
	}
   public static void main(String[] args){
		Deadwood DW = new Deadwood();
	}

	private void newGame(){
		Scanner user_input = new Scanner(System.in);
		System.out.print("Start a new game? (y/n)");
		String new_game = user_input.next();
		if(new_game.equals("y")){
			// initialize variables here.
			NUMBER_OF_PLAYERS = 0;
			CURRENT_DAY = 0;
			TURN_ORDER = null;
			CURRENT_PLAYER = null;
			SCENE_COUNT = 0;
			startGame();
		} else {
			System.exit(0);
		}
	}
	
	private void createTurnOrder(int ordernum){
		TURN_ORDER[ordernum] = new Players(0, 1, 0, 0, PLAYER_NAMES[ordernum]);
      //int i = (int)(Math.random() * NUMBER_OF_PLAYERS);
		/*if(TURN_ORDER[ordernum] == null){
 	               TURN_ORDER[ordernum] = new Players();
		} else {
			createTurnOrder(ordernum);
		
	   }*/
   }
	
	private void startGame(){
		//Initialize the board pseudo-randomly
		/*int tile_order = (int)(Math.random() * 4);
		HotelTile = new HotelTile(tile_order);
		MainStTile = new MainStTile((tileorder+1) % 3);
		SecretTile = new SecretTile((tileorder+2) % 3);
		TrainTile = new TrainTile((tileorder+3) % 3);*/
		
		Board board = new Board();
		board.initializeBoard();
		board.initializeTiles();
		createScenes();
		
		//Set player count and initialize
		System.out.println("How many players? Between 3 and 8. ");
		Scanner player_num = new Scanner (System.in);
		NUMBER_OF_PLAYERS = player_num.nextInt();
      while (NUMBER_OF_PLAYERS < 1 || NUMBER_OF_PLAYERS > 8) {
         System.out.println("Please choose input between 3 and 8.");
         NUMBER_OF_PLAYERS = player_num.nextInt();
      }
      TURN_ORDER = new Players[NUMBER_OF_PLAYERS];
		
		//Initialize the players. Still needs randomization.
		for(int i=0; i < NUMBER_OF_PLAYERS; i++){
			createTurnOrder(i);
		}
		Room Trailers=board.getTile(1).findTrailers();
		for (Players P: TURN_ORDER){
			P.setRoom(Trailers);
		}
		
		//Begin the game
		setTurn(0);
		while(CURRENT_DAY < 3){
			while(SCENE_COUNT < 9) {
				
				boolean New_Turn = false;
				boolean Has_Moved = false;
				boolean Has_Worked = false;
				while(!New_Turn){
               System.out.println(CURRENT_PLAYER.getName() + "'s turn. Enter an action. Options: move, work, act, rehearse, who, where, upgrade, end");
					//System.out.println("Enter a command. ");
					Scanner user_input = new Scanner (System.in);
					String input = user_input.next();
					//Current player turn options.
					switch (input) {
						case "move":
                     Has_Moved = move(Has_Moved);
                     break;
						case "work":
                     work(Has_Worked);
                     break;
						case "upgrade":
							upgrade();
                     break;
						case "who":
							System.out.println(CURRENT_PLAYER.getName());
                     System.out.println("Money: $" + CURRENT_PLAYER.getMoney());
                     System.out.println("Credits: " + CURRENT_PLAYER.getCredits());
                     System.out.println("Rank: " + CURRENT_PLAYER.getRank());
							if(CURRENT_PLAYER.getRole()!=null){
								System.out.println(CURRENT_PLAYER.getRole().getName());
							}
							else{
								System.out.println("Ya don't have a role ya lazy bum");
							}
							break;
							
						case "where":
							System.out.println(CURRENT_PLAYER.getRoom().getName());
							if(CURRENT_PLAYER.getRoom().getScene()!=null){
								System.out.println(CURRENT_PLAYER.getRoom().getScene().getName());
							}
							else{
								System.out.println("This Room doesn't have a Scene");
							}
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
								Has_Worked = true;
								break;
							}
							
						case "end":
							int n=findIndexPlayer(TURN_ORDER, CURRENT_PLAYER);
                     n++;
							setTurn(n);
							New_Turn = true;
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
   public void countScene(){
		SCENE_COUNT++;
	}

	private void endGame(){
		HashMap<Players, Integer> score = new HashMap<Players, Integer>();
		for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
			score.put(TURN_ORDER[i], calculateScore(TURN_ORDER[i]));
		}
		int max = 0;
		String winner = null;
		for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
			if(score.get(TURN_ORDER[i]) > max){
			winner = TURN_ORDER[i].getName();
		
			}
		}
			System.out.println(winner + " is the winner!");
		newGame();
	}
	
   private boolean move(boolean moved) {
       if (moved == true){
         System.out.println("You have already moved this turn.");
         return true;
      }
      System.out.println("Current room: " + CURRENT_PLAYER.getRoom().getName());
      System.out.println("Rooms you can move to: "); 
      CURRENT_PLAYER.getRoom().printDoors();
      Scanner user_input = new Scanner (System.in);
      String room_input = user_input.nextLine();      
      Room RoomInput = CURRENT_PLAYER.getRoom().getRoomKey(room_input);

      //Check for valid entry.
      if(room_input == null){
         System.out.println("Invalid room name.");
         return false;
      }
      //System.out.println("Room key " + room_input);

      if (CURRENT_PLAYER.getRole() != null) {
         System.out.println("You are on a role and can't move at this time.");
          return false;
      }

      //Check valid direction.
      if(!CURRENT_PLAYER.move(RoomInput)){
         return false;
      }
		if(CURRENT_PLAYER.getRoom().getScene()==null&&!CURRENT_PLAYER.getRoom().isComplete()){
			if(!(CURRENT_PLAYER.getRoom().getName().equals("Trailers")||CURRENT_PLAYER.getRoom().getName().equals("Casting Office"))){
				CURRENT_PLAYER.getRoom().setScene(this.SCENES[SCENE_COUNT]);
			   this.SCENE_COUNT++;
			}
		}
      return true;
   }
   
   private void work(boolean Has_Worked) {
      if (CURRENT_PLAYER.getRoom().getScene()==null){
         System.out.println("This room has no work for you!");
         return;
      }
      if (Has_Worked == true) {
         System.out.println("Get out. While you still can...(You've already worked)");
         return;
      }
      if (CURRENT_PLAYER.getRoom().getName().equals("Trailers") || CURRENT_PLAYER.getRoom().getName().equals("Casting Office")) {
         System.out.println("No roles here. Move then try again");
         return;
      }
      //Check if already working on a role.
      if (CURRENT_PLAYER.getRole() != null) {
         System.out.println("You are already working a role.");
         return;
      } 
      
      System.out.println("Current player room: " + CURRENT_PLAYER.getRoom().getName());
      System.out.println("Choose a role to take: ");
      CURRENT_PLAYER.getRoom().printRoles();
      Scanner input = new Scanner(System.in);
      String role_input = input.nextLine();
      //Check if someone else is working on the role.
		while (!(CURRENT_PLAYER.getRoom().getRoles().keySet().contains(role_input))){
	      System.out.print("Choose a role to take: ");
         CURRENT_PLAYER.getRoom().printRoles();
         role_input = input.nextLine();
		}

      if(CURRENT_PLAYER.getRole() != null &&(CURRENT_PLAYER.getRole().isTaken() == true)) {
         System.out.println("Someone is already on this role.");
         return;
      }
      //Set role.
      //System.out.println(CURRENT_PLAYER.getRoom().getRoles().keySet());
      //System.out.println("Role??? " + CURRENT_PLAYER.getRoom().getRoles().keySet().contains(role_input));
		//System.out.println("role_input:"+role_input);
      if (CURRENT_PLAYER.setRole(CURRENT_PLAYER.getRoom().getRoles().get(role_input))) {  
         System.out.println("Congrats! You're an actor now! Role accepted: " + CURRENT_PLAYER.getRole().getName());
         return;
      } 
      return;   
   }
   
   private void upgrade() {
      boolean valid = false;
      System.out.println("Enter how you'd like to pay for your upgrade, with money or credits. Type '$' for money and 'cr' for credits.");
      Scanner user_input = new Scanner (System.in);
      //Check if in the casting office.
		if(CURRENT_PLAYER.getRoom().getName().equals("Casting Office")){
			String currency_input = user_input.next();
			//Check second input and upgade if eligible.
			switch (currency_input){
	   		case "$":
               System.out.println("Enter the rank you'd like to upgrade to. Valid entries are a number between 2 and 6");
			   	int dollar_input = user_input.nextInt();
					valid = CURRENT_PLAYER.rankMoney(dollar_input);
               return;
				case "cr":
               System.out.println("Enter the rank you'd like to upgrade to. Valid entries are a number between 2 and 6");
					int credit_input = user_input.nextInt();
					valid = CURRENT_PLAYER.rankCredits(credit_input);
					return;
				default:
					System.out.println("Invalid input.");
					return;
			}
		} else {
			System.out.println("You are not in the Casting Office.");
			return;
		}
   }
   
	private int calculateScore(Players player){
		return player.getMoney() + player.getCredits() +(player.getRank() * 5);
	}
	
	private void setTurn(int turn){
		CURRENT_PLAYER = TURN_ORDER[turn%(TURN_ORDER.length)];
	}
	
	public Players getTurn(){
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

	private int findIndexPlayer(Players[] A, Players P){
		int n = 0;
		for (int i=0; i < NUMBER_OF_PLAYERS; i++){
			if (A[i].getName().equals(P.getName())){
			   n = i;
		   }
		}
		return n;
	}
	//Create scene objects.
    private void createScenes(){
       ArrayList<Scene> deck = new ArrayList<Scene>();
		 try(Scanner input = new Scanner(new File("Group9_Deadwood/scenes.txt"))){
            while(input.hasNextLine()){
					String temp = input.nextLine();
            	deck.add( new Scene(temp));
            
				}
				Collections.shuffle(deck);
				int i=0;
				for (Scene S: deck){
					SCENES[i]=S;
					i++;
				}
        } catch (FileNotFoundException ex) { System.err.println("Error: File not found."); System.exit(0);}
    }

}
