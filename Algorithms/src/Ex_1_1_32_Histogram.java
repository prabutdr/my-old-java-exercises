
import com.wintech.draw.StdDraw;
import com.wintech.io.StdOut;
import com.wintech.util.ArrayUtil;
import com.wintech.util.StdStats;

/**
 * @author Prabu
 * @date Mar 19, 2012
 */

public class Ex_1_1_32_Histogram {
    public static void main(String[] args) {
        double[] doubles = {0.1, 0.2, 0.5, 0.51, 0.52, 0.6, 0.7, 0.78, 0.79, 0.8, 0.9, 1.0};
        int N = 5;
        double L, R;
        L = 0.5;
        R = 0.8;
        double intervalSize = (R - L) / N;
        int[] count = new int[N];
        StdOut.printf("N:%d\t L:%f\t R:%f\t intervalSize:%f\n", N, L, R, intervalSize);
        for(int i = 0; i < doubles.length; i++) {
            if(doubles[i] < L || doubles[i] >= R) continue;
            StdOut.printf("%d: %d\n", i, (int)((doubles[i] - L)/intervalSize));
            count[(int)((doubles[i] - L)/intervalSize)]++;
        }
        StdOut.print(doubles);
        StdOut.print(count);
        
        StdDraw.setXscale(0, N - 1);
        StdDraw.setYscale(0, StdStats.sum(count));
        //StdDraw.rectangle(N/2.0, StdStats.sum(count) / 2.0, 0.5, .5);
        for(int i = 0; i < count.length; i++) {
            double x = i;
            double y = count[i] / 2.0;
            double rw = 0.48;
            double rh = count[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
