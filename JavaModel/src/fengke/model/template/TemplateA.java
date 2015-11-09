package fengke.model.template;

/**
 * 模板方法模式 声明： 来源于博客园
 * 
 * @author 锋客
 * 
 *         简介： 定义：定义了一个操作中的算法的骨架，而将部分步骤的实现在子类中完成。
 *         模板方法模式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * 
 *         模板方法模式是所有模式中最为常见的几个模式之一，是基于继承的代码复用的基本技术。因此，没有关联关系。
 * 
 *         因此，在模板方法模式的类结构图中，只有继承关系。
 * 
 *         模板方法模式需要开发抽象类和具体子类的设计师之间的协作。一个设计师负责给出一个算法的轮廓和骨架，
 *         另一些设计师则负责给出这个算法的各个逻辑步骤。
 * 
 *         代表这些具体逻辑步骤的方法称做基本方法(primitive method)；而将这些基本方法汇总起来的方法叫做模板方法(template
 *         method)，这个设计模式的名字就是从此而来。
 * 
 *         模板方法模式中的三类角色： 1、具体方法(Concrete Method) 2、抽象方法(Abstract Method)
 *         3、钩子方法(Hook Method)
 * 
 *         三类角色的关联： 
 *         在模板方法模式中，首先父类会定义一个算法的框架，即实现算法所必须的所有方法。 其中，具有共性的代码放在父类的具体方法中。
 *         各个子类特殊性的代码放在子类的具体方法中。但是父类中需要有对应抽象方法声明。 钩子方法可以让子类决定是否对算法的不同点进行挂钩。
 * 
 *         总结
 *         使用模板方法模式可以将代码的公共行为提取，以达到复用的目的。
 *         而对于特殊化的行为在子类中实现。父类的模板方法可以控制子类中的具体实现。
 *         子类无需了解整体算法框架，只需实现自己的业务逻辑即可
 * 
 * 
 */
public class TemplateA {

	public static void main(String[] args) {

		AbstractClass objA = new ConcreteClassA();

		AbstractClass objB = new ConcreteClassB();

		objA.TemplateMethod();

		objB.TemplateMethod();

	}

}

// 定义一个抽象类
abstract class AbstractClass {

	public abstract void PrimitiveOperation1();

	public abstract void PrimitiveOperation2();

	public void TemplateMethod() {

		PrimitiveOperation1();

		PrimitiveOperation2();

	}

}

// 实现父类的方法
class ConcreteClassA extends AbstractClass {

	@Override
	public void PrimitiveOperation1() {

		System.out.println("具体A类方法1");

	}

	@Override
	public void PrimitiveOperation2() {

		System.out.println("具体A类方法2");

	}

}

class ConcreteClassB extends AbstractClass {

	@Override
	public void PrimitiveOperation1() {

		System.out.println("具体B类方法1");

	}

	public void PrimitiveOperation2() {

		System.out.println("具体B类方法2");

	}

}
