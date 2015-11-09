package fengke.model.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ģʽ
 * ������
 * 			��Դ�ڲ���԰     http://www.cnblogs.com/draem0507/p/3795189.html
 * @author ���
 * 
 * ��飺
 * 		���壺�ṩһ�ַ�������һ�����������и���Ԫ�أ����ֲ���¶�ö�����ڲ�ϸ�ڡ�
 * 
 *   ������ģʽ���ŵ��У�
 *   		1.���˱�����ʽ�����ڶ��󼯺ϵı��������ǱȽ��鷳�ģ�����������������б������п���ͨ���α���ȡ�ã����û���Ҫ�ڶԼ����˽�������ǰ���£����б������󣬵��Ƕ���hash����˵���û����������ͱȽ��鷳�ˡ��������˵������������û��������ͼ򵥵Ķ��ˡ�
 *   		2.�����ṩ���ֱ�����ʽ������˵�������б����ǿ��Ը�����Ҫ�ṩ�������������������ֵ��������û�������ֻ��Ҫ�õ�����ʵ�ֺõĵ��������Ϳ��Է���ĶԼ��Ͻ��б����ˡ�
 *   		3.��װ�����ã��û�ֻ��Ҫ�õ��������Ϳ��Ա����������ڱ����㷨����ȥ���ġ�
 *   
 *   ������ģʽ��ȱ�㣺
 *   		1.���ڱȽϼ򵥵ı�������������������б���ʹ�õ�������ʽ������Ϊ��������ҿ��ܶ��ио�����ArrayList����������Ը��ʹ��forѭ����get�������������ϡ�
 * 
 *	������ģʽ�����ó�����
 *			������ģʽ���뼯�Ϲ��������ģ�һ����˵������ֻҪʵ��һ�����ϣ�����Ҫͬʱ�ṩ������ϵĵ�����������java�е�Collection��List��Set��Map�ȣ���Щ���϶����Լ��ĵ���������������Ҫʵ��һ���������µ���������ȻҲ��Ҫ���������ģʽ�������ǵ�����ʵ��һ����������
 *			���ǣ�����������������Ĺ�ϵ̫�����ˣ����Դ����������ʵ��������ʱ�򶼸��ṩ�˵�������������Щ�����ṩ�������͵������ھ����������¾Ϳ����������ǵ���Ҫ������������Ҫ�����Լ�ȥʵ��������ģʽ�ĳ������ǱȽ��ټ��ģ�����ֻ��Ҫʹ�����������е������͵������Ϳ����ˡ�
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
//����ӿڣ����ڲ�������
interface Iterator {

    public Object next();

    public boolean hasNext();

}
//���û����Ĳ���
class ConcreteIterator implements Iterator {
    private List<Object> list;
    private int cursor = 0;// ��ǰ�α�λ��

    public ConcreteIterator(List<Object> list) {
        this.list = list;

    }
    //�ж��Ƿ�����һ���ڵ�
    public boolean hasNext() {
        return !(cursor == list.size());
    }
    //ȡ����һ�����ݽڵ�
    public Object next() {
        Object obj = null;
        if (hasNext()) {
            obj = list.get(cursor++);
        }
        return obj;
    }
}

// ģ�⼯�Ͻӿ� ��ɾ ��(����)
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
    //����
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }

    public void remove(Object obj) {
        list.remove(obj);

    }



}
