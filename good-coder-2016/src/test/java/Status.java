import java.util.HashMap;
import java.util.Map;

/**
 * Created by long.yl
 * Created in 2016/9/20
 * Created on Basara_PACKAGE_NAME
 */
public enum Status {
    NULL(0, "", ""),

    SAVE_EMPTY(11, "未发布", "保存(空)"),
    SAVE_NOT_EMPTY(12, "未发布", "保存(非空)"),

    AUDITTING(2, "审核中", "审核中"),

    ALL_PASS(31, "已发布", "完全通过"),
    PART_PASS(32, "已发布", "部分通过"),
    AUDIO_NOT_PASS(321, "已发布", "部分通过", "音频未通过审核"),
    PROFILE_NOT_PASS(322, "已发布", "部分通过", "资料未通过审核"),

    ALL_NOT_PASS(41, "未通过审", "完全不通过");

    private int value;
    private String firstStatus;
    private String secondStatus;
    private String thirdStatus;

    private static Map<Integer, String> firstStatusMap = new HashMap<>();
    private static Map<Integer, String> secondStatusMap = new HashMap<>();
    private static Map<Integer, String> thirdStatusMap = new HashMap<>();

    static {
        for (Status status : Status.values()) {
            firstStatusMap.put(status.value / 100, status.firstStatus);
            secondStatusMap.put(status.value / 10, status.firstStatus);
            thirdStatusMap.put(status.value, status.firstStatus);
        }
    }

    private Status(int value, String firstStatus, String secondStatus) {
        this.value = value;
        this.firstStatus = firstStatus;
        this.secondStatus = secondStatus;
    }

    private Status(int value, String firstStatus, String secondStatus, String thirdStatus) {
        this.value = value;
        this.firstStatus = firstStatus;
        this.secondStatus = secondStatus;
        this.thirdStatus = thirdStatus;
    }

    public static Status getEnumByValue(int value){
        for (Status status : Status.values()) {
            if (value == status.value){
                return status;
            }
        }
        return NULL;
    }
}
