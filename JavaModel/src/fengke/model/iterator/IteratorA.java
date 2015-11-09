package fengke.model.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代模式
 * 声明：
 * 			来源于博客园     http://www.cnblogs.com/draem0507/p/3795189.html
 * @author 锋客
 * 
 * 简介：
 * 		定义：提供一种方法访问一个容器对象中各个元素，而又不暴露该对象的内部细节。
 * 
 *   迭代器模式的优点有：
 *   		1.简化了遍历方式，对于对象集合的遍历，还是比较麻烦的，对于数组或者有序列表，我们尚可以通过游标来取得，但用户需要在对集合了解很清楚的前提下，自行遍历对象，但是对于hash表来说，用户遍历起来就比较麻烦了。而引入了迭代器方法后，用户用起来就简单的多了。
 *   		2.可以提供多种遍历方式，比如说对有序列表，我们可以根据需要提供正序遍历，倒序遍历两种迭代器，用户用起来只需要得到我们实现好的迭代器，就可以方便的对集合进行遍历了。
 *   		3.封装性良好，用户只需要得到迭代器就可以遍历，而对于遍历算法则不用去关心。
 *   
 *   迭代器模式的缺点：
 *   		1.对于比较简单的遍历（像数组或者有序列表），使用迭代器方式遍历较为繁琐，大家可能都有感觉，像ArrayList，我们宁可愿意使用for循环和get方法来遍历集合。
 * 
 *	迭代器模式的适用场景：
 *			迭代器模式是与集合共生共死的，一般来说，我们只要实现一个集合，就需要同时提供这个集合的迭代器，就像java中的Collection，List、Set、Map等，这些集合都有自己的迭代器。假如我们要实现一个这样的新的容器，当然也需要引入迭代器模式，给我们的容器实现一个迭代器。
 *			但是，由于容器与迭代器的关系太密切了，所以大多数语言在实现容器的时候都给提供了迭代器，并且这些语言提供的容器和迭代器在绝大多数情况下就可以满足我们的需要，所以现在需要我们自己去实践迭代器模式的场景还是比较少见的，我们只需要使用语言中已有的容器和迭代器就可以了。
 */
public class IteratorA {
	
	public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        list.add("a");
        list.add("b");
        list.add("c");
        Aggregate aggregate = new ConcreteAggregate(list);
        Iterator iterator = aggregate.iterator();

        while (iterator.hasNext()) {
            String o = (String) iterator.next();
            System.out.println(o);
        }
    }

}
//定义接口，用于操作数据
interface Iterator {

    public Object next();

    public boolean hasNext();

}
//设置基本的操作
class ConcreteIterator implements Iterator {
    private List<Object> list;
    private int cursor = 0;// 当前游标位置

    public ConcreteIterator(List<Object> list) {
        this.list = list;

    }
    //判断是否有下一个节点
    public boolean hasNext() {
        return !(cursor == list.size());
    }
    //取出下一个内容节点
    public Object next() {
        Object obj = null;
        if (hasNext()) {
            obj = list.get(cursor++);
        }
        return obj;
    }
}

// 模拟集合接口 增删 差(遍历)
interface Aggregate {

    public void add(Object obj);

    public void remove(Object obj);

    public Iterator iterator();

}

class ConcreteAggregate implements Aggregate {
    private List<Object> list;

    public ConcreteAggregate(List<Object> list) {
        this.list = list;

    }

    public void add(Object obj) {
        list.add(obj);

    }
    //迭代
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }

    public void remove(Object obj) {
        list.remove(obj);

    }



}
