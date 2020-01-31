
import static java.lang.Math.min;
import static java.util.Arrays.deepToString;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

import java.io.*;

public class CC_Java_Samples_2 {

    void solve() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            int k = nextInt();
            int[] x = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = nextInt();
            }
            out.println(solve(n, x, k));
        }
    }

    static int solve(int n, int[] x, int k) {
        sort(x);
        int[] dp = new int[n + 1];
        fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && i >= j; j++) {
                int t = i - j;
                dp[i] = min(dp[i], dp[t] + x[i - 1] - x[t] + 1 - j + x[t] - t
                        - 1);
            }
        }
        return dp[n];
    }
    static InputReader sc;
    static PrintWriter out;

    static void debug(Object... a) {
        System.err.println(deepToString(a));
    }

    public void run() {
        try {
            File inputFile = new File("input.txt");
            if (inputFile.canRead()) {
                System.setIn(new FileInputStream(inputFile));
                System.setOut(new PrintStream("output.txt"));
            }
            sc = new StreamInputReader(System.in);
            out = new PrintWriter(System.out);
            solve();
            sc.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static double nextDouble() {
        String s = sc.next();
        if (s == null) {
            return Double.NaN;
        }
        return Double.parseDouble(s);
    }

    static long nextLong() {
        return sc.nextLong();
    }

    static int nextInt() {
        return sc.nextInt();
    }

    static String next() {
        return sc.next();
    }

    static abstract class InputReader {

        private boolean finished = false;

        public abstract int read();

        public long nextLong() {
            int c = read();
            while (c <= 32 && c >= 0) {
                c = read();
            }
            if (c == -1) {
                finished = true;
                return Long.MIN_VALUE;
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            long ret = 0;
            while (c >= '0' && c <= '9') {
                ret = ret * 10 + c - '0';
                c = read();
            }
            if (c > 32) {
                throw new NumberFormatException("space character expected "
                        + (char) c + " found");
            }
            return ret * sgn;
        }

        public int nextInt() {
            int c = read();
            while (c <= 32 && c >= 0) {
                c = read();
            }
            if (c == -1) {
                finished = true;
                return Integer.MIN_VALUE;
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            int ret = 0;
            while (c >= '0' && c <= '9') {
                ret = ret * 10 + c - '0';
                c = read();
            }
            if (c > 32) {
                throw new NumberFormatException("space character expected "
                        + (char) c + " found");
            }
            return ret * sgn;
        }

        public String next() {
            int c = read();
            while (c <= 32 && c >= 0) {
                c = read();
            }
            if (c == -1) {
                finished = true;
                return null;
            }
            StringBuilder res = new StringBuilder();
            while (c > 32) {
                res.appendCodePoint(c);
                c = read();
            }
            return res.toString();
        }

        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public abstract void close();
    }

    static class StreamInputReader extends InputReader {

        private InputStream stream;
        private byte[] buf;
        private int current, numOfChars;

        public StreamInputReader(InputStream stream) {
            this(stream, 1024);
        }

        public StreamInputReader(InputStream stream, int bufSize) {
            this.stream = stream;
            buf = new byte[bufSize];
        }

        public int read() {
            if (numOfChars == -1) {
                return -1;
            }
            if (current >= numOfChars) {
                current = 0;
                try {
                    numOfChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numOfChars <= 0) {
                    return -1;
                }
            }
            return buf[current++];
        }

        @Override
        public void close() {
            try {
                stream.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static void main(String[] args) {
        new CC_Java_Samples_2().run();
    }
}
