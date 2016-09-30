import org.junit.experimental.theories.internal.BooleanSupplier;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by long.yl on 2016/7/11.
 */
public class App {

	public static void main(String[] args) {
        String lineString = "[02:22.12][00:49.00]一路从泥泞走到了美景";
        String lineString1 = "[02:22][00:49.00]一路从泥泞走到了美景";
        String lineString2 = "[02:22.12]00:49.00]一路从泥泞走到了美景";
        String lineString3 = "[02:22.12[00:49.00]一路从泥泞走到了美景";
        String lineString4 = "[02:22.aa][00:49.aa]一路从泥泞走到了美景";
        String lineString5 = "[02:22.12][00:49.00一路从泥泞走到了美景";
        String lineString6 = "02:22.12][00:49.00]一路从泥泞走到了美景";
        String lineString7 = "[02:22.12][00:493.00]一路从泥泞走到了美景";
        String lineString8 = "[02:22.12][00:09]一路从泥泞走到了美景";
        String lineString9 = "[02:22.12]一路从泥泞走到了美景";
        String lineString10 = "[02:22]一路从泥泞走到了美景";
        System.out.println(lineString + " -=-=-=-=-=- " +lineString.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString1 + " -=-=-=-=-=- " +lineString1.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString2 + " -=-=-=-=-=- " +lineString2.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString3 + " -=-=-=-=-=- " +lineString3.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString4 + " -=-=-=-=-=- " +lineString4.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString5 + " -=-=-=-=-=- " +lineString5.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString6 + " -=-=-=-=-=- " +lineString6.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString7 + " -=-=-=-=-=- " +lineString7.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString8 + " -=-=-=-=-=- " +lineString8.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString9 + " -=-=-=-=-=- " +lineString9.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));
        System.out.println(lineString10 + " -=-=-=-=-=- " +lineString10.matches("^\\[(\\d+):(\\d+).(\\d+)\\].*"));

    }
}
