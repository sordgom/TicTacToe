package ActualGame;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Aymane Igmiden
 *
 */
public class Board  {
	
	private final int rows;
	List<String> positions;
	private int totalPositions;
	
	public Board(int rows) {
		this.rows=rows;
		this.totalPositions=rows*rows;
		this.positions=new ArrayList<>(totalPositions);
		assignValuesToPositions();
	}
	void placeSymbol(int spot,String symbol) {
		if(isMovePossible(spot)) {
			getPositions().set(spot,symbol);
		}else {
			throw new IllegalMoveException();
		}
	}
	public List<Integer> getAvailablePositions() {
        List<Integer> availablePositions = new ArrayList<>();
        for (int i = 0; i < getPositions().size() ; i++) {
            if (isPositionAvailable(i)) {
                availablePositions.add(i);
            }
        }
        return availablePositions;
    }
	public void resetPositions(int position) {
		positions.set(position - 1  , String.valueOf(position));
	}
	private void assignValuesToPositions() {
		for(int i=0;i<totalPositions;i++) {
			getPositions().add(String.valueOf(i));
		}
	}
	List<String> getPositions(){
		return positions;
	}
	
	private boolean isPositionAvailable(int position) {
        return getPositions().get(position).equals(String.valueOf(position));
    }

    private boolean isPositionOnBoard(int position) {
        return (position >= 0 && position <= totalPositions);
    }

    private boolean isMovePossible(int position) {
        return (isPositionOnBoard(position) && isPositionAvailable(position));
    }
	
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
