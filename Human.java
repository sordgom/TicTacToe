
public class Human extends Game implements Player  {
	

	private String symbol,name,input;            //name         // input became string
	
	public Human() {
		
	}
	
	public Human(String symbol) {
		if(symbol.length()>1 || symbol.isBlank() || (symbol.charAt(0)!='O' && symbol.charAt(0)!='X'))       //throws exception for wrong input  NEED TO CATCH
			throw new IllegalArgumentException("Please either input 'X' or 'O' ");
		this.symbol = symbol;
		
	}
	
	public void setName(String name) {
		if(symbol.isBlank())                                                                            //throws exception for wrong input  NEED TO CATCH
			throw new IllegalArgumentException("Please don't leave the name blank");
		this.name=name;
		
	}
	
	public String getName() {
	
		return name;
		
	}
	
	public void setSymbol(String symbol) {
		if(symbol.length()>1 || symbol.isBlank() || (symbol.charAt(0)!='O' && symbol.charAt(0)!='X'))       //throws exception for wrong input  NEED TO CATCH
			throw new IllegalArgumentException("Please either input 'X' or 'O' ");
		this.symbol=symbol;
		
	}
	
	public String getSymbol() {
		
		return symbol;		
	}
	
	public void setInput(int input) {                                       //gets the input slot number and adds it to the input string for checking if it is a winning combination of numbers or not from the winning array
		this.input = this.input+Integer.toString(input);
		
	}
	
	public String getInput() {
		return input;
		
	}
	
	

}
