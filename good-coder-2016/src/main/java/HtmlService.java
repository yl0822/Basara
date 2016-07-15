import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬�ļ������һЩ��ݷ���
 *
 * @author Kettas
 *         4:27:25 PM
 */
public class HtmlService {
    private static Log log = LogFactory.getLog(HtmlService.class);

    /**
     * ���html����
     * <p>���а�����'<'��'>'֮�������ȫ�����ᱻ�����,������</P>
     *
     * @param args
     * @return String
     */
    public static String clearHTMLToString(String args) {
        return clearHTMLToString(args, false);
    }

    /**
     * ���html����
     * <p>���а�����'<'��'>'֮�������ȫ�����ᱻ�����,������</P>
     *
     * @param args
     * @param replaceNull �Ƿ��滻�ո���Ʊ��
     * @return String
     */
    public static String clearHTMLToString(String args, boolean replaceNull) {
        if (StringUtils.isEmpty(args)) {
            return "";
        }
        args = args.replaceAll("(?is)<(.*?)>", "");
        if (replaceNull) {
            args = args.replaceAll("\\s*|\t|\r|\n", "");
        }
        return args;
    }

    /**
     * ���html����
     * <p>���а�����'<'��'>'֮�������ȫ�����ᱻ���������ָ�����صĳ���</P>
     *
     * @param args
     * @return String
     */
    public static String clearHTMLToString(String args, int maxSize) {
        return clearHTMLToString(args, maxSize, "");
    }

    /**
     * ���html����
     * <p>���а�����'<'��'>'֮�������ȫ�����ᱻ���������ָ�����صĳ���</P>
     *
     * @param args
     * @return String
     */
    public static String clearHTMLToString(String args, int maxSize, String replace) {
        args = clearHTMLToString(args);
        if (maxSize <= 0) {
            return args;
        }
        if (args.length() <= maxSize) {
            return args;
        }
        return args.substring(0, maxSize).concat(replace);
    }

    /**
     * ���ַ�����ȡָ������
     *
     * @param args
     * @param maxSize
     * @param replace
     * @return String
     */
    public static String clearHTMLToSize(String args, int maxSize, String replace) {
        if (args.length() <= maxSize) {
            return args;
        }
        return args.substring(0, maxSize).concat(replace);
    }
// /**
//  * ��css��ʽ�ļ��ж�ȡ<Style>��ʽ
//  * @return String
//  */
// public static  String getStyleToString(File file){
//  Document doc=null;
//  Elements fileList=null;
//  try{
//   doc = Jsoup.parse(file, Config.DEFAULT_TYPE);
//   fileList=doc.select("style");
//   String css= doc.data();
//   if(css.length()<1){
//    return css;
//   }
//   /*
//    * ���˵�ע�����
//    */
//   css=css.replaceAll("(<[^>]*>)", "");
//   return css;
//  }catch (Exception e) {
//   log.error(e);
//  }finally{
//   doc=null;
//   fileList=null;
//  }
//  return "";
// }
// /**
//  * ��css��ʽ�ļ��ж�ȡ<Style>��ʽ
//  * @return Map<String,String>
//  */
// public static  Map<String,String> getStyleToMap(File file){
//  Map<String, String> css=new HashMap<String, String>();
//  try{
//   String cssStyle=getStyleToString(file);
//   if(cssStyle.trim().length()<1){
//    return css;
//   }
//   /*
//    *
//    */
//   String[] style=cssStyle.split("\\}");
//   String[] map=new String[2];
//   for (String _style : style) {
//    map=_style.split("\\{");
//    css.put(map[0],map[1]);
//   }
//   return css;
//  }catch (Exception e) {
//   log.error(e);
//  }
//  return css;
// }

    /**
     * ��style��ʽ�ж�ȡCSS������
     * <pre>
     * String style="float:left;margin:0px;font-size:12px;";
     * String fontSize=HTMLServices.getStyleNameValue(style,"font-size");</pre>
     *
     * @param style
     * @param styleName
     * @return String
     */
    protected static String getStyleToString(String style, String styleName) {
        try {
            Map<String, String> css = cssToMap(style);
            return css.get(styleName);
        } catch (Exception e) {
            log.error(e);
        }
        return "";
    }

    public static String filterChare(String msg, String... chars) {
        for (String _char : chars) {
            msg = msg.replace(_char, "");
        }
        return msg;
    }

    public static String mapToCSS(Map<String, String> css) {
        StringBuffer style = new StringBuffer();
        for (Map.Entry<String, String> entry : css.entrySet()) {
            style.append(style.length() > 0 ? "," : "");
            style.append(entry.getKey()).append(":").append(entry.getValue());
        }
        return style.toString();
    }

    /**
     * ��style��װ�ɼ�ֵ��
     * <pre>
     * String style="float:left;margin:0px;font-size:12px;";
     * Map<String,String> css=HTMLServices.getStyleToMap(style);
     * System.out.println("font-size:"+css.get("font-size"));
     * </pre>
     *
     * @param style
     * @return Map
     */
    public static Map<String, String> cssToMap(String style) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            if (style == null || StringUtils.isEmpty(style)) {
                return map;
            }
            style = style.toLowerCase();
            style = style.split("\\}")[0];
            String[] csss = style.split("\\;");
            for (int i = 0, iSzie = csss.length; i < iSzie; i++) {
                String[] cssStyle = csss[i].split("\\:");
                for (int j = 0, jSize = cssStyle.length; (j + 1) < jSize; j += 2) {
                    map.put(cssStyle[j].replace(" ", "").trim(), cssStyle[j + 1].toString().trim());
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return map;
    }
// /**
//  * ��css��ʽ�ж�ȡcssName������(ע�⣬css�Ǳ�׼css)
//  * @param css
//  * @param cssName
//  * @param styleName
//  * @return String
//  */
// public static  String getStyleNameValue(File file,String cssName,String styleName){
//  try{
//   String style=getStyleToMap(file).get(cssName);
//   return getStyleNameValue(style, styleName);
//  }catch (Exception e) {
//   log.error(e);
//  }
//  return "";
// }

}