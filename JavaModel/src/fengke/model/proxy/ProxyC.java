package fengke.model.proxy;

import java.lang.reflect.Method;
import java.util.Random;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * Cglib动态代理
 * 
 * 简介：
 * 
 * 代理为控制要访问的目标对象提供了一种途径。当访问对象时，它引入了一个间接的层。
 * JDK自从1.3版本开始，就引入了动态代理，并且经常被用来动态地创建代理。JDK的动态代理用起来非常简单，
 * 但它有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
 * 
 * Cglib是针对类来实现代理的，实现原理是为被代理类产生一个子类，通过拦截技术拦截父类方法的调用。
 * 
 * 
 * 
 * 
 */
public class ProxyC {
	//业务实体
	public class Task1 {
		public void doTask() {
			 System.out.println("我在执行任务");
			 try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	//代理类
	class CglibProxy implements MethodInterceptor{
		//向客户返回一个代理类
		private Enhancer enhancer=new  Enhancer();
		
		//产生代理类
		public Object getCglibProxy(Class c) {
			enhancer.setSuperclass(c);
			enhancer.setCallback(this);
			return enhancer.create();
		}
		/**
		 * @param obj  被代理的对象
		 * @param method  被代理类的方法
		 * @param args 被代理类方法的参数
		 * @param proxy 代理类对象
		 */
		public Object intercept(Object obj, Method method, Object[] args,
				MethodProxy proxy) throws Throwable {
			//记录业务起始时间
			long startTime=System.currentTimeMillis();
			/*
			 *   cglib代理的原理就是为被代理类（父类）创建子类，所以这边调用了父类super，
			 *   参数一：父类的对象、参数二：方法参数
			 */
			proxy.invokeSuper(obj, args);
			long endTime=System.currentTimeMillis();//记录业务结束时间
			System.out.println("本次任务执行时间为："+(endTime-startTime+"毫秒"));
			return null;
		}
	}
	//测试
	public static void main(String[] args) {
		ProxyC proxy = new ProxyC();
		//创建代理
		CglibProxy cglibProxy=proxy.new CglibProxy();
		//Task task = (Task)cglibProxy.getCglibProxy(ProxyC.Task1.class);
		//产生代理类
	    Task task = (Task)cglibProxy.getCglibProxy(Task.class);
	    task.doTask();
	}

}
