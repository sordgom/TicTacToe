package ActualGame;

import java.util.List;
import java.util.Random;
/**
 * Random bot class that represents a stupid bot
 * @author Omran Alhasadi
 *
 */
public class RandomBot extends  Player {
	//This bot requires a  symbol and Random class to generate his choices
	private final String name="Random Bot";
    private final Random random;
    private String symbol;

    public RandomBot() {
		this.random = new Random();
		this.symbol = "";
    }
    public RandomBot(Random random,String symbol) {
        this.symbol=symbol;
        this.random = random;
    }

    public void setSymbol(String symbol) {
    	this.symbol=symbol;
    }
    @Override
    public String getSymbol() {
        return symbol;
    }
   
    @Override
    /**
     * Make a move 
     */
    public int getMove(Game game) {
        return selectRandomAvailableSpace(game);
    }
    
    /**
     * List the game's available spots , and randomly choose one of those spots
     * @param game
     * @return an integer that respresents a spot
     */
    private int selectRandomAvailableSpace(Game game) {
        List<Integer> list = game.board.getAvailablePositions();
        return list.get(random.nextInt(list.size()));
    }

    @Override
	public String getName() {
		return name;
	}

	@Override
	public String title() {
		return getName();
	}
	
}
