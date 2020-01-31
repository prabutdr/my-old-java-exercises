
import com.wintech.io.StdOut;
import com.wintech.util.MathUtil;

/**
 * @author Prabu
 * @date Mar 19, 2012
 */

public class Ex_1_1_30_Array {
    public static void main(String[] args) {
        int N = 10;
        boolean[][] primeMatrix = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(MathUtil.gcd(i, j) != 1) {
                    primeMatrix[i][j] = true;
                }
            }
        }
        StdOut.print(primeMatrix);
    }
}
