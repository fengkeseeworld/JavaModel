package fengke.model.mediator;

/**
 * 中介模式 
 * 
 * 声明： 
 * 		来源博客园       http://www.cnblogs.com/itTeacher/archive/2012/12/06/2805286.html
 * 
 * @author 锋客
 * 
 *         简介： 
 *         中介者模式是行为模式之一。定义一个中介对象来封装系列对象之间的交互。中介者使各个对象不需要显示地相互引用，从而使其耦合性松散
 *         而且可以独立地改变他们之间的交互
 *         
 *     	中介者模式又称为调停者模式，共分为3部分：
 *     			抽象中介者：定义好同事类对象到中介者对象的接口，用于各个同事类之间的通信。一般包括一个或几个抽象的事件方法，并由子类去实现。
 *     			中介者实现类：从抽象中介者继承而来，实现抽象中介者中定义的事件方法。从一个同事类接收消息，然后通过消息影响其他同时类。
 *     			同事类：如果一个对象会影响其他的对象，同时也会被其他对象影响，那么这两个对象称为同事类。
 *     					在类图中，同事类只有一个，这其实是现实的省略，在实际应用中，同事类一般由多个组成，他们之间相互影响，相互依赖。
 *     					同事类越多，关系越复杂。并且，同事类也可以表现为继承了同一个抽象类的一组实现组成。在中介者模式中，同事类之间必
 *     					须通过中介者才能进行消息传递
 *     中介者模式的优点：
 *     		•适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
 *     		•使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。			
 *     		•使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。
 * 		适用场景:
 * 			在面向对象编程中，一个类必然会与其他的类发生依赖关系，完全独立的类是没有意义的。一个类同时依赖多个类的情况也相当普遍，
 * 			既然存在这样的情况，说明，一对多的依赖关系有它的合理性，适当的使用中介者模式可以使原本凌乱的对象关系清晰，但是如果滥用，
 * 			则可能会带来反的效果。一般来说，只有对于那种同事类之间是网状结构的关系，才会考虑使用中介者模式。可以将网状结构变为星状结构，
 * 			使同事类之间的关系变的清晰一些。
 */
public class MediatorA {

	public static void main(final String[] args) {

		AbstractColleague collA = new ColleagueA();
		AbstractColleague collB = new ColleagueB();

		AbstractMediator am = new Mediator(collA, collB);

		System.out.println("==========通过设置A影响B==========");
		collA.setNumber(1000, am);
		System.out.println("collA的number值为：" + collA.getNumber());
		System.out.println("collB的number值为A的10倍：" + collB.getNumber());

		System.out.println("==========通过设置B影响A==========");
		collB.setNumber(1000, am);
		System.out.println("collB的number值为：" + collB.getNumber());
		System.out.println("collA的number值为B的0.1倍：" + collA.getNumber());
		
	}

}

abstract class AbstractColleague {
	protected int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// 注意这里的参数不再是同事类，而是一个中介者
	public abstract void setNumber(int number, AbstractMediator am);
}

class ColleagueA extends AbstractColleague {

	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.AaffectB();
	}
}

class ColleagueB extends AbstractColleague {

	@Override
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.BaffectA();
	}
}

abstract class AbstractMediator {
	protected AbstractColleague A;
	protected AbstractColleague B;

	public AbstractMediator(AbstractColleague a, AbstractColleague b) {
		A = a;
		B = b;
	}

	public abstract void AaffectB();

	public abstract void BaffectA();

}

class Mediator extends AbstractMediator {

	public Mediator(AbstractColleague a, AbstractColleague b) {
		super(a, b);
	}

	// 处理A对B的影响
	public void AaffectB() {
		int number = A.getNumber();
		B.setNumber(number * 100);
	}

	// 处理B对A的影响
	public void BaffectA() {
		int number = B.getNumber();
		A.setNumber(number / 100);
	}
}




