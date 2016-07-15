package question.demo;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author long.yl.
 * @Date 2016/6/21
 */
public class BankTrans {
    public static AtomicBoolean lock = new AtomicBoolean(false);
    private static Map<String, User> registeredUser;

    static {
        registeredUser = new ConcurrentHashMap<>();
        init();
    }

    public static void init() {
        registeredUser.put("larry", new User("larry", 15000));
        registeredUser.put("tom", new User("tom", 10000));
    }

    public static void main(String[] args) {
        BankTrans trans = new BankTrans();
        System.out.println(trans);
        trans.transMoney2("larry", "tom", 2500);
        System.out.println(trans);
    }

    public boolean isBankUser(String name) {
        return registeredUser.get(name) != null;
    }

    public boolean isFinancialHealth(String name, int money) {
        return registeredUser.get(name).getMoney() >= money;
    }

    public boolean transMoney2(String fromName, String toName, int money) {
        boolean ret = false;
        if (isBankUser(fromName) && isBankUser(toName)) {
            if (isFinancialHealth(fromName, money)) {
                Map<String, User> registeredUser_ = new ConcurrentHashMap<>(registeredUser);
                // 利用lock来防止共享变量一致性问题
                synchronized (lock) {
                    try {
                        registeredUser_.put(fromName, new User(fromName, registeredUser_.get(fromName).getMoney() - money));
                        System.out.println(new String[]{"asd", "asd"}[45]);
                        registeredUser_.put(toName, new User(toName, registeredUser_.get(toName).getMoney() + money));
                        ret = true;
                        // 利用临时Map来考虑事务
                        registeredUser = registeredUser_;
                    } catch (Exception e) {
                        System.out.println("some exception : " + e.getLocalizedMessage() + " occurs during money transing!rollback");
                    }
                }
            } else {
                System.out.println("from user who don't have enough money!");
            }
        } else {
            System.out.println("someone may not our bank register user!");
        }
        return ret;
    }

    @Override
    public String toString() {
        return Arrays.toString(registeredUser.values().toArray());
    }

    static class User {
        private String name;
        private int money;

        public User(String name, int money) {
            this.name = name;
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", money=" + money +
                    '}';
        }
    }
}
