package fengke.model.Strategy;
/**
 * 策略模式
 * 申明：
 * 		来源于博客园  http://www.cnblogs.com/freeliver54/archive/2012/06/29/2569647.html
 * @author 锋客
 *	简介：
 *		定义：
 *			Strategy是属于设计模式中 对象行为型模式，主要是定义一系列的算法，把这些算法一个个封装成单独的类。
 *		策略模式主要分为以下三个角色： 
 *				1.环境角色（Context）:持有一个策略类引用 
 *				2.抽象策略（Strategy）:定义了多个具体策略的公共接口，具体策略类中各种不同的算法以不同的方式实现这个接口；
 *								   Context使用这些接口调用不同实现的算法。一般的，我们使用接口或抽象类实现。 
 *				3.具体策略（ConcreteStrategy）:实现抽象策略类中的相关的算法或操作。
 *
 *	解释：
 *			核心：抽象的策略
 *			具体策略通过不同的方式实现抽象的策略，然后进行不同的处理方式；
 *			环境策略类（似于代理），通过私有化一个抽象的策略属性，将代替具体的策略。
 *			命令执行方向：
 *						1.创建一个具体策略类的对象；
 *						2.将对象赋值给环境的构造器，产生一个类似于具体策略类对象的代理对象（环境策略类的对象）。
 *						3.外部通过调用环境策略类的对象，执行相应的策略方法。
 */
public class StrategyA {
	/*
	 * 抽象的策略
	 */
	abstract class AbstractStrategy {
		//抽象的方法
		public abstract void algorithm();
		
	}
	//策略的实现ConcreteStrategy1
	class ConcreteStrategy1 extends AbstractStrategy{

		public void algorithm() {
			System.out.println("我是第一种策略");
			
		}
		
	}
	//策略的实现ConcreteStrategy2
	class ConcreteStrategy2 extends AbstractStrategy{

		public void algorithm() {
			System.out.println("我是第二种策略");
			
		}
		
	}
	//环境
	class Context {
		private AbstractStrategy strategy;  
		//构造器
		public Context(AbstractStrategy abstractStrategy){
			this.strategy=abstractStrategy;
		}
		//调用具体策略类的方法
		public void algorithm(){
			strategy.algorithm();
		}
	}
	//测试
	public static void main(String[] args) {
		StrategyA strategy = new StrategyA();
		Context context1 = strategy.new Context(strategy.new ConcreteStrategy1());
		context1.algorithm();
		Context context2 = strategy.new Context(strategy.new ConcreteStrategy2());
		context2.algorithm();
	}
	
	
	/*		测试内容：
	 * 				测试程序直接使用新创建的子类，又有何妨？
	 * 				例如：	
	 * 						Strategy strategy = new Strategy();
	 * 						AbstractStrategy object = strategy.new ConcreteStrategy1();   
	 * 						object.algorithm();   
	 * 				可以看出，似乎这种方式更加简单。
	 * 
	 * 		对于context的解释：
	 * 				1.如果我们需要对不同策略中相同算法的参数，执行相同的安全性检查，我们如果没有环境角色Context，
	 * 				     则只能在每个实现的开始部分，调用安全性检查代码；而有了Context这个角色，我们可以在调用Context的构造器时，
	 * 				    统一进行安全性检查。这在我们的实现策略比较多的时候，比如说7、8个的时候，特别有用，可以大量减少冗余的代码量。 
	 * 				2.如果我们需要改变原有算法时，需要引进新的参数，如果没有Context，我们怎么办？一种办法是重载该算法，增加新的函数接口；
	 * 				    另外一种办法是完全废弃原有的函数接口，重新写新的函数接口。毋庸置疑，这2种办法的代价都很大，尤其是如果这个新的参数
	 * 				    只有部分实现策略中的该算法实现用到的时候。而我们使用Context就可以完全解决这个问题。
	 * 
	 * 		对于比较复杂情况，参考下一个例子
	 * 
	 */

}
