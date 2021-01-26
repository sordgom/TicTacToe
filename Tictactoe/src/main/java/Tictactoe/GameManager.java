package Tictactoe;
/**This class is responsible of managing all of the game states
 * @author Aymane Igmiden
 * @version beta
 * @since 2020-01-14
 */
import java.util.List;
import java.util.Scanner;

import java.util.Arrays;


public class GameManager {
	//playerType list that hold 3 objects : human player,random bot,smart bot 
	private final List<Player> playerTypes=players();
	private final List<Player> playerTypes2=players2(); //This is required since we need to escape the clash of calling the same object
    private Game game;
    private Input input;
    private Print print;
    private boolean gameRunning = true;

    GameManager(Input input, Print print) {
        this.input = input;
        this.print = print;
    }
    
    //Method that runs the game depending on the its state.
    void run() {
        while (gameRunning) {
        	startGame();
        	if (game != null) {
                while (gameInProgress()) {
                    makeMove();
                }
                endOfGame();
            }
        }
    }
    //Starts a game by invoking welcome message , creates a board and set up the state
    public void startGame() {
        print.clearScreen();
        print.welcome();
        Board board = createBoard();
        createGame(board);
    }
    
    //Create new game state
    private void createGame(Board board) {
    	String name,symbol;
    	
    	//1st Player setup 
        print.player1Type();
        print.playerOption();
        int firstPlayer=getSelection(playerTypes,0);
        Player player1=playerTypes.get(firstPlayer-1);
        player1.setSymbol("X"); //by default
        if(firstPlayer==1) {
        	print.player1Name();
        	name=input.getString();
        	print.player1Symbol();
        	symbol=input.getString();
        	while(!(symbol.equals("X") || symbol.equals("x") || symbol.equals("O") ||symbol.equals("o"))) {
        		print.invalidSymbolSelection();
        		symbol=input.getString();
        	}
        	player1=new Human(input,symbol,name);
        	
        }
        
        //2nd player setup
        print.player2Type();
        print.playerOption();
        int secondPlayer=getSelection(playerTypes2,0);
        Player player2=playerTypes2.get(secondPlayer-1);
        player2.setSymbol("O");   //by default
        if(secondPlayer==1) {
        	print.player2Name();
        	name=input.getString();
        	print.player1Symbol();
        	symbol=input.getString();
        	while(!(symbol.equals("X") || symbol.equals("x") || symbol.equals("O") ||symbol.equals("o"))) {
        		print.invalidSymbolSelection();
        		symbol=input.getString();
        	}
        	player2=new Human(input,symbol,name);
        }
        
        
        //Automatically select the 2nd player"s symbol
        if(player1.getSymbol().equals("X")) {
        	player2.setSymbol("O");
        }
        if(player1.getSymbol().equals("O")) {
        	player2.setSymbol("X");
        }
        
        //Randomly choose who'll play first
        int rand=(int)(Math.random()*9);
        if(rand%2==0) {
        	print.player1Turn();
        	game = startNewGame(player1,player2, board);
        }else {
        	print.player2Turn();
        	game = startNewGame(player2,player1, board);

        }
        
        
        
    }
    
    //Create a board based on size chosen
    private Board createBoard() {
        print.boardSize();
        print.options(boardTypes());
        return selectBoardSize(getSelection(boardTypes()));
    }
    /**
     * Methods that gets the player choice
     * @param players
     * @return player index
     */
    private int getSelection(List<Player> players,int a) {
        return input.validateSelection(input.validSelections(players));
    }
    /**
     * Method that gets the menu options
     * @param options
     * @return The option index
     */
    private int getSelection(List<? extends Menu> options) {
        return input.validateSelection(input.validSelections(options));
    }
    /**
     * @param player1
     * @param player2
     * @param board
     * @return new Game state
     */
    private Game startNewGame(Player player1,Player player2,  Board board) {
    	Game newGame = new Game(board,player1,player2);
        return newGame;
    }
    /**
     * Takes a choice number and returns the board
     * @param choice
     * @return Board 
     */
    private Board selectBoardSize(int choice) {
        Boards board = boardTypes().get(choice - 1);
        return board.execute();
    }
    //Is the game still running?
    private boolean gameInProgress() {
        return !game.isGameOver();
    }
    //print the board , and run the move 
    private void makeMove() {
        print.clearScreen();
        print.selectPosition(game);
        print.board(game.board);
        game.takeTurn();
    }
  //if the playAgain choice is not chosen , exit
    private void endOfGame() {
        print.clearScreen();
        print.outcome(game);
        print.board(game.board);
        playAgain();
    }
    //if the playAgain choice is chosen , play again
    private void playAgain() {
        print.playAgain();
        print.options(playCommands());
        playAgainCommand(getSelection(playCommands()));
    }
    //PlayAgain option or exit option
    private void playAgainCommand(int selection) {
        Options playOrQuit = playCommands().get(selection - 1);
        playOrQuit.execute();
    }
    /**
     * Quit the game by changing the boolean variable controlling the game flow
     */
    public void quitGame() {
    	gameRunning = false;
        print.exiting();
    }
    
    //Play commands (playAgain,exit)
    private List<Options> playCommands() {
        return Arrays.asList(new PlayAgain(), new Quit(this));
    }
    //Type of boards 
    private List<Boards> boardTypes() {
        return Arrays.asList(new NormalBoard(), new BigBoard());
    }
    //list of player for Player 1
    private static List<Player> players() {
        return Arrays.asList(
                new Human(), new RandomBot("Mr Random"), new SmartBot("Alan turner"));
    }
  //list of player for Player 2
    private static List<Player> players2() {
        return Arrays.asList(
                new Human(), new RandomBot("Eccentric user"), new SmartBot("Heisenberg"));
    }
   
    
    
    
}
