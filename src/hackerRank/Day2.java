import java.util.*;
//Meal calculator, this application take in three input
// cOst of mean
// Tip percentage
// Tax percentage
//Then sum them all
public class Day2 {
        // Complete the solve function below.
        static void solve(double mealCost, int tipPercent, int taxPercent)
        {
            double tip=mealCost*tipPercent/100;
            double tax=mealCost*taxPercent/100;
            int totalCost=(int)Math.round(mealCost+tip+tax);
            System.out.print(totalCost);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            double mealCost = scanner.nextDouble();
            System.out.println("Enter Meal cost: ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int tipPercent = scanner.nextInt();
            System.out.println("Enter Tip Percentage: ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int taxPercent = scanner.nextInt();
            System.out.println("Enter Tax Percentage: ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            solve(mealCost, tipPercent, taxPercent);

            scanner.close();
        }
}

