package pattern.template;

/**
 * Created by long.yl on 2016/7/26.
 */
public class Coffee extends Beverage {

    @Override
    public void addCoundiments() {
        System.out.println("添加糖和牛奶");   }

    @Override
    public void brew() {
        System.out.println("用水冲咖啡");
    }

    /**
     * 有的客人不喜欢加配料
     */
    @Override
    public boolean hook() {
        return false;
    }
}
