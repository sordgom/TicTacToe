package ActualGame;

public class Human extends Player {
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
    public String getTitle() {
        return "Human";
    }
	@Override
	public String title() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

