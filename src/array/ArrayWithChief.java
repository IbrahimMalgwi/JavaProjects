package array;

import java.util.Arrays;

public class ArrayWithChief {
    public static void main(String[] args) {
        array1();
    }

    public static void array1(){
        int[] f = new  int[6];
        for (int i = 0; i < f.length; i++)
        {
            System.out.println(i);
        }
    }

    public static void array2(){
        int [] g = {8,8,8,8,8,8,8,8,};
    }

    public static void array3(){
        float [] c = new float[100];

        float total = 0;
        for (int i = 0; i < 99; i++);
        total = total ++;
    }

    public static void array4(){
        int [] a = {11, 21, 3, 7, 60, 8, 10, 19, 18, 43, 57};
        int [] b = new int[34];

        for (int i = 0; i < 11; i++)

            System.arraycopy(a,0, b, 0, 11);

        System.out.println(Arrays.toString(b));
    }

    public static void array5(){
        float[] w = new float[99];
    }

    public static void array6(){}
}


