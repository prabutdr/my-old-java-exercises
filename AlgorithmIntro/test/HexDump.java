/*************************************************************************
 *  Compilation:  javac HexDump.java
 *  Execution:    java HexDump < file
 *  Dependencies: BinaryStdIn.java
 *  Data file:    http://introcs.cs.princeton.edu/stdlib/abra.txt
 *  
 *  Reads in a binary file and writes out the bytes in hex, 16 per line.
 *
 *  % more abra.txt
 *  ABRACADABRA!
 *
 *  % java HexDump 16 < abra.txt
 *  41 42 52 41 43 41 44 41 42 52 41 21
 *  96 bits
 *
 *  % hexdump < abra.txt
 *
 *  % od -t x1 < abra.txt 
 *  0000000 41 42 52 41 43 41 44 41 42 52 41 21
 *  0000014
 *
 *************************************************************************/

public class HexDump {

    public static void main(String[] args) {
        System.out.println("Opening input stream1...");
        int BYTES_PER_LINE = 16;
        if (args.length == 1) {
        System.out.println("Opening input stream2...");
            BYTES_PER_LINE = Integer.parseInt(args[0]);
        }
        System.out.println("Opening input stream...");
        BinaryIn in = new BinaryIn("IO/test.txt");
        System.out.println("Opening output stream...");
        Out out = new Out("IO/testHexDumpOut.txt");

        int i;
        for (i = 0; !in.isEmpty(); i++) {
            System.out.println(i);
            if (BYTES_PER_LINE == 0) { in.readChar(); continue; }
            if (i == 0) out.printf("");
            else if (i % BYTES_PER_LINE == 0) out.printf("\n", i);
            else out.print(" ");
            char c = in.readChar();
            out.printf("%02x", c & 0xff);
        }
        if (BYTES_PER_LINE != 0) out.println();
        StdOut.println((i*8) + " bits");
    }
}
