package ActualGame;
/**This class is responsible of managing all of the game states
 * Each method uses methods implemented later on!
 * @author Aymane Igmiden
 * @version beta
 * @since 2020-01-14
 */
import java.util.List;
import java.util.Scanner;

import java.util.Arrays;


public class GameManager {
	private final List<Player> playerTypes;
    private Game game;
    private Input input;
    private Print print;
    private boolean gameRunning = true;

    GameManager(Input input, Print print,List<Player> playerTypes) {
        this.input = input;
        this.print = print;
        this.playerTypes=playerTypes;
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
    private void startGame() {
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
        if(firstPlayer==1) {
        	print.player1Name();
        	name=input.getString();
        	print.player1Symbol();
        	symbol=input.getString();
        	
        	player1=new Human(input,symbol,name);
        	
        }
        
        //2nd player setup
        print.player2Type();
        print.playerOption();
        int secondPlayer=getSelection(playerTypes,0);
        Player player2=playerTypes.get(secondPlayer-1);
        if(secondPlayer==1) {
        	print.player2Name();
        	name=input.getString();
        	print.player1Symbol();
        	symbol=input.getString();
        	player2=new Human(input,symbol,name);
        }
        if(player1.getSymbol().equals("X")) {
        	player2.setSymbol("O");
        }
        if(player1.getSymbol().equals("O")) {
        	player2.setSymbol("X");
        }
        game = startNewGame(player1,player2, board);
    }
    //Create a board based on size chosen
    private Board createBoard() {
        print.boardSize();
        print.options(boardTypes());
        return selectBoardSize(getSelection(boardTypes()));
    }
    /**
     * Methods that validates the players type
     * @param players
     * @return player index
     */
    private int getSelection(List<Player> players,int a) {
        return input.validateSelection(input.validSelections(players));
    }
    /**
     * Method that validates the options
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
    private Game startNewGame(Player player1,Player player2, Board board) {
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
    //Method that makes a amove
    private void makeMove() {
        print.clearScreen();
        print.selectPosition(game);
        print.board(game.board);
        game.takeTurn();
    }
    //The end game
    private void endOfGame() {
        print.clearScreen();
        print.outcome(game);
        print.board(game.board);
        playAgain();
    }
    //Based on your choice , play or not
    private void playAgain() {
        print.playAgain();
        print.options(playCommands());
        playAgainCommand(getSelection(playCommands()));
    }
    
    public void quitApp() {
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
    //Type of players
    private List<Player> playerTypes() {
        return Arrays.asList(new Human(), new RandomBot(),new SmartBot());
    }
    //PlayAgain option or exit option
    private void playAgainCommand(int selection) {
        Options playOrQuit = playCommands().get(selection - 1);
        playOrQuit.execute();
    }
    //Exit state
    
}
