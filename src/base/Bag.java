package base;

import java.util.Iterator;

/**
 * 背包（只能向里面添加元素，不能删除元素，可以遍历背包）
 * 链表实现
 */

public class Bag<Item> implements Iterable<Item>{
    private class Node{
        Item item;
        Node next;
    }
    private Node first; //首节点

    //向背包中添加元素(如同stack一样，)
    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first; //遍历开始时，当前节点为首节点

        @Override
        public boolean hasNext() {
            return current != null; //当前节点不为null，说明还有下一个元素
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next; //当前节点变为下一个节点，然后继续循环
            return  item;
        }

        @Override
        public void remove() {

        }
    }
}
