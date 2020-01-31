
import java.util.Arrays;



/**
 * @author Prabu @date Mar 2, 2012
 */
public class Test {

    /**
     * Euclid’s algorithm
     *
     * Compute the greatest common divisor of two nonnegative integers p and q
     * as follows: If q is 0, the answer is p. If not, divide p by q and take
     * the remainder r. The answer is the greatest common divisor of q and r.
     *
     * @param p
     * @param q
     * @return Greatest common divisor of two nonnegative integers
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, (p % q));
    }

    public static void main(String[] args) {
        /*int[] whitelist = In.readInts("IO/largeW.txt");
        Arrays.sort(whitelist);
        BinaryIn in = new BinaryIn("IO/largeT.txt");
        while (!in.isEmpty()) { // Read key, print if not in whitelist.
            int key = in.readInt();
            if (RP_BinarySearch.rankUsingRecursion(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }*/
        /*System.out.println(Math.abs(-2147483648));
        System.out.println("-14/3: " + (-14/3));
        System.out.println("14/-3: " + (14/-3));
        System.out.println("-14/-3: " + (-14/-3));
        System.out.println("-14%3: " + (-14%3));
        System.out.println("14%-3: " + (14%-3));
        System.out.println("-14%-3: " + (-14%-3));
        System.out.println((0 + 15) / 2);
        System.out.println(1 + 2 + "3");
        
        for(int i = 0; i < 100; i++) {
            System.out.println(i + ": " + F(i));
        }*/
        /*BinaryIn in = new BinaryIn();
        System.out.println("Enter a number: " );
        in.readInt();
        System.out.println("eom");
        Double.parseDouble("10");
        DataInputStream ds;
        BufferedReader buffer;*/
        int[] whitelist = new In("IO/largeW.txt").readInts();
        Arrays.sort(whitelist);
        
        In in = new In("IO/largeT.txt");
        int key, count = 0;
        while(!in.isEmpty()) {
            key = in.readInt();
            if(BinarySearch.rank(key, whitelist) < 0) {
                StdOut.println(key);
                count++;
            }
        }
        StdOut.println("Not found int count: " + count);
        

        
    }
    
    public static long F(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return F(N-1) + F(N-2);
    }
}
