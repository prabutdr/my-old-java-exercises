/*
 * PC ID: 110107
 * UVa ID: 10196
 * Name: Check the Check
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prabu
 * @date 27-Jan-2011
 */

import java.io.*;
import java.util.*;

public class PC110107_CheckBoard {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110107_CheckBoard solver = new PC110107_CheckBoard();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110107_CheckBoard";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    final static int CHECKBOARD_SIZE = 8;
    final static char EMPTY = '.';

    final static byte NO_CHECK = 0;
    final static byte WHITE_CHECK = 1;
    final static byte BLACK_CHECK = 2;

    char[][] board = new char[CHECKBOARD_SIZE][CHECKBOARD_SIZE]; // check board

    void solve() throws IOException {
        String line;
        int gameCount = 1;
        while(true) {
            for(int i = 0; i < CHECKBOARD_SIZE; i++) {
                line = sc.nextLine();
                board[i] = line.toCharArray();
            }

            boolean isEmptyBoard = true;
            byte checkStatus = NO_CHECK;
            outer:
            for(int i = 0; i < CHECKBOARD_SIZE; i++) {
                for(int j = 0; j < CHECKBOARD_SIZE; j++) {
                    //System.out.print(board[i][j]);
                    if(board[i][j] == EMPTY) //skip if there is no pieces
                        continue;

                    isEmptyBoard = false; //some piece is there, so this is not empty board

                    checkStatus = checkTheCheck(i, j);
                    if(checkStatus != NO_CHECK)
                        break outer;
                }
                //System.out.println();
            }
            if(isEmptyBoard) //if empty board simply exit
                return;

            out.print("Game #" + gameCount + ": ");
            if(checkStatus == WHITE_CHECK)
                out.println("white king is in check.");
            else if(checkStatus == BLACK_CHECK)
                out.println("black king is in check.");
            else
                out.println("no king is in check.");
            
            sc.nextLine(); // to read empty line between board
            //System.out.println();
            gameCount++;
        }
    }

    private byte checkTheCheck(int row, int col) {
        boolean isWhitePiece = true;

        // Find the piece type (white or black)
        isWhitePiece = Character.isUpperCase(board[row][col]);

        String nextMoves = "";
        switch(board[row][col]) {
            case 'P': // Pawn
            case 'p':
                if(isWhitePiece)
                    nextMoves = checksForPawn_White(row, col);
                else
                    nextMoves = checksForPawn_Black(row, col);
                break;
            case 'N': // Knight
            case 'n':
                nextMoves = checksForKnight(row, col);
                break;
            case 'B': // Bishop
            case 'b':
                nextMoves = checksForBishop(row, col);
                break;
            case 'R': // Rook
            case 'r':
                nextMoves = checksForRook(row, col);
                break;
            case 'Q': // Queen
            case 'q':
                nextMoves = checksForQueen(row, col);
                break;
            case 'K': // King
            case 'k':
                nextMoves = checksForKing(row, col);
                break;
        }

        //System.out.println(row + ", " + col + ", " + isWhitePiece + ": " + nextMoves);
        if(isWhitePiece && nextMoves.indexOf('k') != -1)
            return BLACK_CHECK;
        else if(!isWhitePiece && nextMoves.indexOf('K') != -1)
            return WHITE_CHECK;
        else
            return NO_CHECK;
    }

    private String checksForPawn_White(int row, int col) {
        StringBuilder sb = new StringBuilder();
        row--;

        if(row >= 0) {
            if(col-1 >= 0 /*&& board[row][col-1] != EMPTY
                && Character.isLowerCase(board[row][col-1])*/)
                sb.append(board[row][col-1]);

            if(col+1 < CHECKBOARD_SIZE /*&& board[row][col+1] != EMPTY
                    && Character.isLowerCase(board[row][col+1])*/)
                sb.append(board[row][col+1]);
        }
        return sb.toString();
    }

