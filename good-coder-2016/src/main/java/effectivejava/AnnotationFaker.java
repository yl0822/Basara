package effectivejava;

import java.lang.annotation.Annotation;

/**
 * @author long.yl.
 * @Date 2016/3/30
 */
public class AnnotationFaker {
    @Geek
    @Nerd
    static class Me{

    }

    public static void main(String[] args) {
        Me me = new Me();
        if (me.getClass().isAnnotationPresent(Geek.class)){
            System.out.println(me.getClass().getAnnotation(Geek.class).years());
        }
        Annotation[] annotations = me.getClass().getAnnotations();
        System.out.println(me.getClass().isAnnotationPresent(Geek.class));
        System.out.println(me.getClass().isAnnotationPresent(Nerd.class));
        System.out.println(annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName().equals(Geek.class.getSimpleName()));
        }
    }
}
