package fengke.model.single;
/*
 *  预先初始化static变量 的单例模式 ：
 *				非Lazy  线程安全
 *	优点：
 *		线程安全
 *	缺点：
 *		非懒加载，如果构造的单例很大，构造完迟迟不使用，会导致资源浪费
 *
 *	分析：
 *		代码很简单，由于java的机制，static的成员变量只在类加载时初始化一次，且类的加载
 *		是线程安全的。所以这个方法实现的单例是线程安全的，但是它却牺牲了lazy的特性。单例在
 *		类加载的时候就已经实例化，如果资源迟迟不用，会导致资源浪费。
 *
 *	改进：
 *		通过使用内部类，然后通过私有化的内部类在getInstance（）方法中初始化static的instance
 * 
 *
 */
public class SingletonE {
			//饿汉式单例类.在类初始化时，已经自行实例化 
			//定义一个私有的自己的成员，并且赋值
			private static SingletonE instance=new SingletonE();
			//私有化构造器,确保外部不能通过构造器实例化。
			private SingletonE(){
			}
			//给外部提供一个获得实例的方法
			public static SingletonE getInstance(){
				return instance;
			}
}
