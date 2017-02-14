import java.io.Console;
import java.util.Scanner;

/**
 * @Author:long.yl
 * @Date:2017/1/23
 * @Package:PACKAGE_NAME
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入名称:");
        String str = scanner.next();
        System.out.println("你的名称是:" + str);
    }
}
