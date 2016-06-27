package html.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author long.yl.
 * @Date 2016/6/23
 */
public class HtmlParer {
    public static void main(String[] args) throws Exception{
        File input = new File("D:\\test.html");
        if (!input.exists()){
            input.createNewFile();
        }
        Document doc = Jsoup.parse(input, "UTF-8", "http://www.oschina.net/");

        Element content = doc.getElementById("content");
        Elements links = content.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            System.out.println(linkHref);
            String linkText = link.text();
            System.out.println(linkText);
        }
    }
}
