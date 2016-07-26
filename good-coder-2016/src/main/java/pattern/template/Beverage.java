package pattern.template;

/**
 * Created by long.yl on 2016/7/26.
 */
public abstract class Beverage {
    /**
     * 冲泡咖啡或茶...流程
     */
    public final void create(){
        boilWater();//把水煮沸
        brew();//用沸水冲泡...
        pourInCup();//把...倒进杯子

        //挂钩决定是否添加配料
        if(hook()){
            addCoundiments();//加...
        }
        //hook();
    }

    /**
     * 默认添加配料
     * @return
     */
    public boolean hook() {
        return true;
    }

    //public void hook(){}

    public abstract void addCoundiments();

    public abstract void brew();

    public void boilWater() {
        System.out.println("煮开水");
    }

    public void pourInCup() {
        System.out.println("倒进杯子");
    }
}
