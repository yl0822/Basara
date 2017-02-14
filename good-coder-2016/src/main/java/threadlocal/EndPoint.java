package threadlocal;

/**
 * @Author:long.yl
 * @Date:2017/1/23
 * @Package:com.netease.basara
 * @Desc:抽象出连接对象
 */
public class EndPoint {

	public static void set() {
		ThreadLocal<Long> num = new ThreadLocal<>();
		num.set(5L);
	}
}
