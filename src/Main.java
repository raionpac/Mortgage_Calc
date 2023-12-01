import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Mortgage amount: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate (%): ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Mortgage period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        double totalCostOfMortgage = mortgage * numberOfPayments;

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String totalCostFormatted = currencyFormat.format(totalCostOfMortgage);

        System.out.println("Total cost of mortgage: " + totalCostFormatted);
        System.out.println("Monthly payments: " + mortgageFormatted);
    }
}