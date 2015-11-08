package fengke.model.builder;

/**
 * 建造者模式
 * 
 * @author 锋客
 * 
 *         简介： 
 *         	定义：
 *         	 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。 [构建与表示分离，同构建不同表示]
 * 
 *         与抽象工厂的区别： 
 *         在建造者模式里，有个指导者，由指导者来管理建造者，用户是与指导者联系的，指导者联系建造者最后得到产品。
 *         即建造模式可以强制实行一种分步骤进行的建造过程。
 * 
 *         　建造模式是将复杂的内部创建封装在内部，对于外部调用的人来说，只需要传入建造者和建造工具，对于内部是如何建造成成品的，调用者无需关心。
 * 
 *         为何使用建造者模式： 是为了将构建复杂对象的过程和它的部件解耦。注意：是解耦过程和部件。
 *         因为一个复杂的对象，不但有很多大量组成部分，如汽车，有很多部件：车轮、方向盘、发动机，还有各种小零件等等，
 *         部件很多，但远不止这些，如何将这些部件装配成一辆汽车，这个装配过程也很复杂(需要很好的组装技术)，
 *         Builder模式就是为了将部件和组装过程分开。
 * 
 * 
 */
public class BuilderA {
	// 接口
	interface Builder {
		void buildPartA();

		void buildPartB();

		void buildPartC();

		Product getResult();

	}

	// 产品
	interface Product {

	}
	
	//
	interface Part{
		
	}

	// 建造者
	class ConcreteBuilder implements Builder {
		Part partA, partB, partC;
		@Override
		public void buildPartA() {
			System.out.println("成功构造A");

		}

		@Override
		public void buildPartB() {
			System.out.println("成功构造B");

		}

		@Override
		public void buildPartC() {
			System.out.println("成功构造C");

		}

		@Override
		public Product getResult() {
			System.out.println("成功组装！！");
			return null;
		}

	}

	//建造者
	class Director {
		private Builder builder; 
		public Director(Builder builder) {
			this.builder=builder;
		}
		void construct(){
			builder.buildPartA();
			builder.buildPartB();
			builder.buildPartC();
		}


	}
	
	public static void main(String[] args) {
		BuilderA temp = new BuilderA();
		ConcreteBuilder builder = temp.new ConcreteBuilder();
		Director director = temp.new Director( builder ); 
		director.construct(); 
		Product product = builder.getResult();
	}
}
