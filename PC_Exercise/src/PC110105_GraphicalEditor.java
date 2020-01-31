/*
 * PC ID: 110105
 * UVa ID: 10267
 * Name: Graphical Editor
 *
 * Problem
 * -------
 * Graphical editors such as Photoshop allow us to alter bit-mapped images in
 * the same way that text editors allow us to modify documents. Images are
 * represented as an M x N array of pixels, where each pixel has a given color.
 *
 * Your task is to write a program which simulates a simple interactive
 * graphical editor.
 *
 * Input
 * -----
 * The input consists of a sequence of editor commands, one per line. Each
 * command is represented by one capital letter placed as the first character
 * of the line. If the command needs parameters, they will be given on the same
 * line separated by spaces.
 *
 * Pixel coordinates are represented by two integers, a column number between
 * 1...M and a row number between 1...N, where 1M, N250. The origin sits in the
 * upper-left corner of the table. Colors are specified by capital letters.
 *
 * The editor accepts the following commands:
 *
 * I M N            - Create a new M x N image with all pixels initially colored
 *                    white (O).
 * C                - Clear the table by setting all pixels white (O). The size
 *                    remains unchanged.
 * L X Y C          - Colors the pixel (X, Y) in color (C).
 * V X Y1 Y2 C      - Draw a vertical segment of color (C) in column X, between
 *                    the rows Y1 and Y2 inclusive.
 * H X1 X2 Y C      - Draw a horizontal segment of color (C) in the row Y,
 *                    between the columns X1 and X2 inclusive.
 * K X1 Y1 X2 Y2 C  - Draw a filled rectangle of color C, where (X1, Y1) is the
 *                    upper-left and (X2, Y2) the lower right corner.
 * F X Y C          - Fill the region R with the color C, where R is defined as
 *                    follows. Pixel (X, Y) belongs to R. Any other pixel which
 *                    is the same color as pixel (X, Y) and shares a common side
 *                    with any pixel in R also belongs to this region.
 * S Name           - Write the file name in MSDOS 8.3 format followed by the
 *                    contents of the current image.
 * X                - Terminate the session.
 *
 * Output
 * ------
 * On every command S NAME, print the filename NAME and contents of the current
 * image. Each row is represented by the color contents of each pixel. See the
 * sample output.
 *
 * Ignore the entire line of any command defined by a character other than
 * I, C, L, V, H, K, F, S, or X, and pass on to the next command. In case of
 * other errors, the program behavior is unpredictable.
 *
 * Sample Input
 * ------------
 * I 5 6
 * L 2 3 A
 * S one.bmp
 * G 2 3 J
 * F 3 3 J
 * V 2 3 4 W
 * H 3 4 2 Z
 * S two.bmp
 * X
 *
 * Sample Output
 * -------------
 * one.bmp
 * OOOOO
 * OOOOO
 * OAOOO
 * OOOOO
 * OOOOO
 * OOOOO
 * two.bmp
 * JJJJJ
 * JJZZJ
 * JWJJJ
 * JWJJJ
 * JJJJJ
 * JJJJJ
 *
 */

/**
 * @author Prabu
 * Date: 17-Aug-2010
 */

import java.io.*;
import java.util.*;

public class PC110105_GraphicalEditor {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110105_GraphicalEditor solver = new PC110105_GraphicalEditor();
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
    final static String FILENAME = "PC110105_GraphicalEditor";
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
    public static final int MAX_GRID_SIZE = 250 + 1;
    private char[][] grid = new char[MAX_GRID_SIZE][MAX_GRID_SIZE];
    private int m, n;
    private int i, j, x1, y1, x2, y2;
    private char color, prevcolor;

    void solve() throws IOException {
        while(true) {
            char command = sc.next().charAt(0);
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
                    if(color != prevcolor)
                        fill(x1, y1);
                    break;
                case 'S':
                    String filename = sc.next();
                    if(filename.length() > 12)
                        filename = filename.substring(0, 12);
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

    private void fill(int x, int y) {
        if(grid[y][x] == color)
            return;

        grid[y][x] = color;

        if(x > 1 && grid[y][x-1] == prevcolor) {
            fill(x - 1, y);
        }
        if(x < MAX_GRID_SIZE-1 && grid[y][x+1] == prevcolor) {
            fill(x + 1, y);
        }
        if(y > 1 && grid[y-1][x] == prevcolor) {
            fill(x, y - 1);
        }
        if(y < MAX_GRID_SIZE-1 && grid[y+1][x] == prevcolor) {
            fill(x, y + 1);
        }
    }
/******************************************************************************/
}
