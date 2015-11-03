package fengke.model.proxy;

import java.util.Random;

/**
 * 代理模式
 * 声明：
 * 		摘自博客园  http://www.cnblogs.com/lichenwei/p/4200992.html
 * @author 锋客
 * 
 * 简介：
 * 		代理模式，又称委托模式
 * 
 * 概念：
 * 		为某个对象提供一个代理，以控制对这个对象的访问。 代理类和被代理类有共同的父类或父接口，
 * 		这样在任何使用被代理类对象的地方都可以用代理对象替代。
 * 		代理类负责请求的预处理、过滤、将请求分派给被代理类处理、以及被代理类执行完请求后的后续处理。
 * 
 *proxy.PNG  解释： 		
 * 		代理接口（Subject）、代理类（ProxySubject）、被代理类（RealSubject）形成一个"品"字结构。
 * 		代理类和被代理类都同时实现了代理接口，然后代理类通过引用被代理类的对象，来处理用户的访问请求。
 * 
 * 分类：
 * 		一种是静态代理，一种是动态代理。
 * 
 */

/*
 * 静态代理
 * 
 * 简介：
 * 		由开发人员创建或某工具生成代理类的源码，再编译代理类。所谓静态也就是在程序运行前就已经存在代理类的字节码文件，
 * 		在代理类和被代理类运行前就确定了。 
 * 		在程序运行前，代理类的.class文件就已经存在了
 * 
 * 总结：
 * 		主程序创建一个业务对象，然后将对象交给代理类进行操作。
 * 		代理类与业务对象由于实现了相同的接口，可以将业务对象私有化为自己的属性，然后通过构造方法将其传入
 * 
 * 优点：
 * 		被代理类只需要去关注主要的业务实现，其余操作比如日志记录，计时，权限控制等都可以交给代理类去额外的处理。
 * 
 * 缺点：
 * 		很多个业务方法都实现计时功能，如果这些方法分布在不同的类，那么是不是要为每一个类再单独的去创建代理类，长久下来，类体积会膨胀会爆炸的。
 * 
 * 		我们现在额外的要扩展业务，在代理接口里添加新的业务方法，那么除了被代理类要去实现这个方法以外，
 * 		是不是所有的代理类也都要去额外的添加实现这个方法，所谓的"牵一发而动全身"，需要额外的添加大量的重复代码，这是违背软件设计原则的。
 * 		
 * 		代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
 * 
 * 问题：
 * 		如何实现了静态的代理，静态体现在何处?
 * 				静态：所有的代理对象，被代理对象都在程序运行前装载完成。
 * 		为什么代理类和被代理类要实现相同的业务接口？
 * 				
 * 
 */
public class ProxyA {
	//业务接口（代理接口s）
	interface ITask{
		public void doTask(String taskName);

	}
	//被代理的类，也叫业务类
	class DealTask implements ITask{

		public void doTask(String taskName) {
			
			try {
				System.out.println("执行任务：" + taskName);
				// 随机休眠一段时间
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	//代理类
	class ProxyTask implements ITask{
		//利用构造方法引用一个被代理类的对象为己持有
		private ITask dealTask;
		//《！——--重点--——》
		//引用一个被代理类的对象
		public ProxyTask(ITask dealTask) {
			this.dealTask=dealTask;
		}
		
		public void doTask(String taskName) {
			//记录业务起始时间
			long startTime=System.currentTimeMillis();
			//执行被代理类的主要业务
			dealTask.doTask(taskName);
			//记录业务结束时间
			long endTime=System.currentTimeMillis();
			//输出
			System.out.println("本次任务执行时间为："+(endTime-startTime+"毫秒"));
		}
	}
	//测试方法
	public static void main(String[] args) {
		 ProxyA proxy = new ProxyA();
		 //获取被代理类的对象
		 ITask dealTask=proxy.new DealTask();
	     //将被代理类的对象注入,获取静态代理类对象
		 ITask proxyTask=proxy.new ProxyTask(dealTask);
		 proxyTask.doTask("打喷嚏..");


	}
	

}
