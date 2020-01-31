/*
 * PC ID: 110108
 * UVa ID: 10142
 * Name: Australian Voting
 * 
 * @author Prabu
 * @date 23-Nov-2011
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Template {

    /*********************** WORK AREA - START ********************************/
    final static boolean USE_FILE_IO = true;

    void solve() throws Exception {
    }
    /*********************** WORK AREA - END **********************************/

    private BufferedReader in;
    private PrintWriter out;

    void openIO() throws IOException {
        if (USE_FILE_IO) {
            String inFileName = "IO/Input/" + this.getClass().getName() + ".IN";
            String outFileName = "IO/Output/" + this.getClass().getName() + ".OUT";
            System.setIn(new FileInputStream(inFileName));
            System.setOut(new PrintStream(outFileName));
        }

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    void closeIO() throws IOException {
        out.close();
        in.close();
    }

    public static void main(String[] args) throws Exception {
        try {
            Template solver = new Template();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Exception e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
            throw e;
        }
    }
}
