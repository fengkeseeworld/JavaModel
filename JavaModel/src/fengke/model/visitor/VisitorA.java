package fengke.model.visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 访问模式
 * 声明：
 * 		来源博客园  http://www.cnblogs.com/Coda/p/4317421.html
 * @author 锋客
 * 
 * 简介：
 * 		定义：
 * 			Visitor定义：作用于某个对象群中各个对象的操作。它可以使你在不改变这些对象本身的情况下，定义作用于这些对象的新操作。
 * 		
 *
 */
public class VisitorA {
	
	public static void main(String[] args) {
		// 正常逻辑实现
        Service service1 = new Saving();
        Service service2 = new Fund();
        Service service3 = new Draw();
        List<Service> ls = new ArrayList<Service>();
        ls.add(service1);
        ls.add(service2);
        ls.add(service3);
        for (Service service : ls) {
            if (service instanceof Saving) {
                System.out.println("存款");
            } else if (service instanceof Fund) {
                System.out.println("基金");
            } else if (service instanceof Draw) {
                System.out.println("提款");
            }
        }
        //上述的问题是随着业务量增大 代码维护量会非常的大 需要不断的去判断 
        
        //采用访问者模式解决
        Service saving = new Saving();
        Service fund = new Fund();
        Service draw = new Draw();
        Visitor visitor = new Visitor();
        saving.accept(visitor);
        fund.accept(visitor);
        draw.accept(visitor);
        //上述中accept中实际上有观察者的影子 实际上 访问者我们也可以理解成一个对业务熟悉的观察者
        //他不断观察者是否有新的业务需求 有的话 进行相应的业务处理
        //访问者借助的是java的动态分配机制,使得visitor可以顺利的执行相应对象的方法
	}

}
//被访问者
interface Service {

    public void accept(Visitor visitor);
}
//访问者
class Visitor {

    public void process(Service service) {
        // 基本业务
        System.out.println("基本业务");
    }

    public void process(Saving service) {
        // 存款
        System.out.println("存款");
    }

    public void process(Draw service) {
        // 提款
        System.out.println("提款");
    }

    public void process(Fund service) {
        System.out.println("基金");
        // 基金
    }

}

class Saving implements Service {

    public void accept(Visitor visitor) {
        visitor.process(this);

    }
}

class Draw implements Service {

    public void accept(Visitor visitor) {
        visitor.process(this);

    }
}

class Fund implements Service {

    public void accept(Visitor visitor) {
        visitor.process(this);

    }
}
