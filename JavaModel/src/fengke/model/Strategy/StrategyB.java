package fengke.model.Strategy;

/*
 * 较为复杂的策略模式实现
 * 	简介：
 * 			主要介绍context的作用
 */
public class StrategyB {
	// 抽象策略
	abstract class AbstractStrategy {
		public abstract void algorithm(Context context);
	}

	// 环境角色
	static class Context {
		// 私有化抽象策略对象
		private AbstractStrategy strategy;
		//定义环境变量
		private int parameter1;
		private int parameter2;
		//记录被调用的总次数
		static int count  = 0; 
		//构造器
		public Context(AbstractStrategy strategy) {
			this.strategy=strategy;
		}
		public Context(AbstractStrategy strategy,int parameter1,int parameter2 ) {
			this.strategy=strategy;
			this.parameter1=parameter1;
			this.parameter2=parameter2;
		}
		//获取属性
		public int getParameter1() {
			return parameter1;
		}
		public int getParameter2() {
			return parameter2;
		}
		//定义方法====算法入口
		public void algorithm() {
			count++;   
			System.out.println("这是第"+count+"次调用algorithm算法");  
			this.strategy.algorithm(this);
		}
	}

	// 对于算法的第一种实现
	class ConcreteStrategy1 extends AbstractStrategy {

		public void algorithm(Context context) {
			System.out.println("我是策略一算法");
		}

	}

	// 对于算法的第二种实现
	class ConcreteStrategy2 extends AbstractStrategy {

		public void algorithm(Context context) {
			System.out.println("我是策略二算法");
			System.out.println("我的参数是："+context.getParameter1()+"  "+context.getParameter2());
		}

	}

	// 对于算法的第三种实现
	class ConcreteStrategy3 extends AbstractStrategy {

		public void algorithm(Context context) {
			System.out.println("我是策略三算法");
			System.out.println("我的参数是："+context.parameter1);
		}

	}
	//测试方法：
	public static void main(String[] args) {
		StrategyB strategy = new StrategyB();

		Context context1=new Context(strategy.new ConcreteStrategy1());
		context1.algorithm();
		
		Context context2=new Context(strategy.new ConcreteStrategy2(),100,1000);
		context2.algorithm();
		
		Context context3=new Context(strategy.new ConcreteStrategy3(),999,000);
		context3.algorithm();
	}

}
