package fengke.model.single;
/*
 * 双重检查加锁Double-checked locking
 * 
 * 分析：
 * 		经过SingtonB的改进，我们发现只要保证instance = new SingletonOne(); 是线程互斥访问
 * 		的就可以保证线程安全。
 * 改进：
 * 		那把同步方法加以改造，只用synchronized块包裹这一句。
 * 
 * 
 * 結果分析：
 * 		虽然将instance=new SingletonC();放入了同步块，但是问题任然存在。	
 * 	核心原因：
 *		java平台内存模型中有一个叫“无序写”（out-of-order writes）的机制。
 *		正是这个机制导致了双重检查加锁方法的失效。 	
 * 	结果解释：
 * 		instance=new SingletonC();
 * 		其实做了两件事情：1.调用构造器，创建一个实例；2.把实例赋值给instance这个实例变量，
 * 		但是这两步jvm是不保证顺序的。即，在调用构造器之前，instance已经被设置为非空了
 * 		
 * 		1.线程a进入if(instance==null)方法；
 * 		2.因为此时instance为空，所以进入synchronized块
 * 		3.线程a执行instance=new SingletonC();把instance设置为非空（注意：在调用构造方法之前）
 * 		4.线程a退出，线程b进入。
 * 		5.线程b检查instance是否为空，此时不为空（在第三步被线程a设置成非空），线程b返回instance的引用。
 * 		问题出现：这时instance的引用并不是SingletonThree的实例，因为没有调用构造方法。
 * 		6.线程b退出，线程a进入。
 * 		7.线程a继续调用构造方法，完成instance的初始化。	
 * 		
 */
public class SingletonC {
			//定义一个私有的自己的成员
			private static SingletonC instance=null;
			//私有化构造器,确保外部不能通过构造器实例化。
			private SingletonC(){
			}
			//给外部提供一个获得实例的方法
			public static  SingletonC getInstance(){
				if(instance==null){
					//添加同步块
					synchronized (SingletonC.class) {
						//这里有两步操作，不一定同时完成，顺序也不一定
						instance=new SingletonC();
					}
				}
				return instance;
			}
}
