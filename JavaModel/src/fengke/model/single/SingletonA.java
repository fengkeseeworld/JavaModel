package fengke.model.single;
/**
 * 单例模式
 * @author 锋客
 *<br>	
 *<p>
 *声明：单例模式的内容来自：博客园
 *		http://www.cnblogs.com/coffee/archive/2011/12/05/inside-java-singleton.html
 *单例模式：
 *		特点：
 *			1、单例类只能有一个实例。
 *			2、单例类必须自己自己创建自己的唯一实例。
 *			3、单例类必须给所有其他对象提供这一实例。
 *		技术：
 *			私有化构造器======》防止外部定义对象
 *			通过static=====》实现单例生成
 *			synchronized==》线程安全
 *			
 *		分类：
 *			1、如果单例对象不大，允许非懒加载，可以使用方法三。
 *			2、如果需要懒加载，且允许一部分性能损耗，可以使用方法一。（官方说目前高版本的synchronized已经比较快了）
 *			3、如果需要懒加载，且不怕麻烦，可以使用方法二。
 *			4、如果需要懒加载，没有且！推荐使用方法四。 
 *			
 *			
 *</p>
 */
/*
 * 基础的单例模式：
 * 			Lazy模式，非线程安全
 * 	优点：
 * 			lazy，初次使用时实例化单例，避免资源浪费
 * 	缺点：
 * 			1、lazy，如果实例初始化非常耗时，初始使用时，可能造成性能问题
 * 			2、非线程安全。多线程下可能会有多个实例被初始化。
 * 	解释：
 *      非线程安全：
 *      		当前有两个线程：a，b
 *      		当线程a进入if(instance==null),此时为空
 *      		并且，线程b也进入到if(instance==null)，也为空，然后线程b创建实例返回。
 *      		切换至线程a，由于之前的判断为空，也饿会创建实例，并且返回，这样就会创建2个线程。
 * 	解决办法：
 * 			方法一：同步方法。即在getInstance()方法上加上synchronized关键字。  ===SingletonB.java
 * 			方法二：双重检查加锁Double-checked locking。===SingletonC.java
 * 			方法三：预先初始化static变量。===SingletonE.java
 * 			方法四：使用内部类。===SingletonF.java
 * 			方法五：使用反射机制。===SingletonG.java
 */
public class SingletonA {
	//定义一个私有的自己的成员
	private static SingletonA instance=null;
	//私有化构造器,确保外部不能通过构造器实例化。
	private SingletonA(){
	}
	//给外部提供一个获得实例的方法
	public static SingletonA getInstance(){
		if(instance==null){
			instance=new SingletonA();
		}
		return instance;
	}

}
