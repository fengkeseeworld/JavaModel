package fengke.model.proxy;

import java.lang.reflect.Method;
import java.util.Random;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * Cglib��̬����
 * 
 * ��飺
 * 
 * ����Ϊ����Ҫ���ʵ�Ŀ������ṩ��һ��;���������ʶ���ʱ����������һ����ӵĲ㡣
 * JDK�Դ�1.3�汾��ʼ���������˶�̬�������Ҿ�����������̬�ش�������JDK�Ķ�̬�����������ǳ��򵥣�
 * ������һ�����ƣ�����ʹ�ö�̬����Ķ������ʵ��һ�������ӿڡ�
 * 
 * Cglib���������ʵ�ִ���ģ�ʵ��ԭ����Ϊ�����������һ�����࣬ͨ�����ؼ������ظ��෽���ĵ��á�
 * 
 * 
 * 
 * 
 */
public class ProxyC {
	//ҵ��ʵ��
	public class Task1 {
		public void doTask() {
			 System.out.println("����ִ������");
			 try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	//������
	class CglibProxy implements MethodInterceptor{
		//��ͻ�����һ��������
		private Enhancer enhancer=new  Enhancer();
		
		//����������
		public Object getCglibProxy(Class c) {
			enhancer.setSuperclass(c);
			enhancer.setCallback(this);
			return enhancer.create();
		}
		/**
		 * @param obj  ������Ķ���
		 * @param method  ��������ķ���
		 * @param args �������෽���Ĳ���
		 * @param proxy ���������
		 */
		public Object intercept(Object obj, Method method, Object[] args,
				MethodProxy proxy) throws Throwable {
			//��¼ҵ����ʼʱ��
			long startTime=System.currentTimeMillis();
			/*
			 *   cglib�����ԭ�����Ϊ�������ࣨ���ࣩ�������࣬������ߵ����˸���super��
			 *   ����һ������Ķ��󡢲���������������
			 */
			proxy.invokeSuper(obj, args);
			long endTime=System.currentTimeMillis();//��¼ҵ�����ʱ��
			System.out.println("��������ִ��ʱ��Ϊ��"+(endTime-startTime+"����"));
			return null;
		}
	}
	//����
	public static void main(String[] args) {
		ProxyC proxy = new ProxyC();
		//��������
		CglibProxy cglibProxy=proxy.new CglibProxy();
		//Task task = (Task)cglibProxy.getCglibProxy(ProxyC.Task1.class);
		//����������
	    Task task = (Task)cglibProxy.getCglibProxy(Task.class);
	    task.doTask();
	}

}
