
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author Prabu
 * @date Mar 17, 2012
 */

public class InPerfTest {
    public static void main(String[] args) {
        String filename = "IO/largeW.txt";
        long startTime = System.currentTimeMillis();
        Scanner in = new Scanner();
        try {
            for(int i = 0; i < 100000; i++) {
            System.out.println(in.nextInt());
            }
        }
        catch(Exception e) {
            //e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time - 3: " + (endTime - startTime));
    }
}

    class Scanner {
        BufferedInputStream in;
        public Scanner() {
        try {
            in = new BufferedInputStream(new FileInputStream("IO/largeW.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        int nextInt() {
            try {
                int c = in.read();
                if (c == -1) {
                    return c;
                }
                while (c != '-' && (c < '0' || '9' < c)) {
                    c = in.read();
                    if (c == -1) {
                        return c;
                    }
                }
                if (c == '-') {
                    return -nextInt();
                }
                int res = 0;
                do {
                    res *= 10;
                    res += c - '0';
                    c = in.read();
                } while ('0' <= c && c <= '9');
                return res;
            } catch (Exception e) {
                return -1;
            }
        }

        long nextLong() {
            try {
                int c = in.read();
                if (c == -1) {
                    return -1;
                }
                while (c != '-' && (c < '0' || '9' < c)) {
                    c = in.read();
                    if (c == -1) {
                        return -1;
                    }
                }
                if (c == '-') {
                    return -nextLong();
                }
                long res = 0;
                do {
                    res *= 10;
                    res += c - '0';
                    c = in.read();
                } while ('0' <= c && c <= '9');
                return res;
            } catch (Exception e) {
                return -1;
            }
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            try {
                StringBuilder res = new StringBuilder("");
                int c = in.read();
                while (Character.isWhitespace(c)) {
                    c = in.read();
                }
                do {
                    res.append((char) c);
                } while (!Character.isWhitespace(c = in.read()));
                return res.toString();
            } catch (Exception e) {
                return null;
            }
        }

        String nextLine() {
            try {
                StringBuilder res = new StringBuilder("");
                int c = in.read();
                while (c == '\r' || c == '\n') {
                    c = in.read();
                }
                do {
                    res.append((char) c);
                    c = in.read();
                } while (c != '\r' && c != '\n');
                return res.toString();
            } catch (Exception e) {
                return null;
            }
        }
    }
