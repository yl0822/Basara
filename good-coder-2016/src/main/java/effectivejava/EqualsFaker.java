package effectivejava;

/**
 * @author long.yl.
 * @Date 2016/3/30
 */
public class EqualsFaker {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("abc");
        student1.setsId(12345);
        student1.setAge(12);
        student1.setClassInfo(54);
        Student student2 = new Student();
        student2.setName("abc");
        student2.setsId(12345);
        student2.setAge(122);
        student2.setClassInfo(534);
        Student student3 = new Student();
        student3.setName("abc");
        student3.setsId(123452);
        student3.setAge(122);
        student3.setClassInfo(534);
        System.out.println(student1.equals(student1));
        System.out.println(student1.equals(student2));
        System.out.println(student1.equals(student3));
    }

    static class Student {
        private String name;
        private long sId;
        private int age;
        private int classInfo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getsId() {
            return sId;
        }

        public void setsId(long sId) {
            this.sId = sId;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getClassInfo() {
            return classInfo;
        }

        public void setClassInfo(int classInfo) {
            this.classInfo = classInfo;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj instanceof Student) {
                Student student = (Student) obj;
                if (this.name == student.getName() && this.sId == student.getsId()) {
                    return true;
                }
            }
            return false;
        }
    }
}
