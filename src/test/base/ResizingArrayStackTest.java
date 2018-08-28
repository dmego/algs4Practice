package test.base;

import base.ResizingArrayStack;
import org.junit.Test;

/**
* ResizingArrayStack Tester. 
* 
* @author dmego
* @since <pre>°ËÔÂ 28, 2018</pre> 
* @version 1.0 
*/ 
public class ResizingArrayStackTest {
    ResizingArrayStack<String> stack = new ResizingArrayStack<String>();

@Test
public void test() throws Exception {
    String a = "hello";
    String b = "world";
    String c = "hhh";
    String d = "sss";
    stack.push(a);
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
    stack.push(b);
    stack.push(c);
    stack.push(d);
    System.out.println(stack.size());
    System.out.println("------------------");
    for (String str:stack){
        System.out.println(str);
    }
} 

} 
