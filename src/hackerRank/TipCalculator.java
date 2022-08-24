package hackerRank;

import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class TipCalculator {
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
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int tipPercent = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int taxPercent = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            solve(mealCost, tipPercent, taxPercent);

            scanner.close();
        }
}
