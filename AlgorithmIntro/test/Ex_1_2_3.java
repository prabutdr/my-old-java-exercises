/**
 * @author Prabu
 * @date Mar 12, 2012
 */

public class Ex_1_2_3 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        double min = StdIn.readDouble();
        double max = StdIn.readDouble();
        
        Interval2D[] recs = new Interval2D[n];
        double x, y;
        for(int i = 0; i < n; i++) {
            x = StdRandom.uniform();
            y = StdRandom.uniform();
            recs[i] = new Interval2D(new Interval1D(x, x + StdRandom.uniform(min, max)), 
                    new Interval1D(y, y + StdRandom.uniform(min, max)));
            recs[i].draw();
            StdOut.printf("Rectangle-%d: %s\n", i, recs[i]);
            
        }

    }
}
