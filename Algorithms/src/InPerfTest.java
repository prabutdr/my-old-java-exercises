
import com.wintech.io.In;

/**
 * @author Prabu
 * @date Mar 17, 2012
 */

public class InPerfTest {
    public static void main(String[] args) {
        String filename = "IO/largeW.txt";
        long startTime = System.currentTimeMillis();
        In in = new In(filename);
        for(int i = 0; i < 100000; i++) {
            System.out.println(in.readInt());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime));
    }
}
