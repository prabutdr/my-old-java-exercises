/**
 * @author Prabu @date Dec 15, 2011
 */
package com.codechef.dec2011.longc;

import java.util.Comparator;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Egor Kulikov (egor@egork.net)
 */
public class CHEFGIFT_2 {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        BirthdayGift solver = new BirthdayGift();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }
}

class BirthdayGift {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int money = in.readInt();
        int boothCount = in.readInt();
        int roadCount = in.readInt();
        int[][] toll = IOUtils.readIntTable(in, roadCount, boothCount);
        int[][] shift = IOUtils.readIntTable(in, roadCount, roadCount);
        for (int i = 0; i < roadCount; i++) {
            for (int j = 0; j < roadCount; j++) {
                for (int k = 0; k < roadCount; k++) {
                    shift[j][k] = Math.min(shift[j][k], shift[j][i] + shift[i][k]);
                }
            }
        }
        int[] result = new int[roadCount];
        for (int i = 0; i < boothCount; i++) {
            for (int j = 0; j < roadCount; j++) {
                result[j] += toll[j][i];
            }
            for (int j = 0; j < roadCount; j++) {
                for (int k = 0; k < roadCount; k++) {
                    result[j] = Math.min(result[j], result[k] + shift[k][j]);
                }
            }
        }
        money -= CollectionUtils.minElement(Array.wrap(result));
        if (money >= 0) {
            out.printLine(money);
        } else {
            out.printLine(-1);
        }
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

class OutputWriter {

    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(outputStream);
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}

class IOUtils {

    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.readInt();
        }
        return array;
    }

    public static int[][] readIntTable(InputReader in, int rowCount, int columnCount) {
        int[][] table = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            table[i] = readIntArray(in, columnCount);
        }
        return table;
    }
}

class CollectionUtils {

    public static <T extends Comparable<T>> T minElement(Iterable<T> collection) {
        T result = null;
        for (T element : collection) {
            if (result == null || result.compareTo(element) > 0) {
                result = element;
            }
        }
        return result;
    }
}

abstract class Array<T> extends AbstractList<T> {

    public static List<Integer> wrap(int... array) {
        return new IntArray(array);
    }

    protected static class IntArray extends Array<Integer> {

        protected final int[] array;

        protected IntArray(int[] array) {
            this.array = array;
        }

        public int size() {
            return array.length;
        }

        public Integer get(int index) {
            return array[index];
        }

        public Integer set(int index, Integer value) {
            int result = array[index];
            array[index] = value;
            return result;
        }
    }
}
