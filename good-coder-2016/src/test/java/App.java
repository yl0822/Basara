/**
 * Created by long.yl on 2016/7/11.
 */
public class App {
    public int i;

    public void print(){
        System.out.println(" i = " + i);
    }

    public static void main(String[] args) {
//        System.out.println("i = " + i);
        new App().print();
        String st = "safsd" + 'd';

        System.out.println(0^-88);
        System.out.println(0^45);

        int[] i = {44, 44, 44, 23, 23, 255, 255, -22, -22};
        int result = 0;
        for (int j = 0; j < i.length; j++) {
            i[j]^i[j+1]
        }
    }
}
