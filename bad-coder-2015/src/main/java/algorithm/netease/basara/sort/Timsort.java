package algorithm.netease.basara.sort;

import java.util.*;

/**
 * @author long.yl.
 * @Date 2016/1/6
 */
public class Timsort {
    public static void main(String[] args) {
        int[] sample = new int[]
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,1,0,-2,0,0,0,0};
        List<Integer> list = new ArrayList<Integer>();
        for (int i : sample)
            list.add(i);
            // use the native TimSort in JDK 7
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                // miss the o1 = o2 case on purpose
                return o1 > o2 ? 1 : -1;
                //asdasfa
            }
        });
    }
}
