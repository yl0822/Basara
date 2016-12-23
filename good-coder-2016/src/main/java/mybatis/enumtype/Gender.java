package mybatis.enumtype;

/**
 * Created by long.yl
 * Created in 2016/12/13
 * Created on Basara_mybatis.enumtype
 */
public enum Gender {
    NULL(0, "unkowun"),
    FEMALE(1, "famale"),
    MALE(2, "male");

    private int value;
    private String desc;

    private Gender(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
