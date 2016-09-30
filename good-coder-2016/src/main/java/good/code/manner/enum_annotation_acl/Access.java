package good.code.manner.enum_annotation_acl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner.enum_annotation_acl
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Access{
    //什么级别可以访问，默认是管理员
    CommonIdentifier level () default CommonIdentifier.Admin;
}
