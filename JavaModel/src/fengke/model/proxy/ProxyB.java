package fengke.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

import fengke.model.proxy.ProxyA.ITask;

/*
 * 动态代理
 * 
 * 简介：
 * 		JDK动态代理类的源码是在程序运行期间由虚拟机JVM根据反射等机制动态的生成，
 * 		所以不存在代理类的字节码文件。在代理类和被代理类程序运行时确定。
 * 		
 * 		在Java中要想实现动态代理机制，需要java.lang.reflect.InvocationHandler接口和 java.lang.reflect.Proxy类的支持。
 * 
 * JavaAPI：
 * 		java.lang.reflect.Proxy
 * 		java.lang.reflect.InvocationHandler
 * 
 * 动态代理实现步骤：
 * 		1、实现InvocationHandler接口创建自己的调用处理器 
 * 		2、给Proxy类提供ClassLoader和代理接口类型数组创建动态代理类
 * 		3、以调用处理器类型为参数，利用反射机制得到动态代理类的构造函数 
 * 		4、以调用处理器对象为参数，利用动态代理类的构造函数创建动态代理类对象
 * 
 * 优点：
 * 		动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。
 * 		这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。在本示例中看不出来，因为invoke方法体
 * 		内嵌入了具体的外围业务（记录任务处理前后时间并计算时间差），实际中可以类似Spring AOP那样配置外围业务。动态代理的应用使我们的类职责
 * 		更加单一，复用性更强。
 * 
 * 缺点：
 * 		Proxy已经设计得非常优美，但是还是有一点点小小的遗憾之处，那就是它始终无法摆脱仅支持 interface代理的桎梏，因为它的设计注定了这个遗憾。
 * 		JDK动态代理只能为实现接口的类进行代理，没有实现接口的类无法代理。
 * 		
 * 
 */
public class ProxyB {
	/*
	 * 动态代理类 
	 * 
	 * 通过实现 InvocationHandler 接口创建自己的调用处理器
	 * 
	 * 
	 */
	
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
	
	
	class JDKProxy implements InvocationHandler{
		//私有化  被代理类的对象
		private Object dealTask;
		//初始化代理对象
		public JDKProxy(Object dealTask) {
			this.dealTask=dealTask;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
			// 记录业务起始时间
			long startTime = System.currentTimeMillis();
			// 返回值是一个Object对象也是调用被代理类方法的返回值（这里只是实现计时操作，所以返回值为null
			method.invoke(dealTask, args);
			// 记录业务结束时间
			long endTime = System.currentTimeMillis();
			System.out.println("本次任务执行时间为：" + (endTime - startTime + "毫秒"));
			
			return null;
		}
			
	}
	
	//测试
	public static void main(String[] args) {
		ProxyB proxy = new ProxyB();
		DealTask dealTask = proxy.new DealTask();
		// 获取动态代理类对象
		JDKProxy jdkProxy = proxy.new JDKProxy(dealTask);
		ITask iTask = (ITask)Proxy.newProxyInstance(dealTask.getClass().getClassLoader(), dealTask.getClass().getInterfaces(), jdkProxy);
		iTask.doTask("在约炮：。。。。。。");
	}
	

}
