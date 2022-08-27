package hackerRank;

import java.util.Scanner;

public class Day9 {
        public static final Scanner sc= new Scanner(System.in);
        // Complete the factorial function below.
        static int factorial(int number) {
            if(number<=1){
                return 1;
            }
            else{
                return number * factorial(number-1);
            }
        }
        public static void main(String agrs[]){
            System.out.println("Enter number to get it's factors: ");
            int fac=sc.nextInt();
            System.out.println(factorial(fac));
        }
}
