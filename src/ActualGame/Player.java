package ActualGame;

abstract class  Player implements Menu {
	
	abstract String getTitle();
	abstract String getName() ;
	abstract String getSymbol();
	abstract void 	setSymbol(String symbol);
	abstract int getMove(Game game);
}
