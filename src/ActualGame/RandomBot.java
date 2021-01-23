package ActualGame;

import java.util.List;
import java.util.Random;

public class RandomBot extends  Player {
	
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
    public String getTitle() {
        return "Random Bot";
    }

    @Override
    public int getMove(Game game) {
        return selectRandomAvailableSpace(game);
    }
    
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
