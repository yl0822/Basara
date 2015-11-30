package tools.netease.basara;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author long.yl.
 */
public class TimeBasara {
    /**
     * ʱ�䡢������ع�����
     * */
    public static void main(String[] args) {
        //test
        String str1 = TimeBasara.getTimeByMillisTime(1448866427214L);
        System.out.println(str1);
        //test
    }

    /** ��long��ʱ���ת�������� */
    public static String getTimeByMillisTime(long millisTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(millisTime));
    }
}
