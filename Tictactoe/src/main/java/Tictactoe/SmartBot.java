package Tictactoe;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * A class that represents an unbeatable bot
 * @author Igmiden Aymane
 *
 */
public class SmartBot extends Player {
	private  String symbol;
	private final String name="Smart Bot";
	
	public SmartBot() {}
	public SmartBot(String symbol) {
	   this.symbol=symbol;
	}
	/**
	 * returns the spot of the best move possible
	 */
	public int getMove(Game game) {
		Map<Integer, Integer> bestScore = new HashMap<>();
	    return calculateBestMove(game, 0, bestScore);
	}
	/**
	 * A recursive method that calculates the best move 
	 * @param game 		The current game 
	 * @param depth		How deep we want to go 
	 * @param bestScore	Map that stores the Q history
	 * @return	Best Move number possible
	 */
	private int calculateBestMove(Game game, int depth, Map<Integer, Integer> bestScore) {
		int tiedGame = 0;
		int wonGame = -1;
	    if (game.isGameTied()) {
	      return tiedGame;
	    } else if (game.isGameOver()){
	      return wonGame;
	    } else {
	      checkPossibilities(game, depth, bestScore);
	    if (depth == 0) {
	    	return getBestMove(bestScore);
	    } else {
	    	return getTopScore(bestScore);
	    }
	  }
	}
	/**
	 * Check based on available spots the best move and store it in a map
	 * @param game 		The current game 
	 * @param depth		How deep we want to go 
	 * @param bestScore	Map that stores the Q history
	 */
	private void checkPossibilities(Game game, int depth, Map<Integer, Integer> bestScore) {
		
			for (int position : game.board.getAvailablePositions()) {
				if(!game.isGameOver()) {
				
				game.board.placeSymbol(position, game.getCurrentPlayer().getSymbol());
				
				
				game.changeCurrentPlayer();
			    
			    
			    bestScore.put(position, (-1 * calculateBestMove(game, depth + 1, new HashMap<>())));
			    
			    
			    game.board.resetPositions(position);
			    
			    
			    game.changeCurrentPlayer();
			    
			}
		}
	}
	/**
	 * compares the keys of the bestScore map which represents the board spots
	 * and returns the best one 
	 * @param bestScore	Map that stores the Q history
	 * @return max of bestScore keys
	 */
	private int getBestMove(Map<Integer, Integer> bestScore) {
		return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
	}
	/**
	 * compares the values of the bestScore map and returns the max that represents a win
	 * @param bestScore	Map that stores the Q history
	 * @return
	 */
	private int getTopScore(Map<Integer, Integer> bestScore) {
		return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
	}
	
	@Override
	public String title() {
		return getName();
	}

	String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol=symbol;
	}
	
		
	String getName() {
		return name;
	}
		
}
		