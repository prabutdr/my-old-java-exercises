/**
 * @author Prabu
 * @date Mar 8, 2012
 */

public class Rolls {
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);      // Number of try
        int SIDES = 6;                          // Number of sides
        Counter[] counter = new Counter[SIDES];
        
        for(int i = 0; i < SIDES; i++) {
            counter[i] = new Counter((i + 1) + "'s");    // Initialze each counter
        }
        
        // Count side at random
        int side;
        for(int i = 0; i < t; i++) {
            side = StdRandom.uniform(0, SIDES);
            counter[side].increment();
        }
        
        // print results
        for(int i = 0; i < SIDES; i++) {
            System.out.println(counter[i]);
        }
        
    }
}
