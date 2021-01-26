package Tictactoe;
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

    public static void main(String[] args) {
        print = new Print(new PrintStream(System.out));
        input = new Input(new Scanner(System.in), print);
        new GameManager(input, print).run();
    }

    
}
