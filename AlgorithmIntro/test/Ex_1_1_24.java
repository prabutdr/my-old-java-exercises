/**
 * @author Prabu
 * @date Mar 8, 2012
 */

public class Ex_1_1_24 {
    public static int gcd(int a, int b) {
        System.out.printf("(%d, %d)\n", a, b);
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        System.out.println("gcd(5, 9): " + gcd(5, 9));
        System.out.println("gcd(4, 2): " + gcd(4, 2));
        System.out.println("gcd(1111111, 1234567): " + gcd(1111111, 1234567));
    }
}
