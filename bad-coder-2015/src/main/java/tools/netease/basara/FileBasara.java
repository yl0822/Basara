package tools.netease.basara;

import java.io.*;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public class FileBasara {

    public static String getStringFromFile(String filePath) {
        String result = "";
        try (InputStream inputStream = new FileInputStream(new File(filePath));
             ByteArrayOutputStream out = new ByteArrayOutputStream()){
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                out.flush();
            }
            result = out.toString();
        }catch (FileNotFoundException e){
            LoggerBasara.error(FileBasara.class, "文件未找到,路径:{}, 时间:{}", filePath, TimeBasara.getCurrentTimeInString());
        }catch (IOException e){
            LoggerBasara.error(FileBasara.class, "磁盘IO错误:{}", filePath);
        }
        return result;
    }

    public static String streamToString(InputStream inputStream) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                out.flush();
            }
            String result = out.toString();
            out.close();
            inputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
