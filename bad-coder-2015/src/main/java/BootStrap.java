import tools.netease.basara.ChristmasSockVO;

import java.util.*;

/**
 * @author long.yl.
 */
public class BootStrap {
    public static void main(String[] args) {
        List<ChristmasSockVO> obtainList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ChristmasSockVO vo = new ChristmasSockVO();
            vo.setDate((long)(Math.random() * 1000000000) + 1256849684);
            obtainList.add(vo);
        }
        System.out.println("排序前。。。");
        for (ChristmasSockVO sockVO : obtainList) {
            System.out.println(sockVO);
        }
        System.out.println("排序后。。。");
        sortSockList(obtainList);
        for (ChristmasSockVO sockVO : obtainList) {
            System.out.println(sockVO);
        }
    }
    public static void sortSockList(List<ChristmasSockVO> obtainList){
        Comparator<ChristmasSockVO> comparator = new Comparator<ChristmasSockVO>() {
            @Override
            public int compare(ChristmasSockVO o1, ChristmasSockVO o2) {
                return (int)(o1.getDate() - o2.getDate());
            }
        };
        Collections.sort(obtainList, comparator);
    }
}
