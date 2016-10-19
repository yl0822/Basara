package good.code.manner.enum_annotation_acl;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner.enum_annotation_acl
 */
@Access(level=CommonIdentifier.Author)
public class Foo{
    public static void main(String[] args) {
        // 初始化业务逻辑
        Foo b = new Foo();
        // 获取注解
        Access access = b.getClass().getAnnotation(Access.class);
        // 没有Access注解或者鉴权失败
        if (null == access || !access.level().identify()) {
            // 没有Access注解或者鉴权失败
            System.out.println(access.level().REFUSE_WORD);
        }
    }
}