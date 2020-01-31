/**
 * @author Prabu
 * @date Mar 18, 2012
 */
package com.wintech.util;

import com.wintech.draw.Picture;
import com.wintech.io.BinaryIn;
import com.wintech.io.BinaryOut;
import com.wintech.io.Out;
import com.wintech.io.StdOut;
import java.awt.Color;

public class IOUtil {

    /**
     * Reads in a binary file and writes out the bits, N per line.
     * 
     * @param sfile
     * @param dfile
     * @param bitsPerLine 
     * @throws IllegalArgumentException, if bitsPerLine is less than 1
     * @return total count of bits
     */
    public static int bitDump(String sfile, String dfile, int bitsPerLine) {
        if(bitsPerLine <= 0)
            throw new IllegalArgumentException("Illegal value of bitsPerLine = " + bitsPerLine);    
        
        BinaryIn in = new BinaryIn(sfile);
        Out out = new Out(dfile);
        
        int count;
        for(count = 0; !in.isEmpty(); count++) {
            if(count != 0 && (count%bitsPerLine) == 0) out.println();
            if(in.readBoolean())
                out.print("1");
            else
                out.print("0");
        }
        out.close();
        in.close();
        
        return count;
    }

    /**
     * Reads in a binary file and writes out the bytes in hex, 16 per line.
     * 
     * @param sfile
     * @param dfile
     * @param bytesPerLine 
     * @throws IllegalArgumentException, if bitsPerLine is less than 1
     * @return total count of bytes
     */
    public static int hexDump(String sfile, String dfile, int bytesPerLine) {
        if(bytesPerLine <= 0)
            throw new IllegalArgumentException("Illegal value of bytesPerLine = " + bytesPerLine);    
        
        BinaryIn in = new BinaryIn(sfile);
        Out out = new Out(dfile);
        
        int count;
        for(count = 0; !in.isEmpty(); count++) {
            if(count == 0)
                out.printf("");
            else if((count % bytesPerLine) == 0) 
                out.println();
            else
                out.printf(" ");
            char c = in.readChar();
            out.printf("%02x", (c & 0xff));
        }
        out.close();
        in.close();
        
        return count;
    }

    /**
     * Copy binary content of source file to destination file
     * 
     * @param sfile
     * @param dfile
     * @return total count of bytes copied
     */
    public static int copy(String sfile, String dfile) {
        BinaryIn in = new BinaryIn(sfile);
        BinaryOut out = new BinaryOut(dfile);
        
        int count;
        for(count = 0; !in.isEmpty(); count++) {
            out.write(in.readChar());
        }
        out.flush();
        
        in.close();
        out.close();
        
        return count;
    }
    
    /**
     * Reads in a binary file and writes out the bits as w-by-h picture,
     * with the 1 bits in black and the 0 bits in white.
     * 
     * @param binaryFile
     * @param pictureFile 
     * @return total count of bits
     */
    public static int binaryToPicture(String binaryFile, String pictureFile,
            int width, int height) {
        BinaryIn in = new BinaryIn(binaryFile);
        Picture pic = new Picture(width, height);
        
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pic.set(j, i, Color.RED);
                if (!in.isEmpty()) {
                    count++;
                    boolean bit = in.readBoolean();
                    if (bit) pic.set(j, i, Color.BLACK);
                    else     pic.set(j, i, Color.WHITE);
                }
            }
        }
        pic.save(pictureFile);
       
        return count;
    }
    
    /**
     * Test client for IOUtil
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // for bit dump
        int bitCount = IOUtil.bitDump("IO/test.txt", "IO/textDumpOut.txt", 2);
        StdOut.println("Total bit dump bit count - " + bitCount);

        // for hex dump
        int byteCount = IOUtil.hexDump("IO/test.txt", "IO/textHexOut.txt", 2);
        StdOut.println("Total hex dump byte count - " + byteCount);

        // for copy
        byteCount = IOUtil.copy("IO/test.txt", "IO/textCopyOut.txt");
        StdOut.println("Total copy byte count - " + byteCount);
        
        // for binaryToPicture
        bitCount = IOUtil.binaryToPicture("IO/brownian.txt", "IO/testBinaryToPictureOut.jpg", 500, 500);
        StdOut.println("Total binaryToPicture bite count - " + bitCount);
        Picture pic = new Picture("IO/testBinaryToPictureOut.jpg");
        pic.show();
    }
}
