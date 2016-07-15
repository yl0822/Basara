package algorithm.netease.basara.test;

import mode.netease.basara.test.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public class BootStrap {
    public static void main(String[] args) {
        List<Book> stringList = new ArrayList<>();
        Book book = new Book();
        book.setName("asc");
        stringList.add(book);
        BootStrap strap = new BootStrap();
        System.out.println(stringList.get(0).getName());
        strap.changeList(stringList);
        System.out.println(stringList.get(0).getName());
    }

    public void changeList(List<Book> stringList) {
        for (Book book : stringList) {
            book.setName("asc__sd");
        }
    }
}
