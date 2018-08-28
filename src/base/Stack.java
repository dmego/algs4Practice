package base;

import java.util.Iterator;

/**
 * 下压堆栈
 * 链表实现
 */
public class Stack<Item> implements Iterable<Item> {

    //定义一个节点嵌套类
    private class Node {
        Item item; //节点的值
        Node next; //节点的下一个元素
    }

    private Node first; //栈顶节点，（最近添加的节点元素）
    private int N; //元素数量

    //判断栈是否为空(既判断栈顶元素是否为空)
    public boolean isEmpty() {
        return first == null;//或者N==0
    }

    //返回栈的大小
    public int size() {
        return N;
    }

    //元素入栈（在栈顶继续插入一个节点）
    public void push(Item item) {
        Node oldFirst = first; //先把原先的栈顶保存起来
        first = new Node();  //创建一个新的首节点
        first.item = item; //把新栈顶的值重置为新插入的值
        first.next = oldFirst; //然后把新栈顶的下一个元素设置为旧栈顶，这样就实现了元素入栈的操作
        N++; //栈的大小加一
    }

    //元素出栈操作（就是把栈顶元素弹出，让栈顶下面的一个元素成为新栈顶）
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--; //栈的大小减一
        return item;
    }


    //实现迭代器的接口，这样就能使用foreach()循环

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    //实现一个嵌套类，保证只需要迭代中需要的方法，去除在跌代中能够修改数据结构的方法
    private class ListIterator implements Iterator<Item> {

        private  Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

}
