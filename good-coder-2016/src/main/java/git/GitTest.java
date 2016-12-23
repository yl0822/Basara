package git;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by long.yl Created in 2016/11/1 Created on Basara_git
 */
public class GitTest {
    private GitBash bash;

    @Before
    public void init(){
        bash = GitBash.getInstance("D:\\gitRepo\\自己玩\\Basara\\.git");
    }

    @Test
    public void getSha1(){
        // 获取分支sha1值
        System.out.println(bash.getHeadSHA1Code("master"));
    }

    @Test
    public void getConfig(){
        // 获取git配置项
        System.out.println(bash.getConfig("user", "name"));
        System.out.println(bash.getConfig("user", "email"));
        System.out.println(bash.getConfig("core", "quotepath"));
        System.out.println(bash.getConfig("alias", "lg"));
        System.out.println(bash.getConfig("alias", "st"));
    }

    @Test
    public void createBranch(){
        // 创建分支
        bash.createBranch("master", "release1");
    }

    @Test
    public void deleteBranch(){
        // 创建分支
        bash.deleteBranch("master");
    }

    @Test
    public void diff(){
        // 创建分支
        bash.diff("master");
    }

    @Test
    public void load(){
        // 创建分支
        bash.load();
    }
}
