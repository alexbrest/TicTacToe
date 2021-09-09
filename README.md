# TicTacToe Kata

# Requirements
The project is setup to be build with maven.
Alternatively there is a .jar file included that can be run with simple Java.

# Rules
The rules are described below :

X always goes first.
Players cannot play on a played position.
Players alternate placing X’s and O’s on the board until either:
One player has three in a row, horizontally, vertically or diagonally
All nine squares are filled.
If a player is able to draw three X’s or three O’s in a row, that player wins.
If all nine squares are filled and neither player has three in a row, the game is a draw.


# Running the program
Follow those step to build with maven, run the program and play the game

1. Go into the into the TicTacToe directory.
2. Run `mvnw spring-boot:run` comand
3. Open a browser nad navigate to http://localhost:8080
4. Click on "to the game" link.
5. Play the game.

# Running the program from a jar (requires Java 11)
1. Go into the TicTacToePlay
2. Run `java -jar tictactoe.jar`
3. Open a browser nad navigate to http://localhost:8080
4. Click on "to the game" link.
5. Play the game.