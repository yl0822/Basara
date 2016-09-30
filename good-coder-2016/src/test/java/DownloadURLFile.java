import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * Created by long.yl
 * Created in 2016/9/27
 * Created on Basara_PACKAGE_NAME
 */
public class DownloadURLFile {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String res = downloadFromUrl("http://paopao.nosdn.127.net/9b853d6d-12c1-41f2-aab3-f0cd534e8586.apk","d:/");
        System.out.println(res);
    }


    public static String downloadFromUrl(String url,String dir) {
        try {
            URL httpurl = new URL(url);
            String fileName = getFileNameFromUrl(url);
            System.out.println(fileName);
            File f = new File(dir + fileName);
            FileUtils.copyURLToFile(httpurl, f);
            System.out.println(f.length());
        } catch (Exception e) {
            e.printStackTrace();
            return "Fault!";
        }
        return "Successful!";
    }

    public static String getFileNameFromUrl(String url){
        String name = new Long(System.currentTimeMillis()).toString() + ".X";
        int index = url.lastIndexOf("/");
        if(index > 0){
            name = url.substring(index + 1);
            if(name.trim().length()>0){
                return name;
            }
        }
        return name;
    }
}
