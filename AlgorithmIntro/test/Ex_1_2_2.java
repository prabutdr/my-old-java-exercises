/**
 * @author Prabu
 * @date Mar 12, 2012
 */

public class Ex_1_2_2 {
    public static void main(String[] args) {
        int N = 5;
        
        Interval1D[] intervals = new Interval1D[N];
        for(int i = 0; i < N; i++) {
            intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
            StdOut.printf("Interval-%d: %s\n", i, intervals[i]);
            for(int j = i - 1; j >= 0; j--) {
                if(intervals[i].intersects(intervals[j])) {
                    StdOut.printf("Intervals %s and %s are intersects.\n", 
                            intervals[i], intervals[j]);
                }
            }
        }
    }
}
