# Counting_Game
NOTE:This is a 2 player game and one of them is always the system/computer.

Inputs required to start the game:
  1. Endpoint/Finishpoint to stop the game and decide the  winner.
  2. Delata/Max number that can be added to proceed to next step.
  3. Start the game(yes/no).

Game Rules:
  0. Choose two numbers randomly. call it delta and endpoint, where endpoint > delta.
  1. The one who starts the game chooses a number 'a' between 1 and delta
  2. The next player has to choose another number between (a+1) and (a + delta)
  3. Repeat the second step until one of the player's chosen number (ie. 'a') is **a+1<= endpoint >=a+delta**.
  4. Finally, the player whose answer was in the range of **a+1<= endpoint >=a+delta** losses the game.
