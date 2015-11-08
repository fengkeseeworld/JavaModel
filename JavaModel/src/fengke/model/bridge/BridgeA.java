package fengke.model.bridge;

/**
 * 桥模式 声明： 内容来自博客园：http://www.cnblogs.com/Coda/p/4289593.html
 * 
 * @author 锋客
 * 			 简介： 
 * 				Bridge定义：
 * 						 将抽象和行为划分开来，各自独立，但能动态的结合。 
 * 			为什么使用桥模式：
 *         				通常，当一个抽象类或接口有多个具体实现(concrete subclass)，这些concrete之间关系可能有以下两种：
 *        					 1.这多个具体实现之间恰好是并列的，如前面举例，打桩，有两个concrete class：方形桩和圆形桩；这两个形状上的桩是并列的，
 *        						 没有概念上的重复，那么我们只要使用继承就可以了。
 *         					 2、实际应用上，常常有可能在这多个concreteclass之间有概念上重叠。那么需要我们把抽象共同部分和行为共同部分各自独立开来，
 *         						原来是准备放在一个接口里，现在需要设计两个接口，分别放置抽象和行为。 
 *         举例： 
 *         		例如，一杯咖啡为例，有中杯和大杯之分，同时还有加奶不加奶之分。如果用单纯的继承，这四个具体实现(中杯 大杯 加奶 不加奶)之间有概念重叠,因为有中杯加奶，
 *         		也有中杯不加奶，如果再在中杯这一层再实现两个继承，很显然混乱，扩展性极差。
 * 
 */
public class BridgeA {
	// CoffeeImp 是加不加奶的行为接口
	abstract class CoffeeImp {
		abstract void pourCoffeeImp();
	}

	// 咖啡大小杯的接口
	abstract class Coffee {
		CoffeeImp coffeeImp;
		//通过继承，使子类通过调用父类的setCoffeeImp方法，设置自己的操作（是否加奶）。
		void setCoffeeImp() {
			//一个单例模式控制操作
			this.coffeeImp = CoffeeImpSingleton.getTheCoffeeImp();
		}

		public CoffeeImp getCoffeeImp() {
			return this.coffeeImp;
		}

		public abstract void pourCoffee();
	}

	// 中杯
	class MediumCoffee extends Coffee {
		public MediumCoffee() {
			setCoffeeImp();
		}

		@Override
		public void pourCoffee() {
			CoffeeImp coffeeImp = this.getCoffeeImp();
			for (int i = 0; i < 2; i++) {
				System.out.print("中杯：");
				coffeeImp.pourCoffeeImp();
			}
		}

	}

	// 大杯
	class SuperSizeCoffee extends Coffee {
		public SuperSizeCoffee() {
			setCoffeeImp();
		}

		public void pourCoffee() {
			CoffeeImp coffeeImp = this.getCoffeeImp();
			// 我们以重复次数来说明是冲中杯还是大杯 ,重复5次是大杯
			for (int i = 0; i < 5; i++) {
				System.out.print("大杯：");
				coffeeImp.pourCoffeeImp();
			}
		}

	}

	// 加奶
	class MilkCoffeeImp extends CoffeeImp {
		MilkCoffeeImp() {
		}

		void pourCoffeeImp() {
			System.out.println("加了美味的牛奶");
		}
	}

	// 不加奶
	class FragrantCoffeeImp extends CoffeeImp {
		FragrantCoffeeImp() {
		}

		void pourCoffeeImp() {
			System.out.println("什么也没加,清香");
		}
	}

	// 单例====用来控制是否加奶的行为
	static class CoffeeImpSingleton {
		private static CoffeeImp coffeeImp;

		public CoffeeImpSingleton(CoffeeImp coffeeImpIn) {
			coffeeImp = coffeeImpIn;
		}

		public static CoffeeImp getTheCoffeeImp() {
			return coffeeImp;
		}
	}

	// 测试
	public static void main(String[] args) {
		BridgeA temp = new BridgeA();
		//确定是否加奶
		new CoffeeImpSingleton(temp.new MilkCoffeeImp());
		//创建杯子容量
		MediumCoffee mediumCoffee = temp.new MediumCoffee();
		mediumCoffee.pourCoffee();
		SuperSizeCoffee superSizeCoffee = temp.new SuperSizeCoffee();
		superSizeCoffee.pourCoffee();
	}
	/*
	 * Bridge模式在EJB中的应用
	 * 
	 * EJB中有一个Data Access Object
	 * (DAO)模式，这是将商业逻辑和具体数据资源分开的，因为不同的数据库有不同的数据库操作。将操作不同数据库的行为独立抽象成一个行为接口DAO，如下：
	 * Business Object (类似Coffee)
	 * 实现一些抽象的商业操作：如寻找一个用户下所有的订单。涉及数据库操作都使用DAOImplementor。
	 * 
	 * Data Access Object (类似CoffeeImp) 一些抽象的对数据库资源操作。
	 * 
	 * DAOImplementor 如OrderDAOCS, OrderDAOOracle,
	 * OrderDAOSybase(类似MilkCoffeeImp FragrantCoffeeImp)
	 * 具体的数据库操作，如"INSERT INTO "等语句，OrderDAOOracle是Oracle
	 * OrderDAOSybase是Sybase数据库。
	 * 
	 * 数据库 (Cloudscape, Oracle, or Sybase database via JDBC API)
	 */

}
