/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
                                          // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}

class myStuff implements Runnable{
    @SuppressWarnings("CallToThreadDumpStack")
    public void run() {
        try {
            myStuff solver = new myStuff();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

/******************************************************************************/
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    public static final int MAX_GRID_SIZE = 250 + 1;
    private char[][] grid = new char[MAX_GRID_SIZE][MAX_GRID_SIZE];
    private boolean[][] fillstatus = new boolean[MAX_GRID_SIZE][MAX_GRID_SIZE];
    private int m, n;
    private int i, j, x1, y1, x2, y2;
    private char color, prevcolor;

    void solve() throws IOException {
        String token;
        while(true) {
            char command = sc.next().charAt(0);
            //System.out.println(command);
            switch(command) {
                case 'I': // Create a new M x N grid
                    m = Integer.parseInt(sc.next());
                    n = Integer.parseInt(sc.next());
                    clearGrid();
                    break;
                case 'C':
                    clearGrid();
                    break;
                case 'L':
                    x1 = Integer.parseInt(sc.next());
                    y1 = Integer.parseInt(sc.next());
                    color = sc.next().charAt(0);
                    grid[y1][x1] = color;
                    break;
                case 'V':
                    x1 = x2 = Integer.parseInt(sc.next());
                    y1 = Integer.parseInt(sc.next());
                    y2 = Integer.parseInt(sc.next());
                    color = sc.next().charAt(0);
                    if(y1 > y2) { //swap
                        y1 = y1 + y2;
                        y2 = y1 - y2;
                        y1 = y1 - y2;
                    }
                    drawFilledRectange();
                    break;
                case 'H':
                    x1 = Integer.parseInt(sc.next());
                    x2 = Integer.parseInt(sc.next());
                    y1 = y2 = Integer.parseInt(sc.next());
                    color = sc.next().charAt(0);
                    drawFilledRectange();
                    break;
                case 'K':
                    x1 = Integer.parseInt(sc.next());
                    y1 = Integer.parseInt(sc.next());
                    x2 = Integer.parseInt(sc.next());
                    y2 = Integer.parseInt(sc.next());
                    color = sc.next().charAt(0);
                    if(x1 > x2) {
                        x1 = x1 + x2;
                        x2 = x1 - x2;
                        x1 = x1 - x2;
                    }
                    if(y1 > y2) { //swap
                        y1 = y1 + y2;
                        y2 = y1 - y2;
                        y1 = y1 - y2;
                    }
                    drawFilledRectange();
                    break;
                case 'F':
                    x1 = Integer.parseInt(sc.next());
                    y1 = Integer.parseInt(sc.next());
                    color = sc.next().charAt(0);
                    prevcolor = grid[y1][x1];
                    if(color != prevcolor) {
                        for(i = 1; i <= n; i++) {
                            for(j = 1; j <= m; j++) {
                                fillstatus[i][j] = false;
                            }
                        }
                        fill(x1, y1, 0);
                    }
                    break;
                case 'S':
                    String filename = sc.next();
                    out.println(filename);
                    for(i = 1; i <= n; i++) {
                        for(j = 1; j <= m; j++) {
                            out.print(grid[i][j]);
                        }
                        out.println();
                    }
                    break;
                case 'X':
                    return;
            }
        }
    }

    private void clearGrid() {
        for(i = 1; i <= n; i++) {
            for(j = 1; j <= m; j++) {
                grid[i][j] = 'O';
            }
        }
    }

    private void drawFilledRectange() {
        for(i = y1; i <= y2; i++) {
            for(j = x1; j <= x2; j++) {
                grid[i][j] = color;
            }
        }
    }

    private void fill(int x, int y, int pos) {
        int xx = 0, yy = 0;
        switch(pos) {
            case 0:
                xx = x;
                yy = y;
                break;
            case 1:
                if(x == 1 || y == 1)
                    break;
                xx = x - 1;
                yy = y - 1;
                break;
            case 2:
                if(y == 1)
                    break;
                xx = x;
                yy = y - 1;
                break;
            case 3:
                if(x == m || y == 1)
                    break;
                xx = x + 1;
                yy = y - 1;
                break;
            case 4:
                if(x == 1)
                    break;
                xx = x - 1;
                yy = y;
                break;
            case 5:
                if(x == m)
                    break;
                xx = x + 1;
                yy = y;
                break;
            case 6:
                if(x == 1 || y == n)
                    break;
                xx = x - 1;
                yy = y + 1;
                break;
            case 7:
                if(y == n)
                    break;
                xx = x;
                yy = y + 1;
                break;
            case 8:
                if(x == m || y == n)
                    break;
                xx = x + 1;
                yy = y + 1;
                break;
            default:
                return;
        }

        if(xx != 0 && yy != 0 && grid[yy][xx] == prevcolor && fillstatus[yy][xx] == false) {
            grid[yy][xx] = color;
            fillstatus[yy][xx] = true;
            fill(xx, yy, 0);
        }

        fill(x, y, ++pos);
    }
/******************************************************************************/
}
