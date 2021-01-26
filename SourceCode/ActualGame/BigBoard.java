package ActualGame;
/**
 * 4*4 Board 
 * @author An Yanshan
 *
 */

public class BigBoard implements Boards {
    @Override
    public Board execute() {
        return new Board(4);
    }

    @Override
    public String title() {
        return "Large (4x4)";
    }
}

