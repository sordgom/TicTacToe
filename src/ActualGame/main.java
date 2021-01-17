package ActualGame;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * Main class that runs the game
 * @author root
 *
 */
public class main {

    private static Input input;
    private static Print print;
    private static Random random;

    public static void main(String[] args) {
        print = new Print(new PrintStream(System.out));
        input = new Input(new Scanner(System.in), print);
        random = new Random();
        GameManager manager = new GameManager(input, print, players());
        manager.run();
    }

    private static List<Player> players() {
        return Arrays.asList(
                new Human(), new RandomBot(), new SmartBot());
    }
}
