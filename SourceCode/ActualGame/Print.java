package ActualGame;
/**This class is responsible of all outputs .
 * @author Aymane Igmiden
 * @version beta
 * @since 2020-01-14
 */
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print {
	
	private final PrintStream output;
	
	Print(PrintStream output){
		this.output=output;
	}
	
	//Messages displayed to  users
	void welcome() {
		output.println("\nWelcome to the best version of TicTacToe there is!\nTake note that player1 has the right to choose the symbol first!\nWhoever goes first is chosen by faith.\nViel Glück!\n");
	}
	void player1Type() {
        output.println("Select Player1 Type:");
    }
	void player1Name() {
		output.println("Enter your name:");
	}
	void player1Symbol() {
		output.println("Choose your symbol: 'X' OR 'O' ");
	}
	void player1Turn() {
		output.println("Player1 goes first");
	}
	void player2Type() {
        output.println("Select Player2 Type:");
    }
	void player2Name() {
		output.println("Enter your name:");
	}
	void player2Symbol() {
		output.println("Choose your symbol: 'X' OR 'O' ");
	}
	void player2Turn() {
		output.println("Player2 goes first");
	}
	void boardSize(){
        output.println("Select Board Size:");
    }
	public void whoPlaysFirst() {
        output.println("Who should go first?");
    }
	void invalidNumberSelection() {
        output.println("Select a Valid Number please!!");
    }
	void invalidSymbolSelection() {
        output.println("Select a Valid symbol please!!");
    }
	void exiting() {
        output.println("Exiting");
    }
    
	/**
	 * Prints out the instructions list
	 * @param options	List of options (quit,playagain...)
	 */
	public void options(List<? extends Menu> options) {
		StringBuilder instructions = new StringBuilder();
		for(int i=0;i<options.size();i++) {
			instructions
			.append(i+1)
			.append(")")
			.append(options.get(i).title())
			.append(System.lineSeparator());
		}
		output.println(instructions.toString().trim());
	}
	//returns player types list
	List<Player> playerTypes() {
        return Arrays.asList(new Human(), new RandomBot(),new SmartBot());
    }
	/**
	 * Prints out the player types list
	 */
	public void playerOption() {
		StringBuilder instructions = new StringBuilder();
		for(int i=0;i<playerTypes().size();i++) {
			instructions
			.append(i+1)
			.append(")")
			.append(( playerTypes().get(i)).title())
			.append(System.lineSeparator());
		}
		output.println(instructions.toString().trim());
	}
	
	void selectPosition(Game game) {
		output.println("\n"+game.currentPlayer.getSymbol()+" select a position");
	}
	
	// L51 ==> 91 is definitely mine
	//the point of these methods is to draw the board in the command line
	void board(Board board) {
		StringBuilder printedBoard = new StringBuilder();
        ArrayList<ArrayList<String>> rows = board.getRows();
        for (ArrayList<String> row : rows) {
            printedBoard.append(formatRow(row)).append(getLine(board));
        }
        printedBoard.append(System.lineSeparator());
        output.println(printedBoard.substring(0, printedBoard.length() - getLine(board).length()));
	}
    
	private String formatRow(List<String> row) {
        String separator = " | ";
        String offset = " ";
        StringBuilder formattedRow = new StringBuilder(offset);
        for (String space : row) {
            String paddedSpace = padSpace(offset, space);
            formattedRow.append(paddedSpace).append(separator);
        }
        return String.valueOf(formattedRow.substring(0, formattedRow.length() - separator.length()));
    }
	private String padSpace(String offset, String space) {
        String paddedSpace;
        if (space.length() == 1){
            paddedSpace = offset + space;
        } else {
            paddedSpace = space;
        }
        return paddedSpace;
    }

    private String getLine(Board board) {
        final String line;
        int normalBoard = 3;
        if (board.getRows().size() == normalBoard) {
            line = System.lineSeparator() + "--------------" + System.lineSeparator();
        } else {
            line = System.lineSeparator() + "-------------------" + System.lineSeparator();
        }
        return line;
    }
	    
    //prints out the result
    void outcome(Game game) {
    	if(game.isGameTied()){
    		output.println("It's a tie");
    	}else if(game.getWinner()!=null) {
    		output.println("The winner is "+ game.getWinner().getSymbol());
    	}else {
    		output.println("This can't be happening!");
    	}
    }
    
    void playAgain() {
    	output.println("Do you want to try again?");
    }
	//how to clear your screen https://www.javatpoint.com/how-to-clear-screen-in-java
    public void clearScreen() {
    	final String clear_screen="\033[H\033[2J";
    	output.print(clear_screen);
    	output.flush();
    }
}

