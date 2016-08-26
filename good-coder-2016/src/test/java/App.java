import org.apache.commons.lang3.StringUtils;

/**
 * Created by long.yl on 2016/7/11.
 */
public class App {

	public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("   ".trim()));

        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank("   "));
    }
}
