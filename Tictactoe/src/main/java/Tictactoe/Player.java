package Tictactoe;
/**
 * Abstract class instead of interface to spice things up 
 * 
 * @author An Yanshan 
 *
 */
abstract class  Player implements Menu {
	String title="Player menu";
	abstract String getName() ;
	abstract String getSymbol();
	abstract void 	setSymbol(String symbol);
	abstract int 	getMove(Game game);
}
