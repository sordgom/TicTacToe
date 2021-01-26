package Tictactoe;
/**
 * Quit State
 * @author Aymane Igmiden
 *
 */
public class Quit implements Options {

    private final GameManager manager;

    public Quit(GameManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.quitGame();
    }

    @Override
    public String title() {
        return "No";
    }
}
