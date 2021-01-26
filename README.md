## Java Tic Tac Toe 

TicTacToe game built on java . Our game is capable of running on any type of board (for now , we only have
3*3 and 4*4) . Also We've build an unbeatable player using the minimax algorithm .

## Player types
1. Human
2. Random bot
3. Smart bot


#### Prerequisites 
1. Install [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. set the JAVA_HOME environment variable in your terminal 
Windows:
	https://daisy.github.io/pipeline/Get-Help/Troubleshooting/Common-Errors-Windows/
Linux:
	https://stackoverflow.com/questions/24641536/how-to-set-java-home-in-linux-for-all-users
	
#### Running instructions
1. Clone the repository by clicking on the green "Clone or Download" button
2. Select Download Zip
3. Double click the zip file to unzip it
If you're on any UNIX system:
	4. In terminal, CD into the repository
	5. Build the app by running `$ ./gradlew build`
	6. Run the tests by running `$ ./gradlew cleanTest test`
	7. Play the game by running `$ ./gradlew --console plain run`
If you're on a windows system:
	4. In CMD, CD into the repository or open a CMD inside the directory
	5. Build the app by running `$ gradlew.bat build`
	6. Run the tests by running `$ gradlew.bat cleanTest test`
	7. Play the game by running `$ gradlew.bat --console plain run`

#### The Rules

The rules of tic-tac-toe are as follows:

* There are two players in the game (X and O)
* Players take turns until the game is over
* A player can claim a field if it is not already taken
* A turn ends when a player claims a field
* A player wins if they claim all the fields in a row, column or diagonal
* A game is over if a player wins
* A game is over when all fields are taken