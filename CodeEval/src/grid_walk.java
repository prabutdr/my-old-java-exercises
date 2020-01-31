/**
 * @author Prabu
 * @date Feb 26, 2012
 */

public class grid_walk {
    public static void main(String[] args) {
        final int NINETEEN = 19;
        int totalPoints = 0; 
        int maxPointForNineteen = maxPointForSumOfDigit(NINETEEN);
        for(int i = 0; i < maxPointForNineteen; i++) {
            totalPoints = totalPoints + maxPointForSumOfDigit(NINETEEN - sumOfDigits(i));
            System.out.printf("(%d, %d): %d\n", i, //NINETEEN - sumOfDigits(i), 
                    maxPointForSumOfDigit(NINETEEN - sumOfDigits(i)), totalPoints);
        }
        totalPoints = (totalPoints * 4) + 1; // four axis plus (0, 0)
        System.out.print(totalPoints);
        System.exit(0);
    }
    
    private static int sumOfDigits(int n) {
        if(n < 0) { //make it positive
            n = n * -1;
        }
        if(n < 10) { //single digit
            return n;
        }
        
        int sum = 0;
        do {
            sum = sum + (n % 10);
            n = n / 10;
        }
        while(n != 0);
        
        return sum;
    }
    
    private static int maxPointForSumOfDigit(int n) {
        final int NINE = 9;
        
        if(n < NINE)
            return n;
        
        n = n + 1;
        int decPlace = 1;
        int maxPoint = 0;
        
        while(n > NINE) {
            maxPoint = maxPoint + (NINE * decPlace);
            decPlace = decPlace * 10;
            n = n - NINE;
        }
        maxPoint = maxPoint + (n * decPlace);
        return maxPoint - 1;
    }
}
