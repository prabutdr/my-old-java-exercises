
import com.wintech.draw.StdDraw;
import com.wintech.io.StdOut;
import com.wintech.util.StdRandom;
import java.awt.Font;
import java.util.Arrays;

/**
 * @author Prabu
 * @date Mar 18, 2012
 */

public class PlotDrawDemo {
    public static void main(String[] args) {
        /*int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(0.01);
        for(int i = 0; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }*/
        
        int N = 50;
        double[] a = new double[N];
        for(int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }
        StdOut.print(a);
        StdDraw.setPenRadius(0.002);
        StdOut.println(StdDraw.getPenRadius());
        //Arrays.sort(a);
            double rw = 0.3 / N;
            StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 8));
        for(int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            StdOut.println(x + " " + y + " " + rw + " " + rh);
            StdDraw.text(x, y * 2 + 0.01, String.format("%.2f", y));
        }
    }
}
