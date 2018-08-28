package test.base;

import base.Bag;
import org.junit.Test;

public class BagTest {

    private Bag<String> bag = new Bag<>();

    @Test
    public void test(){
        String a = "hello";
        String b = "world";
        String c = "hhh";
        String d = "sss";
        bag.add(a);
        bag.add(b);
        bag.add(c);
        bag.add(d);

        System.out.println("-----------------");
        for (String str:bag){
            System.out.println(str);
        }
    }

}