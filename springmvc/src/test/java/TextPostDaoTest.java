import ch.qos.logback.classic.Logger;
import com.basara.dao.TextPostDao;
import com.basara.enums.PostTag;
import com.basara.meta.TextPost;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public class TextPostDaoTest {

    private static org.slf4j.Logger rootLogger = LoggerFactory.getLogger(TextPostDaoTest.class);

    @Autowired
    TextPostDao textPostDao;

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
        TextPost post = new TextPost();
        post.setTitle("两会释放明确用人信号：这3种官员将被重用！");
        post.setContent("心提示：人民日报：有老少边穷地区任职经历的讲真话的改革促进派党员干部将会被重用。\n" +
                "\n" +
                "原标题：两会释放明确用人信号：这三种干部将被重用！\n" +
                "\n" +
                "每年两会，都是外界观察中国政治走向的风向标。而广受关注的干部任用问题，在两会伊始就已被中央高层多次提及。我们梳理出中央三大用人信号，大家对号入座一下，看看升迁道路上，有你吗？\n" +
                "\n" +
                "信号1：重用改革促进派\n" +
                "\n" +
                "\n" +
                "\n" +
                "3月7日，习近平参加黑龙江代表团的审议\n" +
                "\n" +
                "3月7日，习近平在黑龙江代表团参加审议时强调，“干部干部，干是当头的，既要想干愿干积极干，又要能干会干善于干，其中积极性又是首要的”。要“真正把那些想干事、能干事、敢担当、善作为的优秀干部选拔到各级领导班子中来。”\n" +
                "\n" +
                "在政府工作报告中，李克强直言，要“给改革创新者撑腰鼓劲”；俞正声在湖北代表团参加审议时表示，要“鼓励各级干部愿干事、敢干事、能干成事”；刘云山在内蒙古代表团参加审议时指出，“推动形成想作为、敢作为、善作为的良好风尚”；谈起干事创业，王岐山在北京代表团参加审议时强调，“真正敢于担当，就没有过不去的坎儿、战胜不了的困难。”\n" +
                "\n" +
                "今年是“十三五”开局之年，也是全面建成小康社会决胜阶段的开局之年。万事开头难，开局之年更需广大干部真抓实干。中央选人用人的指挥棒已经非常明确，可以预见，今后，那些想干事、能干事、敢担当、善作为的领导干部将更多获得重用。\n" +
                "\n" +
                "信号2：重用讲真话的党员干部\n" +
                "\n" +
                "诚然，现实工作中存在这样一种现象，有的党员干部面对实质问题不讲真话，只讲正确的废话、漂亮的空话、严谨的套话，要么虚报浮夸、避重就轻，要么闭口不谈、报喜不报忧，这些现象值得我们深思。\n" +
                "\n" +
                "而在今年政协开幕会上，俞正声主席一句“鼓励对党和政府工作的批评和建议，支持反映人民群众愿望和诉求的呼声，鼓励不同意见的交流和讨论，支持讲真话、道实情”，着实让人精神一振。\n" +
                "\n" +
                "说真话，成为评判干部的重要标准之一。\n" +
                "\n" +
                "而这两天，习近平在参加民建工商联委员联组会的讨论时，再一次强调了“讲真话、说实情”，充分表达了当下对于党员干部的期许。\n" +
                "\n" +
                "其实，习近平在多个场合都提到过“讲真话”的问题。\n" +
                "\n" +
                "2014年6月30日，习近平在中央政治局关于加强改进作风制度建设的第十六次集体学习会议中指出，领导干部在严格按党纪国法办事的基础上，要坚守正道、弘扬正气，坚持以信念、人格、实干立身；要襟怀坦白、光明磊落，对上对下讲真话、实话。\n" +
                "\n" +
                "2015年12月31日，习近平在全国政协礼堂举行的新年茶话会上谈到，人民政协要建真言、谋良策、出实招，为全面建成小康社会、加快推进社会主义现代化作出新的更大贡献。\n" +
                "\n" +
                "习近平也批评过“好人主义”，他说，“好人主义盛行，有问题不指出，有过错不批评，这种庸俗作风盛行之处，往往就是党组织和领导上政治软弱、作风涣散的地方，就是党员、干部中出问题多的地方。”\n" +
                "\n" +
                "信号3：重视有老少边穷地区的任职经历\n" +
                "\n" +
                "习近平曾说：“越是艰苦的环境，越能磨炼干部的品质，考验干部的毅力。”3月8日上午，习近平总书记参加湖南代表团审议，再次将“精准扶贫”作为重中之重。他提出明确要求：“抓工作不能狗熊掰棒子，去过的每个地方都要抓反馈。”\n" +
                "\n" +
                "\n" +
                "\n" +
                "习近平参加十二届全国人大四次会议湖南代表团的审议\n" +
                "\n" +
                "可见，在“十三五”全面奔小康期间，谁能在基层将精准扶贫的硬任务顺利拿下，谁就给为官之路打下了坚实的基础。\n" +
                "\n" +
                "习近平年轻时在陕西梁家河大队度过了7年艰苦的上山下乡生活，在最贫困的地区同老百姓同吃同睡，这对他的个人成长起着非常重要的作用。\n" +
                "\n" +
                "\n" +
                "\n" +
                "在送习近平上大学时，梁家河村民和习近平的合影（前排中为习近平）\n" +
                "\n" +
                "大学毕业后，他又自愿放弃京城优越舒适的工作，主动要求到当时典型的贫困县——河北正定县锻炼，那三年成为他仕途的重要起点。\n" +
                "\n" +
                "小编发现，与习近平一样，很多党和国家的领导人都曾在艰苦地区工作。现任25位中共中央政治局委员中，至少有8位都在老少边穷省份待过：\n" +
                "\n" +
                "①刘云山曾在内蒙古干了20多年，期间，为调研农村思想政治工作，他独自一人坐火车、乘汽车、搭拖拉机，进农家、住帐篷，与农牧民群众促膝谈心；\n" +
                "\n" +
                "②刘奇葆从2000年开始辗转广西、四川，2012年成为政治局委员、中央书记处书记；\n" +
                "\n" +
                "③现任政法委书记孟建柱在成为公安部长前在江西有过6年的主政经历；\n" +
                "\n" +
                "④在青海度过了大半辈子的赵乐际于2012年出任中央组织部部长；\n" +
                "\n" +
                "⑤现任广东省委书记胡春华，在西藏、内蒙古两个省份时间超过20年；\n" +
                "\n" +
                "⑥栗战书在贵州有过两年的主政经验；\n" +
                "\n" +
                "⑦现任北京市委书记郭金龙在四川、西藏任职34年后，调任安徽省委书记，并在之后担任北京市长、市委书记。");
        post.setAuthName("long.yl@corp.netease.com");
        post.setCreateTime(new Date());
        post.setTag(PostTag.POLITCAL.getIntValue());
        System.out.println(textPostDao.addObject(post));
    }

    @Test
    public void getById(){
        TextPost post = textPostDao.getObjectById(2);
        rootLogger.info(post.getTitle());
    }

    @Test
    public void deleteById(){
        System.out.println(textPostDao.deleteObjectById(2));
    }

    @Test
    public void update(){
        TextPost post = textPostDao.getObjectById(3);
        post.setAuthName("yanglong");
        System.out.println(textPostDao.updateTitle(post));
    }
}
