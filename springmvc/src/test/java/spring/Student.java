package spring;

import javax.annotation.PostConstruct;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("default construct ... ");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct being invoked ... ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("init method invoked ... ");
    }

    public void print() {
        System.out.println(name + " - " + age);
    }
}
