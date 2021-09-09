package com.bnpkata.tictactoe.game;

public class Move {
    char player;
    int row;
    int col;

    // Player Getter
    public char getPlayer() {
        return player;
    }

    // Player Setter
    public void setPlayer(char newPlayer) {
        this.player = newPlayer;
    }

    // Row Getter
    public int getRow() {
        return row;
    }

    // Row Setter
    public void setRow(int newRow) {
        this.row = newRow;
    }

    // Col Getter
    public int getCol() {
        return col;
    }

    // Col Setter
    public void setCol(int newCol) {
        this.col = newCol;
    }
}
