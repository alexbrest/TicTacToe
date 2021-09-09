package com.bnpkata.tictactoe.game;

import org.springframework.stereotype.Service;

@Service
public class Game{
    char[][] gameState;
    char playerTurn;
    char winner;
    
    public Game(){
        gameState = new char[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameState[i][j] = ' ';
            }    
        }

        playerTurn = 'x';

        winner = ' ';
    }

    public boolean recordMove(Move move){ //char player, int row, int col){

        char player = move.getPlayer();
        int row = move.getRow();
        int col = move.getCol();

        //Check if game is finished
        //if(winner != ' ')
        //    return false;

        //Check if it's the right player's turn
        if(player != playerTurn)
            return false;
        
        //Check if row is in game range
        if(row < 0 || row >= 3)
            return false;

        //Check if col is in game range
        if(col < 0 || col >= 3)
            return false;

        //Check if game cell is already filled
        if(gameState[row][col] != ' '){
            //System.out.println("Second move");
            return false;
        }

        //Check if player is a valid player
        if(player != 'x' && player != 'o')
            return false;

        //Record move
        gameState[row][col] = player;

        //Check if game is finished
        checkGameFinished();

        //Change player
        if(playerTurn == 'x')
            playerTurn = 'o';
        else 
            playerTurn = 'x';

        return true;
    }

    void checkGameFinished(){
        //Check horizontals
        for(int i = 0; i < 3; i++){
            if(gameState[i][0] == gameState[i][1] &&
              gameState[i][1] == gameState[i][2] &&
              gameState[i][0] != ' '){

                restartGame(gameState[i][0]);

            }
        }

        //Check verticals
        for(int i = 0; i < 3; i++){
            if(gameState[0][i] == gameState[1][i] &&
              gameState[1][i] == gameState[2][i] &&
              gameState[0][i] != ' '){

                restartGame(gameState[0][i]);

            }
        }

        //Check diagonal A
        if(gameState[0][0] == gameState[1][1] &&
            gameState[1][1] == gameState[2][2] &&
            gameState[0][0] != ' '){

                restartGame(gameState[0][0]);

        }

        //Check diagonal B
        if(gameState[0][2] == gameState[1][1] &&
            gameState[1][1] == gameState[2][0] &&
            gameState[0][2] != ' '){

                restartGame(gameState[0][2]);

        }

        //Check game is draw
        boolean isDraw = true;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameState[i][j] == ' ')
                    isDraw = false;
            }
        }

        if(isDraw){
            restartGame('d');
        }
    }

    public void restartGame(char newWinner){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameState[i][j] = ' ';
            }
        }

        winner = newWinner;
    }


    // GameState Getter
    public char[][] getGameState() {
        return gameState;
    }

    // GameState Setter
    public void setGameState(char[][] newGameState) {
        this.gameState = newGameState;
    }

    // PlayerTurn Getter
    public char getPlayerTurn() {
        return playerTurn;
    }

    // PlayerTurn Setter
    public void setPlayerTurn(char newPlayerTurn) {
        this.playerTurn = newPlayerTurn;
    }

    // Winner Getter
    public char getWinner() {
        return winner;
    }

    // Winner Setter
    public void setWinner(char newWinner) {
        this.winner = newWinner;
    }
}