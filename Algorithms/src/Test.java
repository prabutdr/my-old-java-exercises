/**
 * @author Prabu
 * @date Mar 15, 2012
 */
import com.wintech.io.In;
import com.wintech.io.StdOut;
import com.wintech.util.*;
import java.io.*;
import java.lang.*;

public class Test {
    public static void main(String[] args) throws IOException {
        //System.out.println(java.lang.Math.sqrt(2));
        //System.out.println(com.wintech.util.Math.sqrt(2));
        
        /*BufferedInputStream in = new BufferedInputStream(new FileInputStream("IO/test.txt"));
        int c = in.read();
        while(c != -1) {
            System.out.println((char)c);
            c = in.read();
        }
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());*/

        /*DataInputStream di = new DataInputStream(new FileInputStream("IO/test.txt"));
        c = di.readInt();
        while(c != -1) {
            System.out.println((char)c);
            c = di.readInt();
        }*/
        
        /*DataOutputStream out = new DataOutputStream(new FileOutputStream("IO/testout.txt"));
        out.write(10);
        out.writeChars(" test input");
        out.close();*/
        
        /*BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("IO/testout.txt"));
        byte[] bytes = "Input".getBytes();
        System.out.println(java.util.Arrays.toString(bytes));*/
        /*DataInputStream sysin = new DataInputStream(new BufferedInputStream(System.in));
        int i = sysin.readInt();
        System.out.println("i: " + i);*/
        /*In in = new In("test");
        System.err.println(in.exists());
        System.err.println(in.exists());
        System.err.println(in.exists());
        System.err.println(in.exists());
        System.err.println(in.exists());*/
        StdOut.println("min - " + StdStats.min(new int[] {8, 9, 24, 1, 44}));
        StdOut.println("max - " + StdStats.max(new int[] {8, 9, 24, 1, 44}));
        StdOut.println("Avg - " + StdStats.mean(new int[] {8, 9, 24, 1, 44}));
    }
}
