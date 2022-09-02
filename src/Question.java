

import java.util.Arrays;

public class Question {

    public static int LargestElement(int [] array) {
        int largestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestNumber){
                largestNumber = array[i];
            }
        }
        return largestNumber;
    }

    public static String arrayReverse(int [] array) {
        int [] reverse = new int [array.length];
        int count = 0;
        for (int i = array.length - 1; i >= 0 ; i--) {
            reverse[count] = array[i];
            count++;

        }
        String reverseResult = Arrays.toString(reverse);
        return reverseResult;

    }

    public static boolean iscontains(int [] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number){
                return true;

            }

        }
        return false;
    }


    public static String oddPositionNumbers(int [] array) {
        String values = "";
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0){
                values += array[i];
            }

        }
        return values;


    }

    public static String evenPosition(int[] array) {
        String values = "";
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0){
                values += array[i];
            }

        }
        return values;

    }

    public static boolean isPalindrome(String value) {
        int valueLength = value.length();
        String reverse = "";
        for (int i = valueLength - 1; i >=0 ; i--) {
            reverse += value.charAt(i);
            if (value.equals(reverse)){
                return true;
            }
        }
        return false;
    }


    }

