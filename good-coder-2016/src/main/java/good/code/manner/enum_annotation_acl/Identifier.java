package good.code.manner.enum_annotation_acl;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner.enum_annotation_acl
 */
public interface Identifier{
    //无权访问时的礼貌语
    String REFUSE_WORD  =  "您无权访问";
    //鉴权
    public  boolean identify();
}
