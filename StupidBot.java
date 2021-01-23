import java.util.Random;

public class StupidBot extends Game implements Player {
	
private String symbol,name,input;            //name         // input became string
	
	public StupidBot() {
		
	}
	
	public StupidBot(Human human) {                                                      //constructor takes a human to check for its symbol and then assigns the other symbol
		if(human.getSymbol()=="O")
			this.symbol="X";
		else if(human.getSymbol()=="X")
			this.symbol="O";
		else throw new IllegalArgumentException("Problem in StupidBot constructor");               //another exception to catch
		
	}
	
	public void setName(String name) {
		if(symbol.isBlank())                                                                            //throws exception for wrong input  NEED TO CATCH
			throw new IllegalArgumentException("Please don't leave the name blank");
		this.name=name;
		
	}
	
	public String getName() {
	
		return name;
		
	}
	
	
	
	public String getSymbol() {
		
		return symbol;		
	}
	
	public void setInput(int input) {
		this.input = this.input+Integer.toString(input);                        //gets the input slot number and adds it to the input string for checking if it is a winning combination of numbers or not from the winning array
		
	}
	
	public String getInput() {
		return input;
		
	}
	
	public int selectRandomEmptySlot() {
		int input =0;
		do {
		Random rn = new Random();
		int answer = rn.nextInt(9) + 1;
		for(int i=0;i<list.size();i++) {      //checks the available slots
			if(answer==list.get(i))
				input = answer;
		}
		
		}while(input==0);
		return input;     //probably will make it press the corresponding button here instead of returning the int but i still dont know how the gui syntax will be
		
		
	}

}
