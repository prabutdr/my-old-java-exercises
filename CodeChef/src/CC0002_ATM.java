/*
 * All submissions for this problem are available.

Pooja would like to withdraw X $US from an ATM. The cash machine will only accept the transaction if X is a multiple of 5, and Pooja's account balance has enough cash to perform the withdrawal transaction (including bank charges). For each successful withdrawal the bank charges 0.50 $US.

Calculate Pooja's account balance after an attempted transaction.

Input

Positive integer 0 < X <= 2000 - the amount of cash which Pooja wishes to withdraw.

Nonnegative number 0<= Y <= 2000 with two digits of precision - Pooja's initial account balance.

Output

Output the account balance after the attempted transaction, given as a number with two digits of precision. If there is not enough money in the account to complete the transaction, output the current bank balance.

Example - Successful Transaction
 Input:
30 120.00

Output:
89.50

 Example - Incorrect Withdrawal Amount (not multiple of 5)
 Input:
42 120.00

Output:
120.00

 Example - Insufficient Funds
 Input:
300 120.00

Output:
120.00

 */

/**
 *
 * @author Prabu
 * @date 06-Apr-2011
 */
import java.io.*;
import java.util.*;

public class CC0002_ATM {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CC0002_ATM solver = new CC0002_ATM();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CC0002_ATM";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    /*
    void solve() throws IOException {
        int withdrawAmount = sc.nextInt();
        double accountBalance = sc.nextDouble();
        float tranFee = 0.50f;

        //withdrawAmount += tranFee;
        if(withdrawAmount%5 == 0 && (withdrawAmount + tranFee) <= accountBalance)
            accountBalance -= (withdrawAmount + tranFee);

        out.printf("%.2f", accountBalance);
    }
    */

    void solve() throws IOException {
        int withdrawAmount = sc.nextInt();
        double accountBalance = sc.nextDouble();
        float totalWithdraw = withdrawAmount + 0.50f;

        //withdrawAmount += tranFee;
        if(withdrawAmount%5 == 0 && totalWithdraw <= accountBalance)
            accountBalance -= totalWithdraw;

        out.printf("%.2f", accountBalance);
    }

/******************************************************************************/
}

