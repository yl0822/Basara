package mode.netease.basara.test;

import mode.neteas.basara.SingletonBasara;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public class Book {
    public static void main(String[] args) {
        SingletonBasara<Book> bookGenaretor = new SingletonBasara<Book>() {
            @Override
            protected Book newInstance() {
                return new Book();
            }
        };
        Book book = bookGenaretor.getInstance();
        Book book2 = bookGenaretor.getInstance();
        System.out.println(book);
        System.out.println(book2);
    }

    @Override
    public String toString() {
        return "book的内存地址:"+super.toString();
    }
}
