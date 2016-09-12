package sperateoddevenarrray;

import java.util.Arrays;

/**
 * Created by long.yl
 * Created in 2016/9/12
 * Created on Basara_sperateoddevenarrray
 */
public class Sperater {
    public static void main(String[] args) {
        int[] ints = { 16, 2, 4, 12, 5, 7, 8, 10, 11, 22, 24, 28};
//        int count = getOddCount(ints);
//        for (int i = 0; i < count; i++) {
//            if (ints[i] % 2 == 0){
//                switch2LastIndex(ints, i);
//            }
//        }
        order(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static int getOddCount(int[] ints){
        int count = 0;
        for (int anInt : ints) {
            if (anInt % 2 != 0){
                count++;
            }
        }
        return count;
    }

    public static void switchInts(int[] ints, int index1, int index2){
        int temp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = temp;
    }

    public static void switch2LastIndex(int[] ints, int index1){
        for (int i = index1; i+1 < ints.length; i++) {
            switchInts(ints, i, i+1);
        }
    }

    public static boolean isEven(int n){
        return (n & 1) == 0;
    }


    public static void order(int[] arr){
        if(arr == null)
            return;
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(isEven(arr[i]) && !isEven(arr[j])){
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }
            else if(!isEven(arr[i]) && !isEven(arr[j])){
                i++;
            }
            else if(isEven(arr[i]) && isEven(arr[j])){
                j--;
            }else{
                i++;
                j--;
            }
        }
    }
}
