package fengke.model.factoryandabstract;
/**
 * 工厂模式
 * 
 * 申明：摘自博客园       http://www.cnblogs.com/lichenwei/p/4213611.html
 * 
 * @author 锋客
 * 
 * 简述：
 * 		定义：
 * 			工厂模式是最常用的实例化对象模式，是用工厂方法代替new操作的一种模式。著名的Jive论坛 ,就大量使用了工厂模式，
 * 			工厂模式在Java程序系统可以说是随处可见。因为工厂模式就相当于创建实例对象的new，我们经常要根据类Class生成实例对象，
 * 			如A a=new A() 工厂模式也是用来创建实例对象的，所以new对象时要注意，是否可以考虑使用工厂模式，虽然这样做，
 * 			可能多做一些工作，但会给你系统带来更大的可扩展性和尽量少的修改量。
 * 			简单点来说，工厂模式就是提供一个产生实例化对象的制造厂，每一个工厂都会提供类似的对象（实现共同接口），当我们需要某个类的实例化对象时，
 * 			我们不需要关心服务端是通过什么方式来获取对象的，我们直接向对应的工厂提出我们的需求即可（实现了客户端和服务端的分离）。
 * 		
 * 		分类：
 * 			1、简单工厂模式（Simple Factory）
 * 			2、工厂方法模式（Factory Method）
 * 			3、抽象工厂模式（Abstract Factory）
 * 			一般我们把简单工厂模式也归为工厂方法模式，然后抽象工厂模式是工厂方法模式的扩展。
 * 
 *
 */
/*
 * 		工厂方法模式：
 * 				
 * 		组成：
 * 			工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑。在java中它往往由一个具体类实现。
 * 			抽象产品角色：它一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类来实现。
 * 			具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。 
 * 			
 * 
 * 
 * 
 */
public class FactoryA {
	//一个肤色的接口
	interface SkinInterface{
		void skin();
	}
	//定义一个黄种人的实现类
	class YellowPerson implements SkinInterface{

		public void skin() {
			System.out.println("我是黄种人");
		}
		
	}
	//定义一个白种人的实现类
	class WhitePerson implements SkinInterface{

		public void skin() {
			System.out.println("我是白种人");
		}
		
	}
	//定义一个黑种人的实现类
	class BlackPerson implements SkinInterface{

		public void skin() {
			System.out.println("我是黑种人");
		}
		
	}
	//对象（不同种类的人）的生产工厂
	class SkinFactory{
		//type 作为创建对象的条件
		public SkinInterface getSkin(String type){
			switch (type) {
			case "yellow":
				return new YellowPerson();
			case "white":
				return new WhitePerson();
			case "black":
				return new BlackPerson();
			default:
				return null;
			}
			
		}
	}
	
	//测试
	public static void main(String[] args) {
		//创建一个FactoryA
		FactoryA fac = new FactoryA();
		//创建一个SkinFactory，用于生产对象
		SkinFactory fac_skin = fac.new SkinFactory();
		//生产
		System.out.println("========工厂方法模式==========");
		fac_skin.getSkin("black").skin();
		fac_skin.getSkin("white").skin();
		fac_skin.getSkin("yellow").skin();
	}
	
}



