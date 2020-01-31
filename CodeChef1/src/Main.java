import java.io.*;
import java.util.*;

public class Main {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            Main solver = new Main();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

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
    void solve() throws IOException {
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            //out.println("Case #" + tci + ": " + result);
        }
    }
/******************************************************************************/
}
