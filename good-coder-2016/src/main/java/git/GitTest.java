package git;

/**
 * Created by long.yl Created in 2016/11/1 Created on Basara_git
 */
public class GitTest {
	public static void main(String[] args) throws Exception {
		GitBash gb = GitBash.getInstance("D:\\gitRepo\\自己玩\\Basara\\.git");
        // 获取分支sha1值
		System.out.println(gb.getHeadSHA1Code("master"));
        // 获取git配置项
        System.out.println(gb.getConfig("user", "name"));
        System.out.println(gb.getConfig("user", "email"));
        System.out.println(gb.getConfig("core", "quotepath"));
        System.out.println(gb.getConfig("alias", "lg"));
        System.out.println(gb.getConfig("alias", "st"));
    }
}
