package fengke.model.single;
/*
 * 双重检查加锁Double-checked locking的进一步改进
 * 
 * 分析：
 * 		经过SingletonC.java的改进，我们发现java虚拟机中的“无序写”导致了线程的不安全
 * 改进：
 * 		通过添加一个中间变量temp，解决“无序写”所导致的线程不安全。
 * 
 * 结果分析：
 * 		1.线程a进入getInstance()，因为instance为空，所以进入同步块一
 * 		2.因为temp=instance，所以进入同步块二，进行初始化，并且instance设置为非空，但没调用构造方法
 * 		3.此时a阻塞，线程b开始运行，由于a在同步块一中，所以线程b在判断if（instance==null）成功后只能等待
 * 		4.线程a激活，执行构造器，完成赋值temp=new SingletonD();instance=temp;退出同步块二，退出同步块一
 * 		5.线程a返回实例，线程b激活
 * 		6.线程b进入同步块一，但是由于instance实例赋值给了temp的本地变量，则if(temp==null)判定为假，不能进入同步块二
 * 		7.线程b然后返回instance
 * 
 * 		从运行过程来看，整个程序可以安全稳定的执行了，但是代码量变大了，而且更加复杂了。
 * 
 */
public class SingletonD {
	//定义一个私有的自己的成员
	private static SingletonD instance=null;
	//私有化构造器,确保外部不能通过构造器实例化。
	private SingletonD(){
	}
	//给外部提供一个获得实例的方法
	public static  SingletonD getInstance(){
		if(instance==null){
			//添加同步块一
			synchronized (SingletonD.class) {
				SingletonD temp=instance;
				if(temp==null){
					//添加同步快二
					synchronized (SingletonD.class) {
						//这里有两步操作，不一定同时完成，顺序也不一定
						temp=new SingletonD();
					}
				instance=temp;
				}
				
				
			}
		}
		return instance;
	}
}
