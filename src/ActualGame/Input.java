package ActualGame;
/**This class is responsible of handling user input 
 * @author Aymane Igmiden
 * @version beta
 * @since 2020-01-14
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {

    private final Scanner input;
    private final Print print;

    Input(Scanner input, Print print) {
        this.input = input;
        this.print = print;
    }

    //method that reads the choice integer
    int getInteger() {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            print.invalidNumberSelection(); //error message
            input.next();
            return getInteger();
        }
    }
    //recursive method that reads a string
    String getString() {
    	try {
    		return input.next();
    	} catch(Exception e) {
    		print.invalidNumberSelection(); //error message
            input.next();
            return getString();
    	}
    }

    //checks if the integer is valid
    public int validateSelection(List<Integer> options) {
        int selection = getInteger();
        if (options.contains(selection)) {
            return selection;
        } else {
            print.invalidNumberSelection();
            return validateSelection(options);
        }
    }

    public List<Integer> validSelections(List<? extends Menu> options) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < options.size() + 1 ; i++) {
            list.add(i);
        }
        return list;
    }
}
