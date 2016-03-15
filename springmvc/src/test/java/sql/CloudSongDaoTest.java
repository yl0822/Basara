package sql;

import com.basara.dao.CloudSongDao;
import com.basara.dao.SingerDao;
import com.basara.meta.CloudSong;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sql.base.BaseTest;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CloudSongDaoTest extends BaseTest{
    private static org.slf4j.Logger rootLogger = LoggerFactory.getLogger(SingerDaoTest.class);

    @Autowired
    CloudSongDao cloudSongDao;

    @BeforeClass //必须是static的，因为这个会在类实列化之前调用
    public static void beforClass(){
        rootLogger.info("这里可以做一些类初始化之前的操作...........");
    }

    @Before
    public void befor(){
        rootLogger.info("这里可以做一些初始化操作...........");
    }

    @After
    public void after(){
        rootLogger.info("这里可以做一些资源关闭操作...........");
    }

    @Test
    public void insert(){
        CloudSong song = new CloudSong();
        song.setTitle("七里香");
        song.setDuration(254);
        song.setLyrics("");
        song.setSingerId(1);
        song.setTag(1);
        song.setUrl("www");
        System.out.println(cloudSongDao.add(song) > 0 ? "插入成功" : "失败");
    }
}
