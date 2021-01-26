package Tictactoe;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is responsible for board surrounding logic
 * @author Aymane Igmiden
 *
 */
public class Board  {
	
	private final int rows; //Dimension
	List<String> positions; //List of numbers that represents spots
	private int totalPositions; //total number of spots 
	
	public Board(int rows) {
		this.rows=rows;
		this.totalPositions=rows*rows;
		this.positions=new ArrayList<>(totalPositions);
		assignValuesToPositions();
	}
	/**
	 * Places X or O in a spot if possible
	 * @param spot	
	 * @param symbol
	 */
	void placeSymbol(int spot,String symbol) {
		if(isMovePossible(spot)) {
			getPositions().set(spot-1,symbol);
		}else {
			throw new IllegalMoveException();
		}
	}
	
	/**
	 * Based on the board, return list of available spots
	 * @return list of empty spots
	 */
	public List<Integer> getAvailablePositions() {
        List<Integer> availablePositions = new ArrayList<>();
        for (int i = 1; i <= getPositions().size() ; i++) {
            if (isPositionAvailable(i)) {
                availablePositions.add(i);
            }
        }
        return availablePositions;
    }
	/**Rewind 
	 * Undo the move 
	 * @param position
	 */
	public void resetPositions(int position) {
		positions.set(position - 1  , String.valueOf(position));
	}
	/**
	 * Assign to each spot a number from 1 to the last number
	 */
	private void assignValuesToPositions() {
		for(int i=1;i<=totalPositions;i++) {
			getPositions().add(String.valueOf(i));
		}
	}
	/**
	 * @return  List of positions
	 */
	List<String> getPositions(){
		return positions;
	}
	/**
	 * Checks if the move is possible
	 * Which means the number is empty and is in range 
	 * @param position
	 * @return
	 */
	private boolean isMovePossible(int position) {
        return (isPositionOnBoard(position) && isPositionAvailable(position));
    }
	/**
	 * Checks if the position is empty or has a symbol in it
	 * @param position
	 * @return
	 */
	private boolean isPositionAvailable(int position) {
        return getPositions().get(position-1).equals(String.valueOf(position));
    }
	/**
	 * Checks if the number is in range of the board
	 * @param position
	 * @return
	 */
    private boolean isPositionOnBoard(int position) {
        return (position >= 0 && position <= totalPositions);
    }

    
	
    //Generate geometrical spots for any board(rows,columns)...
	public ArrayList<ArrayList<String>> getRows() {
	    ArrayList<ArrayList<String>> list = new ArrayList<>(rows);
	    for (int i = 0; i < rows; i++) {
	        list.add(new ArrayList<>(getPositions().subList(i * rows, (rows * i) + rows)));
	    }
	    return list;
	}
	public ArrayList<ArrayList<String>> getColumns() {
	    ArrayList<ArrayList<String>> columns = new ArrayList<>(rows);
	    for (int i = 0; i < rows; i++) {
	        ArrayList<String> column = new ArrayList<>(rows);
	        for (int j = 0; j < rows; j++) {
	            column.add(getRows().get(j).get(i));
	        }
	        columns.add(column);
	    }
	    return columns;
	}
	public ArrayList<String> getLeftDiagonal() {
	    ArrayList<String> leftDiagonal = new ArrayList<>(rows);
	    for (int i = 0; i < rows; i++) {
	        leftDiagonal.add(getRows().get(i).get(i));
	    }
	    return leftDiagonal;
	}
	public ArrayList<String> getRightDiagonal() {
	    ArrayList<String> rightDiagonal = new ArrayList<>(rows);
	    for (int i = 0; i < rows; i++) {
	        rightDiagonal.add(getRows().get(i).get(rows - (i + 1)));
	    }
	    return rightDiagonal;
	}
	
}
