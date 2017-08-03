# Counting_Game
NOTE:This is a 2 player game and one of them is always the system/computer.

Inputs required to start the game:
  1. Endpoint/Finishpoint to stop the game and decide the  winner.
  2. Delata/Max number that can be added to proceed to next step.
  3. Start the game(yes/no).

Game Rules:
  1. The one who starts the game chooses a number between 1 and delta(assume that it is stored in 'a').
  2. The next player has to choose a number between (a+1) and (a+delta) which is also stored in 'a'.
  3. Repeat the above step until one of the player's output ie. 'a' is in the range of (a+1<= endpoint >=a+delta).
  4. The player whose answer was in the range of (a+1<= endpoint >=a+delta) losses the game.
