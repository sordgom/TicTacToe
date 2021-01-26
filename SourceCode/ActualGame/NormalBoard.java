package ActualGame;
/**
 * 3*3 Board
 * @author An yanshan
 *
 */
public class NormalBoard implements Boards{
    @Override
    public Board execute() {
        return new Board(3);
    }

    @Override
    public String title() {
        return "Normal (3x3)";
    }
}
