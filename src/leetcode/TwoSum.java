package leetcode;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] array, int target){

        int[] index = new int[2];
        for (int i = 0; i <array.length ; i++) {
            for (int j = i +1; j <array.length ; j++) {
                if (array[i] + array[j] == target){
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {3, -1, 5, 4};
        System.out.println(Arrays.toString(twoSum(array, 8)));
    }
}
