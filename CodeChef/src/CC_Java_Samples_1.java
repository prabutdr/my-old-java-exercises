
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.util.*;

public class CC_Java_Samples_1 {

    public static void main(String[] args) {
        new CC_Java_Samples_1().run();
    }

    private void run() {
        Scanner sc = new Scanner();
        int o = sc.nextInt();
        while (o-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int MX = k - 1;
            int[] num = new int[k];
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            sort(A);
            long res = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            int use = 0;
            for (int i = m - 1; i >= 0; i--) {
                int mod = A[i] % k;
                if (num[mod] >= MX) {
                    res += A[i];
                    use++;
                } else {
                    list.add(A[i]);
                    num[mod]++;
                }
            }
            fill(num, 0);
            for (int i = m; i < n; i++) {
                int mod = A[i] % k;
                if (num[mod] >= MX) {
                } else {
                    list.add(A[i]);
                    num[mod]++;
                }
            }
            long add = f(tois(list.toArray(new Integer[0])), m - use, (k - (int) (res % k)) % k, k);
            if (add >= INF) {
                System.out.println(-1);
            } else {
                System.out.println(res + add);
            }
        }
    }
    long INF = 1L << 60;

    private long f(int[] is, int m, int obj, int K) {
        int n = is.length;
        long[][][] dp = new long[2][m + 1][K];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int l = 0; l < K; l++) {
                    dp[i][j][l] = INF;
                }
            }
        }
        int[] mods = new int[is.length];
        for (int i = 0; i < n; i++) {
            mods[i] = is[i] % K;
        }
        dp[0][0][0] = 0;
        int cur = 0, nxt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                fill(dp[nxt][j], INF);
            }
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < K; k++) {
                    dp[nxt][j][k] = min(dp[nxt][j][k], dp[cur][j][k]);
                    int nk = (k + mods[i]);
                    if (nk >= K) {
                        nk -= K;
                    }
                    if (j + 1 <= m) {
                        dp[nxt][j + 1][nk] = min(dp[nxt][j + 1][nk], dp[cur][j][k] + is[i]);
                    }
                }
            }
            int tmp = cur;
            cur = nxt;
            nxt = tmp;
        }
        return dp[cur][m][obj];
    }

    private int[] tois(Integer[] Is) {
        int[] is = new int[Is.length];
        for (int i = 0; i < is.length; i++) {
            is[i] = Is[i];
        }
        return is;
    }

    class Scanner {

        int nextInt() {
            try {
                int c = System.in.read();
                if (c == -1) {
                    return c;
                }
                while (c != '-' && (c < '0' || '9' < c)) {
                    c = System.in.read();
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
                    c = System.in.read();
                } while ('0' <= c && c <= '9');
                return res;
            } catch (Exception e) {
                return -1;
            }
        }

        long nextLong() {
            try {
                int c = System.in.read();
                if (c == -1) {
                    return -1;
                }
                while (c != '-' && (c < '0' || '9' < c)) {
                    c = System.in.read();
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
                    c = System.in.read();
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
                int c = System.in.read();
                while (Character.isWhitespace(c)) {
                    c = System.in.read();
                }
                do {
                    res.append((char) c);
                } while (!Character.isWhitespace(c = System.in.read()));
                return res.toString();
            } catch (Exception e) {
                return null;
            }
        }

        String nextLine() {
            try {
                StringBuilder res = new StringBuilder("");
                int c = System.in.read();
                while (c == '\r' || c == '\n') {
                    c = System.in.read();
                }
                do {
                    res.append((char) c);
                    c = System.in.read();
                } while (c != '\r' && c != '\n');
                return res.toString();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
