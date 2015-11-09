package fengke.model.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 共享模式/享元模式
 * 声明：
 * 		来源于博客园      http://www.cnblogs.com/java-my-life/archive/2012/04/26/2468499.html
 * @author 锋客
 *	简介：
 *		Flyweight定义：
 *				避免大量拥有相同内容的小类的开销(如耗费内存)，使大家共享一个类(元类)。
 *		为什么使用享元模式：
 *				面向对象语言的原则就是一切都是对象，但是如果真正使用起来，有时对象数可能显得很庞大，
 *				比如，字处理软件，如果以每个文字都作为一个对象，几千个字，对象数就是几千，无疑耗费内存，
 *				那么我们还是要"求同存异"，找出这些对象群的共同点，设计一个元类，封装可以被共享的类，另外
 *				还有一些特性是取决于应用(context)，是不可共享的，这也Flyweight中两个重要概念内部
 *				状态intrinsic和外部状态extrinsic之分。
 *		
 *		直观点，就是先捏一个的原始模型，然后随着不同场合和环境，再产生各具特征的具体模型，很显然，在这里需要产
 *		生不同的新对象，所以Flyweight模式中常出现Factory模式。Flyweight的内部状态是用来共享的，Flyweight factory
 *		负责维护一个Flyweight pool(模式池)来存放内部状态的对象。
 *
 *		Flyweight模式是一个提高程序效率和性能的模式，会大大加快程序的运行速度。应用场合很多：比如你要从一个数据库中读取一系列字符串，
 *		这些字符串中有许多是重复的，那么我们可以将这些字符串储存在Flyweight池(pool)中。
 *
 *		享元模式的结构：
 *				享元模式采用一个共享来避免大量拥有相同内容对象的开销。这种开销最常见、最直观的就是内存的损耗。享元对象能做到共享的关键是区分
 *				内蕴状态(Internal State)和外蕴状态(External State)。
 *				一个内蕴状态是存储在享元对象内部的，并且是不会随环境的改变而有所不同。因此，一个享元可以具有内蕴状态并可以共享。
 *				一个外蕴状态是随环境的改变而改变的、不可以共享的。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再
 *				传入到享元对象内部。外蕴状态不可以影响享元对象的内蕴状态，它们是相互独立的。
 *
 *	注意：
 *		String类型就是使用了享元模式。String对象是final类型，对象一旦创建就不可改变。
 *		享元模式可以分成单纯享元模式和复合享元模式两种形式。
 *
 *
 */
/*
 * 单纯享元模式
 * 				单纯的享元模式中，所有的享元对象都是可以共享的。
 * 单纯享元模式的角色：
 * 				抽象享元(Flyweight)角色 ：给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 * 				具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
 * 				享元工厂(FlyweightFactory)角色 ：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。
 * 											当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个符合要求
 * 											的享元对象。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个
 * 											适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。	
 */
public class FlyweightA {
	//抽象享元角色类
	interface Flyweight{
		void operation(String state);
	}
	//接口的具体实现
	class ConcreteFlyweight implements Flyweight{
		private Character  intrinsicState = null;
		//构造函数
		public ConcreteFlyweight(Character state) {
			this.intrinsicState=state;
		}
		
		//具体操作
		@Override
		public void operation(String state) {
			System.out.println("Intrinsic State = " + this.intrinsicState);
			System.out.println("Extrinsic State = " + state);
		}
		
	}
	//享元工厂类客户端不可以直接将具体享元类实例化，而必须通过一个工厂对象，
    //利用一个factory()方法得到享元对象。一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式。
	class FlyweightFactory {
		private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
		public Flyweight factory(Character state){
			//先从缓存中查找对象
	        Flyweight fly = files.get(state);
	        if (fly==null) {
				fly=new ConcreteFlyweight(state);
				files.put(state, fly);
			}
			return fly;
		}
	}
	
	
	public static void main(String[] args) {
		FlyweightA temp = new FlyweightA();
		//创建工厂
		 FlyweightFactory factory = temp.new FlyweightFactory();
		 //创建字符a
		 Flyweight fly = factory.factory(new Character('a'));
		 fly.operation("First Call");
		 fly = factory.factory(new Character('b'));
		 fly.operation("Second Call");
		 fly = factory.factory(new Character('a'));
		 fly.operation("Third Call");

	}

}
