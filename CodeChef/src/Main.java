
import java.io.*;
import java.util.InputMismatchException;

public class Main {

    /**
     * ********************* WORK AREA - START
     * ***********************************
     */
    final static String FILENAME = "Main"; // without extensions (.IN, .OUT)

    void solve() throws Exception {
        int tc = in.readInt();
        int noTolls, noRoads, i, j, k;
        long tmpRateForTrans, tmpMinPathTravels;
        int amountRemain;
        int[][] tollRates, mecRates;
        long[] pathTravelTotal;
        long[] tmpPathTravelTotal;

        for (int tci = 1; tci <= tc; tci++) {
            amountRemain = in.readInt();
            noTolls = in.readInt();
            noRoads = in.readInt();
            tollRates = new int[noRoads][noTolls];
            mecRates = new int[noRoads][noRoads];
            pathTravelTotal = new long[noRoads];
            tmpPathTravelTotal = new long[noRoads];

            for (i = 0; i < noRoads; i++) {
                for (j = 0; j < noTolls; j++) {
                    tollRates[i][j] = in.readInt();
                }
                pathTravelTotal[i] = tollRates[i][0];
            }
            for (i = 0; i < noRoads; i++) {
                for (j = 0; j < noRoads; j++) {
                    mecRates[i][j] = in.readInt();
                }
            }
            
            for (k = 0; k < noRoads; k++) {
                for (i = 0; i < noRoads; i++) {
                    for (j = 0; j < noRoads; j++) {
                        if (mecRates[i][k] + mecRates[k][j] < mecRates[i][j]) {
                            mecRates[i][j] = mecRates[i][k] + mecRates[k][j];
                        }
                    }
                }
            }

            for (k = 1; k < noTolls; k++) {
                for (i = 0; i < noRoads; i++) {
                    tmpMinPathTravels = -1;
                    for (j = 0; j < noRoads; j++) {
                        if (i == j) {
                            tmpRateForTrans = pathTravelTotal[j];
                        } else {
                            tmpRateForTrans = pathTravelTotal[j]
                                    + mecRates[j][i];
                        }
                        if (tmpMinPathTravels == -1
                                || tmpMinPathTravels > tmpRateForTrans) {
                            tmpMinPathTravels = tmpRateForTrans;
                        }
                    }
                    tmpPathTravelTotal[i] = (tmpMinPathTravels + tollRates[i][k]);
                }
                for (i = 0; i < noRoads; i++) {
                    pathTravelTotal[i] = tmpPathTravelTotal[i];
                }
            }

            // Find min in the last
            tmpMinPathTravels = pathTravelTotal[0];
            for (i = 1; i < noRoads; i++) {
                if (tmpMinPathTravels > pathTravelTotal[i]) {
                    tmpMinPathTravels = pathTravelTotal[i];
                }
            }
            amountRemain -= tmpMinPathTravels;
            if (amountRemain < 0) {
                out.println("-1");
            } else {
                out.println(amountRemain);
            }
        }
    }
    /**
     * ********************* WORK AREA - END
     * *************************************
     */
    private InputReader in;
    private PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";
        if (new File(inFileName).canRead()) {
            in = new InputReader(new FileInputStream(inFileName));
            out = new PrintWriter(new PrintStream(outFileName));
        } else {
            in = new InputReader(System.in);
            out = new PrintWriter(System.out);
        }
    }

    void closeIO() throws IOException {
        out.close();
        //in.close();
    }

    public static void main(String[] args) throws Exception {
        Main solver = new Main();
        solver.openIO();
        solver.solve();
        solver.closeIO();
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }
}
