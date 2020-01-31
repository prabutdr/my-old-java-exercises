
/**
 * @author Prabu
 * @date Mar 8, 2012
 */

public class Flip {
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        
        for(int i = 0; i < t; i++) {
            if(StdRandom.bernoulli(0.5)) {
                heads.increment();
            }
            else {
                tails.increment();
            }
        }
        System.out.println(heads);
        System.out.println(tails);
        
        int delta = heads.tally() - tails.tally();
        System.out.println("Delta: " + Math.abs(delta));
    }
}
