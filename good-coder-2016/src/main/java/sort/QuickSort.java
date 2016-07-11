package sort;

import java.util.Arrays;

/**
 * Created by long.yl on 2016/7/11.
 */
public class QuickSort {
    public static void sort(int[] a){
        for (int i = 0, j = i; i < a.length - 1; j = ++i) {
            int key = a[i + 1];
            while (key < a[j]){
                a[j + 1] = a[j];
                if (j-- == 0)
                    break;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3,46, 4,333, 55,43,2,43,4,5,34,9,20};
        System.out.println(Arrays.toString(a));
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
