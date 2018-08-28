package base;

import java.util.Iterator;

/**
 * 先进先出队列
 * 特点：
 *  入队列，既向队尾插入一个元素
 *  出队列，既向队首插入一个元素
 * 链表实现
 */
public class Queue<Item> implements Iterable<Item>{
    private class Node{
        Item item;
        Node next;
    }

    private Node first; //队首元素
    private Node last; //队尾元素
    private int N; //队列元素个数

    //判读队列是否为空
    public boolean isEmpty(){
        return first == null; //或者N==0
    }

    //返回队列的元素数量
    public int size(){
        return N;
    }

    //入队列(向队尾添加一个元素)
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())//如果队列为空，队首和队尾相同，都是新入队的那个元素
            first = last;
        else //否则，新入队的元素应该是为新队尾，应是原来队尾元素的next
            oldLast.next = last;
        N++; //队列元素个数加一
    }

    //出队列（删除队首元素，并且队首的next为新队首）
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) //如果最后一个元素出队，队列为空，则此时last还指向以及出队列的队尾元素，需要我们置last = null
            last = null;
        N--;
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
