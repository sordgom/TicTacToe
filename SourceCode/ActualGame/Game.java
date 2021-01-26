package ActualGame;
import java.util.ArrayList;

import java.util.ArrayList;

/**
 * Game logic
 * @author An yanshan
 *
 */
public class Game {

    public final Board board; 
    final Player player1;
    final Player player2;
    Player currentPlayer;
    private Player winner; 

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }
    //Make a move and switch turn
    void takeTurn() {
        board.placeSymbol(currentPlayer.getMove(this), currentPlayer.getSymbol());
        changeCurrentPlayer();
    }
    //Switch turn
    public void changeCurrentPlayer() {
        currentPlayer =(currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }
    //Determines if the game is over
    public boolean isGameOver() {
        return isGameWonBy(player1) || isGameWonBy(player2) || isGameTied();
    }
    //Checks if any symbol makes it into the winning combinations
    private boolean isGameWonBy(Player player) {
        for (ArrayList<String> line : winningCombinations()) {
            if (line.stream().allMatch(space -> space.equals(player.getSymbol()))) {
                winner = player;
                return true;
            }
        }
        return false;
    }
    
    //Determines if the game is tied
    public boolean isGameTied() {
        return board.getAvailablePositions().size() == 0 && !isGameWonBy(player1) && !isGameWonBy(player2);
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Player getWinner() {
        return winner;
    }
    
    //list of winning combinations
    private ArrayList<ArrayList<String>> winningCombinations() {
        ArrayList<ArrayList<String>> winningCombinations = new ArrayList<>();
        winningCombinations.addAll(board.getRows());
        winningCombinations.addAll(board.getColumns());
        winningCombinations.add(board.getLeftDiagonal());
        winningCombinations.add(board.getRightDiagonal());
        return winningCombinations;
    }
}
