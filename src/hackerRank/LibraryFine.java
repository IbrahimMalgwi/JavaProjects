package hackerRank;

import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int day = input.nextInt();
            int month = input.nextInt();
            int year = input.nextInt();
            int dayExpected = input.nextInt();
            int monthExpected = input.nextInt();
            int yearExpected = input.nextInt();
            int fine = 0;

            if(year > yearExpected){
                fine = 10000;
            }else if(year == yearExpected && month > monthExpected){
                fine = (month - monthExpected) * 500;
            }else if(year == yearExpected && month == monthExpected && day > dayExpected){
                fine = (day - dayExpected) * 15;
            }
            System.out.println(fine);
    }
}

