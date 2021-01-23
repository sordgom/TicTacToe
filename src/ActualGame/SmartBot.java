package ActualGame;

import java.util.HashMap;
import java.util.Map;

public class SmartBot extends Player {
	Print print;
	private  String symbol;
	private final String name="Smart Bot";
	
	public SmartBot() {}
	public SmartBot(String symbol) {
	   this.symbol=symbol;
	}
	  
	public int getMove(Game game) {
		Map<Integer, Integer> bestScore = new HashMap<>();
	    return calculateBestMove(game, 0, bestScore);
	}
	
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
	
	private void checkPossibilities(Game game, int depth, Map<Integer, Integer> bestScore) {
			for (int position : game.board.getAvailablePositions()) {
				print.board(board);
				game.board.placeSymbol(position, game.getCurrentPlayer().getSymbol());
			    game.changeCurrentPlayer();
			    bestScore.put(position, (-1 * calculateBestMove(game, depth + 1, new HashMap<>())));
			    game.board.resetPositions(position);
			    game.changeCurrentPlayer();
				
			}
	}
	
	private int getBestMove(Map<Integer, Integer> bestScore) {
		return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
	}
		
	private int getTopScore(Map<Integer, Integer> bestScore) {
		return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
	}
	
	  @Override
	  public String title() {
	    return null;
	  }

		
		String getTitle() {
			return "Smart Bot";
		}
		
		String getName() {
			return name;
		}
		
		String getSymbol() {
			return symbol;
		}
		
		public void setSymbol(String symbol) {
			this.symbol=symbol;
		}
}
		