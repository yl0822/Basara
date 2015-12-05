package algorithm.netease.basara.lottery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author long.yl.
 */
public class GaiLvTest {
    public static void main(String[] args) {
        int allCount = 10000;
        double x = 100.0;
        List<String> randomStrList = new ArrayList<>(1000);
        List<Integer> localTypeList = new ArrayList<>(1000);
        List<Integer> sockTypeList = new ArrayList<>(1000);
        int localCount1 = 0;
        int localCount2 = 0;
        int localCount3 = 0;
        int localCount4 = 0;
        int localCount5 = 0;
        int localCount6 = 0;

        int sockCount1 = 0;
        int sockCount2 = 0;
        int sockCount3 = 0;
        int sockCount4 = 0;
        int sockCount5 = 0;
        int sockCount6 = 0;
        int sockCount7 = 0;
        int sockCount8 = 0;
        int sockCount9 = 0;
        int sockCount10 = 0;
        int sockCount11 = 0;
        int sockCount12 = 0;

        for (int i = 0; i < allCount; i++) {
            sockTypeList.add(ChristmasConfig.getSockType().getIntValue());
            localTypeList.add(ChristmasConfig.getLocalType().getIntValue());
        }

        for (Integer integer : localTypeList) {
            switch (integer){
                case 20:localCount1++;break;
                case 21:localCount2++;break;
                case 22:localCount3++;break;
                case 23:localCount4++;break;
                case 24:localCount5++;break;
                case 25:localCount6++;break;
            }
        }

        for (Integer integer : sockTypeList) {
            switch (integer){
                case 1:sockCount1++;break;
                case 2:sockCount2++;break;
                case 3:sockCount3++;break;
                case 4:sockCount4++;break;
                case 5:sockCount5++;break;
                case 6:sockCount6++;break;
                case 7:sockCount7++;break;
                case 8:sockCount8++;break;
                case 9:sockCount9++;break;
                case 10:sockCount10++;break;
                case 11:sockCount11++;break;
                case 12:sockCount12++;break;
            }
        }
        System.out.println("各奖项概率如下：");
        System.out.println("满99减9优惠券:"+(sockCount1 / 100.0)+"%");
        System.out.println("满199减16优惠券:"+(sockCount2 / x)+"%");
        System.out.println("满399减27优惠券:"+(sockCount3 / x)+"%");
        System.out.println("满499减36优惠券:"+(sockCount4 / x)+"%");
        System.out.println("满99减90优惠券:"+(sockCount5 / x)+"%");
        System.out.println("满599减500优惠券:"+(sockCount6 / x)+"%");
        System.out.println("1元红包:"+(sockCount7 / x)+"%");
        System.out.println("2元红包:"+(sockCount8 / x)+"%");
        System.out.println("3元红包:"+(sockCount9 / x)+"%");
        System.out.println("5元红包:"+(sockCount10 / x)+"%");
        System.out.println("麋鹿:"+(sockCount11 / x)+"%");
        System.out.println("旅行箱:"+(sockCount12 / x)+"%");
        System.out.println("地推如下：");
        System.out.println("满19减10优惠券:"+(localCount1 / x)+"%");
        System.out.println("满29减15优惠券:"+(localCount2 / x)+"%");
        System.out.println("满39减20优惠券:"+(localCount3 / x)+"%");
        System.out.println("满99减50优惠券:"+(localCount4 / x)+"%");
        System.out.println("满199减100优惠券:"+(localCount5 / x)+"%");
        System.out.println("500元无门槛券:"+(localCount6 / x)+"%");


        System.out.println("获取随机字符串测试:");
        System.out.println(ChristmasConfig.genRandomStr());
        System.out.println("获取开始时间戳测试:");
        System.out.println(ChristmasConfig.getDayStartTime());
        System.out.println("获取结束时间戳测试:");
        System.out.println(ChristmasConfig.getDayEndTime());
        System.out.println("活动四天的限定奖品比例3:3:3:1");
        System.out.println(ChristmasConfig.getMaxCountInDay(1000));
        System.out.println("获取调用JSSDK的凭证:");
        System.out.println(ChristmasConfig.getTicket());
        System.out.println("获取随机抽奖类型:");
        System.out.println(ChristmasConfig.getSockType().getDesc());
        System.out.println("地推活动抽奖规则:");
        System.out.println(ChristmasConfig.getLocalType().getDesc());
    }
}
