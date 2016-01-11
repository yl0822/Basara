import java.util.Arrays;

/**
 * @author long.yl.
 */
public class BootStrap {
    public static void main(String[] args) {
        String str = "1035194-35056-1033016_1055064-35057-0_1055062-35057-0_1036621-38012-0_1065414-35041-0_1065414-35041-0_1035193-35056-0_1035195-35056-0_1055063-35057-0_1063006-35057-0_1062012-35060-0_1035195-35056-0_1035193-35056-0_1065414-35041-0_1055059-35057-0_1035208-35057-0_1035208-35057-0_1055059-35057-0_1055126-35054-0_1055128-35054-0_1035193-35056-0_1035195-35056-0_1055063-35057-0_1062012-35060-0_1063006-35057-0_1035195-35056-0";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.toString());
        String addedID = "1036627-38014-0";
        String[] prdtIds = sb.toString().split("_");
        if (Arrays.asList(prdtIds).contains(addedID)){
            if (sb.toString().startsWith(addedID)){
                sb = new StringBuilder(sb.toString().replace(addedID + "_", ""));
            }else {
                sb = new StringBuilder(sb.toString().replace("_" + addedID, ""));
            }
        }
        System.out.println(sb.toString());
   }
}
