package com.example.tictactoeserver.config;

import java.util.UUID;

class Match {
    private static final int BOARD_SIZE = 3;
    final String firstPlayerID;
    final String secondPlayerID;
    final String roomId;
    char[][] board;
    String currentPlayer;
    boolean firstPlayerRestart;
    boolean secondPlayerRestart;

    public Match(String firstPlayerID, String secondPlayerID) {
        this.firstPlayerID = firstPlayerID;
        this.secondPlayerID = secondPlayerID;
        this.currentPlayer = firstPlayerID;
        this.roomId = String.valueOf(UUID.randomUUID());
        firstPlayerRestart = false;
        secondPlayerRestart = false;
        initializeBoard();
    }

    private void initializeBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void makeMove(int value) {
        int row = 0;
        int col = 0;
        if( value > 8 || value <0) return ;
        if(value < 3) {
            row = 0;
        } else if (value > 5) {
            row = 2;
        } else {
            row = 1;
        }
        if (value % 3 == 0) {
            col = 0;
        } else if (value % 3 == 1) {
            col = 1;
        } else {
            col = 2;
        }
        board[row][col] = (currentPlayer.equals(firstPlayerID)) ? 'X' : 'O';
        currentPlayer = (currentPlayer.equals(firstPlayerID)) ? secondPlayerID : firstPlayerID;
    }

    public int result() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return (board[i][0] == 'X') ? 1 : 2;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return (board[0][i] == 'X') ? 1 : 2;
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return (board[0][0] == 'X') ? 1 : 2;
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return (board[0][2] == 'X') ? 1 : 2;
        }

        // Check for a draw
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') {
                    return -1; // Game is still ongoing
                }
            }
        }

        return 0; // It's a draw
    }

    public boolean restart(String playerId) {
        if (playerId.equals(firstPlayerID))
            firstPlayerRestart = true;
        else if (playerId.equals((secondPlayerID)))
            secondPlayerRestart = true;
        if (secondPlayerRestart & firstPlayerRestart) {
            resetMatch();
            return true;
        }
        return false;
    }

    private void resetMatch() {
        firstPlayerRestart = false;
        secondPlayerRestart = false;
        initializeBoard();
    }
}