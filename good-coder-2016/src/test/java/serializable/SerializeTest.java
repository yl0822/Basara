package serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author long.yl.
 * @Date 2016/3/18
 */
public class SerializeTest {
    @Test
    public void test() throws Throwable{
        //序列化
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\data.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Hibernate hibernate = new Hibernate();
        objectOutputStream.writeObject(hibernate);
        objectOutputStream.flush();
        outputStream.close();
        objectOutputStream.close();

        //反序列化
        FileInputStream inputStream = new FileInputStream(new File("D:\\data.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Hibernate newHibernate = (Hibernate) objectInputStream.readObject();
        System.out.println(newHibernate.getValue());
        inputStream.close();
        objectInputStream.close();
        /**
         * result:
         * aced 0005 7372 001a 696f 2e53 6572 6961
         * 6c69 7a65 5465 7374 2448 6962 6572 6e61
         * 7465 1217 6ebc d07e a737 0200 0249 0003
         * 6b65 794c 0005 7661 6c75 6574 0012 4c6a
         * 6176 612f 6c61 6e67 2f53 7472 696e 673b
         * 7870 0000 0000 70
         * */
    }
}

class Hibernate implements Serializable{

    private static final long serialVersionUID = 1303632374377916215L;

    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
