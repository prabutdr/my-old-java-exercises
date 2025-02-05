import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Main.java
 * java program model for www.programming-challenges.com
 */
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
    public void run() {
        try {
            Template solver = new Template();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Exception e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }

    private static BufferedReader in;
    private static PrintWriter out;

    void openIO() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    void closeIO() throws IOException {
        out.close();
        in.close();
    }

/******************************************************************************/
    void solve() throws Exception {
    }
/******************************************************************************/
}

