/*
 * PC ID: 110106
 * UVa ID: 10033
 * Name: Interpreter
 *
 * To change this PC110106_Interpreter, choose Tools | PC110106_Interpreters
 * and open the PC110106_Interpreter in the editor.
 */

/**
 *
 * @author Prabu
 * Date: 28-Aug-2010
 */

import java.io.*;
import java.util.*;

public class PC110106_Interpreter {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110106_Interpreter solver = new PC110106_Interpreter();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110106_Interpreter";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    static final int RAM_SIZE = 1000;
    static final int REGISTER_SIZE = 10;
    int[] register = new int[REGISTER_SIZE];
    int[] ram = new int[RAM_SIZE];

    void solve() throws IOException {
        int tc = sc.nextInt();
        String line;
        int i, stepCount, a, b, inst;
        
        sc.nextLine();
        sc.nextLine();
        for(int tci = 1; tci <= tc; tci++) {

            // Clean registers
            for(i = 0; i < REGISTER_SIZE; i++) {
                register[i] = 0;
            }

            i = 0;
            stepCount = 0;
            // Read instructions and store them into ram variable
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                if(line.equals(""))
                    break;
                
                ram[i] = Integer.parseInt(line);
                i++;
            }
            // Make remaining as zero
            for(; i < RAM_SIZE; i++) {
                ram[i] = 0;
            }

            // Process
            for(i = 0; i < RAM_SIZE; i++) {
                stepCount++;

                // Halt statement
                if(ram[i] == 100)
                    break;

                inst = ram[i] % 100;
                a = inst / 10;
                b = inst % 10;
                switch(ram[i]/100) {
                    case 2:
                        register[a] = b;
                        break;
                    case 3:
                        register[a] = (register[a] + b) % RAM_SIZE;
                        break;
                    case 4:
                        register[a] = (register[a] * b) % RAM_SIZE;
                        break;
                    case 5:
                        register[a] = register[b];
                        break;
                    case 6:
                        register[a] = (register[a] + register[b]) % RAM_SIZE;
                        break;
                    case 7:
                        register[a] = (register[a] * register[b]) % RAM_SIZE;
                        break;
                    case 8:
                        register[a] = ram[register[b]];
                        break;
                    case 9:
                        ram[register[b]] = register[a];
                        break;
                    case 0:
                        if(register[b] != 0)
                            i = register[a]-1;
                        break;
                }
            }

            // Write output
            if(tci != 1)
                out.println();
            out.println(stepCount);
        }
    }
/******************************************************************************/
}
