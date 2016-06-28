package dasouche.interview;

import java.util.Arrays;

/**
 * @author long.yl.
 * @Date 2016/6/27
 */
public class App {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints2 = {1, 3, 35, 43, 25, 136, 37, 33, 28, 19};
        System.out.println(Arrays.toString(sort(ints)));
        System.out.println(Arrays.toString(sort(ints2)));
    }

    public static int[] sort(int[] ints){
        int[] newInts = new int[ints.length];
        int evenCount = getEvenNumberCount(ints);
        int t = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 == 0){
                newInts[evenCount - 1 + i - t] = ints[i];
                t++;
            }else {
                newInts[i - t] = ints[i];
            }
        }
        return newInts;
    }
    private static int getEvenNumberCount(int[] ints){
        int count = 0;
        for (int anInt : ints) {
            if (anInt % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
