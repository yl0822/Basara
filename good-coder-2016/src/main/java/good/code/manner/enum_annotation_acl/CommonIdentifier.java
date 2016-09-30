package good.code.manner.enum_annotation_acl;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner.enum_annotation_acl
 */
public enum CommonIdentifier implements Identifier {
    // 权限级别
    Reader, Author, Admin;

    @Override
    public boolean identify() {
        return false;
    }

}
