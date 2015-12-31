import com.alibaba.fastjson.JSON;
import org.junit.Test;
import others.IosVersionConfigVO;
import others.UnitVO;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author long.yl.
 */
public class ToolsTest {


    @Test
    public void iosVersionTest(){
        List<IosVersionConfigVO> list = new ArrayList<>();
        IosVersionConfigVO versionConfigVO = new IosVersionConfigVO("2.1.2", 1, 2, 3, "url://", "a3654asd4we61f496841");
        IosVersionConfigVO versionConfigVO2 = new IosVersionConfigVO("2.1.3", 1, 2, 3, "url://", "swd5egrg46re498g4e964g");
        list.add(versionConfigVO);
        list.add(versionConfigVO2);
        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
    }

    @Test
    public void readIosVersionTest(){
        String path = "D:\\gitRepo\\Basara\\bad-coder-2015\\src\\main\\resources\\config.json";
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null){
                sb.append(temp);
            }
            List<IosVersionConfigVO> list = new ArrayList<>(JSON.parseArray(sb.toString(), IosVersionConfigVO.class));
            for (IosVersionConfigVO versionConfigVO : list) {
                System.out.println(versionConfigVO);
            }
        }catch (FileNotFoundException e){
            System.out.println("文件不存在");
        }catch (Exception e){
            System.out.println("读取文件出错");
            e.printStackTrace();
        }
    }

    @Test
    public void readUnitTest(){
        String path = "D:\\gitRepo\\Basara\\bad-coder-2015\\src\\main\\resources\\unit.json";
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null){
                sb.append(temp);
            }
            String jasonUnitContent = sb.toString();
            try {
                UnitVO christmasUnitVO = JSON.parseObject(jasonUnitContent, UnitVO.class);
                for (UnitVO.Unit unit1 : christmasUnitVO.getList()) {
                    if (unit1.getId() == 7){
                        String actId = "&fromId=5as4f654sgf456w4";
                        unit1.setLinkUrl(unit1.getLinkUrl() + actId);
                    }
                }
                jasonUnitContent = JSON.toJSONString(christmasUnitVO);
                System.out.println(jasonUnitContent);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("进入圣诞主会场解析失败");
            }
        }catch (FileNotFoundException e){
            System.out.println("文件不存在");
        }catch (Exception e){
            System.out.println("读取文件出错");
            e.printStackTrace();
        }
    }

    @Test
    public void bigDecimalTest(){
        BigDecimal decimal = new BigDecimal("0.00333");
        System.out.println(decimal.setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue());
    }
}
