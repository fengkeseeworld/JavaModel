package fengke.model.single;
/*
 * 基于内部类的单例模式 :
 * 			Lazy  线程安全
 * 优点：
 * 		线程安全；lazy
 * 缺点：
 * 		待发现
 * 解释：
 * 		lazy：
 * 		解释一下，因为java机制规定，内部类SingletonHolder只有在getInstance()方法第一次调用
 * 		的时候才会被加载（实现了lazy），而且其加载过程是线程安全的（实现线程安全）。
 * 		内部类加载的时候实例化一次instance
 * 	
 */
public class SingletonF {
	//通过内部类实现lazy的加载机制
	private static class SingletonHolder{
	//单例变量
	private static SingletonF instance=new SingletonF();
	}
	//通过私有化构造器，使得外部不能创建实体类
	private SingletonF(){
		
	}
	//获取单例对象
	public static SingletonF getInstance(){
		return SingletonHolder.instance;
	}
	

}
