package base;

import java.util.Iterator;

/**
 * 算法1.1 下压栈（LIFO）
 * 能够动态调整数组大小的实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1]; //栈元素
    private int N = 0; //元素数量

    //判断栈是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //返回栈的大小
    public int size(){
        return N;
    }

    //将大小为N<=max的栈移动到一个新的大小为max的数组中去
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    //将元素添加到栈顶
    public void push(Item item){
        //如果此时栈已满，我们将栈的大小加倍
        if(N == a.length)
            resize(a.length * 2);
        a[N++] = item; //（这是 N++ 的值为 N ,N的值为 N+1）
    }

    //删除栈顶的一个元素
    public Item pop(){
       Item item =  a[--N]; //这里--N的值已经变了，此时a[N]为游离状态(保存了一个不被需要的对象的引用)
        a[N] = null;//避免对象游离，设为空，让其自动回收
        //如果当前数组大小为数组长度的1/4,则将数组长度减半，这样一来，栈就为半满状态，数组长度既不会太长，也有足够的空间。
        if(N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }


    //实现迭代器的接口，这样就能使用foreach()循环

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    //实现一个嵌套类，保证只需要迭代中需要的方法，去除在跌代中能够修改数据结构的方法
    private class ReverseArrayIterator implements Iterator<Item>{

        private  int i = N;
        @Override
        public boolean hasNext() {
            //如果N >0,说明还有下一个元素
            return i > 0;
        }

        @Override
        public Item next() {
            //返回下一个元素
            return a[--i]; //栈是先进后出，所以第一个元素是i,那么下一个元素是--i
        }

        @Override
        public void remove() {

        }
    }

}
