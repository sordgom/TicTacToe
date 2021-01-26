package ActualGame;
/**
 * Human class that represents a human player
 * @author Omran Alhasadi
 *
 */
public class Human extends Player {
	//A humane player requires a name, a symbol and something that detects his input (Human-ùachine interaction)
	private final String name;
    private String symbol;
    private final Input input;
    

    public Human() {
    	this.name="";
		this.symbol = "";
		this.input = null;
	}
    public Human(Input input, String symbol,String name) {
        this.symbol=symbol;
        this.input = input;
        this.name=name;
    }
    
    public void setSymbol(String symbol) {
    	this.symbol=symbol;
    }

    @Override
    /**
     * Based on the input , get the move to play
     */
    public int getMove(Game game) {
        return input.validateSelection(game.board.getAvailablePositions());
    }
    
    @Override
	public String getName() {
		return name;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}
	
	@Override
	public String title() {
		
		return "Human player ";
	}

	
}

