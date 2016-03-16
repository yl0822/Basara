/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public class Book {
    private Long id;
    private String name;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) throws Throwable{
        //封装类型无法实列化????!!!!!
//        Long l = 2L;
//        Long id = l.getClass().newInstance();
//        System.out.println(id);

//        String s = "aaa";
//        String name = s.getClass().newInstance();
//        System.out.println(name);

//        Book b = new Book();
//        Book book = b.getClass().newInstance();
//        System.out.println(book);
        System.out.println(Book.class.getDeclaredField("id").getType().getSimpleName());
    }
}