    private String checksForPawn_Black(int row, int col) {
        StringBuilder sb = new StringBuilder();
        row++;

        if(row < CHECKBOARD_SIZE) {
            if(col-1 >= 0 /*&& board[row][col-1] != EMPTY
                && Character.isUpperCase(board[row][col-1])*/)
                sb.append(board[row][col-1]);

            if(col+1 < CHECKBOARD_SIZE /*&& board[row][col+1] != EMPTY
                    && Character.isUpperCase(board[row][col+1])*/)
                sb.append(board[row][col+1]);
        }
        return sb.toString();
    }

    private String checksForKnight(int row, int col) {
        StringBuilder sb = new StringBuilder();

        if(row-2 >= 0) {
            if(col-1 >= 0)
                sb.append(board[row-2][col-1]);
            if(col+1 < CHECKBOARD_SIZE)
                sb.append(board[row-2][col+1]);
        }
        if(row-1 >= 0) {
            if(col-2 >= 0)
                sb.append(board[row-1][col-2]);
            if(col+2 < CHECKBOARD_SIZE)
                sb.append(board[row-1][col+2]);
        }
        if(row+2 < CHECKBOARD_SIZE) {
            if(col-1 >= 0)
                sb.append(board[row+2][col-1]);
            if(col+1 < CHECKBOARD_SIZE)
                sb.append(board[row+2][col+1]);
        }
        if(row+1 < CHECKBOARD_SIZE) {
            if(col-2 >= 0)
                sb.append(board[row+1][col-2]);
            if(col+2 < CHECKBOARD_SIZE)
                sb.append(board[row+1][col+2]);
        }
        return sb.toString();
    }

    private String checksForBishop(int row, int col) {
        StringBuilder sb = new StringBuilder();

        int i, j;
        for(i=row-1, j=col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        for(i=row-1, j=col+1; i >= 0 && j < CHECKBOARD_SIZE; i--, j++) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        for(i=row+1, j=col+1; i < CHECKBOARD_SIZE && j < CHECKBOARD_SIZE; i++, j++) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        for(i=row+1, j=col-1; i < CHECKBOARD_SIZE && j >= 0; i++, j--) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        return sb.toString();
    }

    private String checksForRook(int row, int col) {
        StringBuilder sb = new StringBuilder();

        int i, j;
        for(i=row-1, j=col; i >= 0; i--) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        for(i=row, j=col+1; j < CHECKBOARD_SIZE; j++) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        for(i=row+1, j=col; i < CHECKBOARD_SIZE; i++) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        for(i=row, j=col-1; j >= 0; j--) {
            if(board[i][j] != EMPTY) {
                sb.append(board[i][j]);
                break;
            }
        }
        return sb.toString();
    }

    private String checksForQueen(int row, int col) {
        StringBuilder sb = new StringBuilder();

        sb.append(checksForRook(row, col));
        sb.append(checksForBishop(row, col));

        return sb.toString();
    }

    private String checksForKing(int row, int col) {
        StringBuilder sb = new StringBuilder();

        if(row-1 >= 0) {
            if(col-1 >= 0)
                sb.append(board[row-1][col-1]);
            if(col+1 < CHECKBOARD_SIZE)
                sb.append(board[row-1][col+1]);
            sb.append(board[row-1][col]);
        }
        //if(row-1 >= 0) {
            if(col-1 >= 0)
                sb.append(board[row][col-1]);
            if(col+1 < CHECKBOARD_SIZE)
                sb.append(board[row][col+1]);
        //}
        if(row+1 < CHECKBOARD_SIZE) {
            if(col-1 >= 0)
                sb.append(board[row+1][col-1]);
            if(col+1 < CHECKBOARD_SIZE)
                sb.append(board[row+1][col+1]);
            sb.append(board[row+1][col]);
        }
        /*
        if(row+1 < CHECKBOARD_SIZE) {
            if(col-1 >= 0)
                sb.append(board[row+1][col-1]);
            if(col+1 < CHECKBOARD_SIZE)
                sb.append(board[row+1][col+1]);
        }*/

        return sb.toString();
    }
/******************************************************************************/
}

