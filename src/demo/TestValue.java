package demo;

/**
 * 验证java中只有值传递
 * Dmego 2018-8-27
 */
class User{
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}


public class TestValue {
    private static void change(User user2, int a2){
        System.out.println("改变之前："+user2.getName()+",a2="+a2);
        user2.setName("李四"); //改变 user2 的 name 值
        a2 = 10; //改变 a2 的值
        System.out.println("改变之后："+user2.getName()+",a2="+a2);
        user2 = new User(); //将 user2 重新指向一个新对象
        user2.setName("王五");
        System.out.println("重新指向一个新对象后："+user2.getName());
    }

    public static void main(String[] args){
        User user1 = new User();
        user1.setName("张三"); //初始化 user1 的 name 为张三
        int a1 = 5; //初始化 a1 的值为 5
        change(user1,a1); //调用方法验证传值方式
        System.out.println("调用方法后："+user1.getName()+",a1="+a1);
    }
}
