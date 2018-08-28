package test.base;

import base.Queue;
import org.junit.Test;

public class QueueTest {
    private Queue<String> queue = new Queue<>();

    @Test
    public void test(){
        String a = "hello";
        String b = "world";
        String c = "hhh";
        String d = "sss";
        queue.enqueue(a);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        queue.enqueue(b);
        queue.enqueue(c);
        queue.enqueue(d);
        System.out.println(queue.size());
        System.out.println("-----------------");
        for (String str:queue){
            System.out.println(str);
        }
    }
}