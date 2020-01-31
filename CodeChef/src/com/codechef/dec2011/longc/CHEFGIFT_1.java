/**
 * @author Prabu
 * @date Dec 12, 2011
 */
package com.codechef.dec2011.longc;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CHEFGIFT_1 {

    static Parser in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new Parser(new FileInputStream("IO/Input/CHEFGIFT_1.IN"));
        out = new PrintWriter(new PrintStream("IO/Output/CHEFGIFT_1.OUT"));
        final int N = 100;
        int[][] a = new int[N][N];
        int[][] c = new int[N][N];
        for (int t = in.nextInt(); t > 0; t--) {
            int d = in.nextInt(), n = in.nextInt(), m = in.nextInt();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    c[i][j] = in.nextInt();
                }
            }
            for (int k = 0; k < m; k++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        if (c[i][k] + c[k][j] < c[i][j]) {
                            c[i][j] = c[i][k] + c[k][j];
                        }
                    }
                }
            }
            int[] dp = new int[m];
            for (int i = 0; i < m; i++) {
                dp[i] = a[i][0];
            }
            int[] next = new int[m];
            for (int j = 1; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    int cur = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++) {
                        if (dp[k] + c[k][i] < cur) {
                            cur = dp[k] + c[k][i];
                        }
                    }
                    next[i] = cur + a[i][j];
                }
                int[] tmp = dp;
                dp = next;
                next = tmp;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (dp[i] < min) {
                    min = dp[i];
                }
            }
            out.println(min <= d ? d - min : "-1");
        }
        out.flush();
    }

    static class Parser {

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws Exception {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws Exception {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws Exception {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
    }
}
