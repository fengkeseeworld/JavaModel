package fengke.model.single;
/*
 * 同步方法的单例模式：
 * 			Lazy模式，线程安全
 * 优点:
 * 			1、lazy，初次使用时实例化单例，避免资源浪费
 * 			2、线程安全
 * 缺点：
 * 			1、lazy，如果实例初始化非常耗时，初始使用时，可能造成性能问题
 * 			2、每次调用getInstance()都要获得同步锁，性能消耗。
 * 
 * 解释：
 * 		synchronized：
 * 					同步
 * 
 * 		性能消耗提升：
 * 					当给方法 getInstance()加上synchronized后，确实能保证，线程的
 * 					互斥访问，从而保证线程的安全。但是，我们在SingleA中的问题是：多个线
 * 					程在访问if（instance==null）产生不同步的现象，及在第一次生成单例
 * 					时所出现的不同步问题。而现在在方法上加synchronized，虽然可以实现线
 * 					程安全，但是，产生了没必要的性能消耗：每次调用方法都同步。
 * 					理想的实现：只有在产生单例时，同步即可。
 * 		
 */
public class SingletonB {
		//懒汉式单例类.在第一次调用的时候实例化
		//定义一个私有的自己的成员
		private static SingletonB instance=null;
		//私有化构造器,确保外部不能通过构造器实例化。
		private SingletonB(){
		}
		//给外部提供一个获得实例的方法
		//即在getInstance()方法上加上synchronized关键字，使方法同步
		public static synchronized SingletonB getInstance(){
			if(instance==null){
				instance=new SingletonB();
			}
			return instance;
		}

}
