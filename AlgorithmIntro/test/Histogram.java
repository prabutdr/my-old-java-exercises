import java.util.Arrays;

/**
 * @author Prabu @date Mar 3, 2012
 */
public class Histogram {

    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0 && a[i] < M) {
                result[a[i]]++;
            }
        }
        return result;
    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }
    public static int mystery1(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery(a * a, b / 2);
        }
        return mystery(a * a, b / 2) + a;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 8, 2, 9, 4};

        System.out.println("histogram(array, 5): " + Arrays.toString(histogram(array, 5)));
        System.out.println("histogram(array, 10): " + Arrays.toString(histogram(array, 10)));
        
        System.out.println("mistery(2, 25): " + mystery(2, 25));
        System.out.println("mistery(3, 11): " + mystery(10, 110));
        System.out.println("mistery1(2, 25): " + mystery1(2, 25));
        System.out.println("mistery1(3, 11): " + mystery1(3, 11));
    }
}
