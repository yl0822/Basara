import com.redis.dc.HashClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public class HashClientTest {

    HashClient client;

    @Before
    public void before(){
        client = new HashClient();
    }

    @After
    public void after(){
        client.destroy();
    }

    @Test
    public void setTest(){
        Book book = new Book();
        book.setId(1L);
        book.setName("nba");
        book.setPrice(12);
        try {
            Assert.assertTrue(client.set(book.getClass().getSimpleName() + "_" + book.getId(), book));
        }catch (Exception e){
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    public void getTest(){
        try {
            Assert.assertEquals(client.get("Book_1", "name"), "nba");
        }catch (Exception e){
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    public void getObjTest(){
        try {
            Book book = (Book)client.get("Book_1", Book.class);
            System.out.println(book);
        }catch (Exception e){
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }
}
