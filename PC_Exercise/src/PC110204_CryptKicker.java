/*
 * PC ID: 110108
 * UVa ID: 10142
 * Name: Australian Voting
 *
 */

/**
 *
 * @author Prabu
 * Date: 16-Apr-2011
 */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class PC110204_CryptKicker {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110204_CryptKicker solver = new PC110204_CryptKicker();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110204_CryptKicker";
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
    void solve() throws IOException {
        int tc = sc.nextInt();
        sc.nextLine();
        ArrayList<String> dictionary = new ArrayList<String>();

        for(int tci = 1; tci <= tc; tci++) {
            dictionary.add(sc.nextLine());
        }

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tempWords = line.split(" ");
            ArrayList<String> encWords = new ArrayList<String>();
            for(String word: tempWords) {
                if(!encWords.contains(word))
                    encWords.add(word);
            }
            System.out.println("Line: " + encWords);
            Collections.sort(encWords, new StrComparator());
            System.out.println("Line: " + encWords);

            for(int i = 0; i < encWords.size(); i++) {
                
            }
        }
        
        System.out.println(dictionary);
        Collections.sort(dictionary, new StrComparator());
        System.out.println(dictionary);
    }
/******************************************************************************/
}

class StrComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        if(o2.length() != o1.length())
            return o2.length() - o1.length();
        else
            return o2.compareTo(o1);
    }
}
