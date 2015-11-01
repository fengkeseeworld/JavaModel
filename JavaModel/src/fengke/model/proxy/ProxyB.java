package fengke.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

import fengke.model.proxy.ProxyA.ITask;

/*
 * ��̬����
 * 
 * ��飺
 * 		JDK��̬�������Դ�����ڳ��������ڼ��������JVM���ݷ���Ȼ��ƶ�̬�����ɣ�
 * 		���Բ����ڴ�������ֽ����ļ����ڴ�����ͱ��������������ʱȷ����
 * 		
 * 		��Java��Ҫ��ʵ�ֶ�̬������ƣ���Ҫjava.lang.reflect.InvocationHandler�ӿں� java.lang.reflect.Proxy���֧�֡�
 * 
 * JavaAPI��
 * 		java.lang.reflect.Proxy
 * 		java.lang.reflect.InvocationHandler
 * 
 * ��̬����ʵ�ֲ��裺
 * 		1��ʵ��InvocationHandler�ӿڴ����Լ��ĵ��ô����� 
 * 		2����Proxy���ṩClassLoader�ʹ���ӿ��������鴴����̬������
 * 		3���Ե��ô���������Ϊ���������÷�����Ƶõ���̬������Ĺ��캯�� 
 * 		4���Ե��ô���������Ϊ���������ö�̬������Ĺ��캯��������̬���������
 * 
 * �ŵ㣺
 * 		��̬�����뾲̬������Ƚϣ����ĺô��ǽӿ������������з�������ת�Ƶ����ô�����һ�����еķ����д���InvocationHandler.invoke����
 * 		�������ڽӿڷ��������Ƚ϶��ʱ�����ǿ��Խ�������������Ҫ��̬��������ÿһ������������ת���ڱ�ʾ���п�����������Ϊinvoke������
 * 		��Ƕ���˾������Χҵ�񣨼�¼������ǰ��ʱ�䲢����ʱ����ʵ���п�������Spring AOP����������Χҵ�񡣶�̬�����Ӧ��ʹ���ǵ���ְ��
 * 		���ӵ�һ�������Ը�ǿ��
 * 
 * ȱ�㣺
 * 		Proxy�Ѿ���Ƶ÷ǳ����������ǻ�����һ���СС���ź�֮�����Ǿ�����ʼ���޷����ѽ�֧�� interface�������������Ϊ�������ע��������ź���
 * 		JDK��̬����ֻ��Ϊʵ�ֽӿڵ�����д���û��ʵ�ֽӿڵ����޷�����
 * 		
 * 
 */
public class ProxyB {
	/*
	 * ��̬������ 
	 * 
	 * ͨ��ʵ�� InvocationHandler �ӿڴ����Լ��ĵ��ô�����
	 * 
	 * 
	 */
	
	//ҵ��ӿڣ�����ӿ�s��
		interface ITask{
			public void doTask(String taskName);

		}
		//��������࣬Ҳ��ҵ����
		class DealTask implements ITask{

			public void doTask(String taskName) {
				
				try {
					System.out.println("ִ������" + taskName);
					// �������һ��ʱ��
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	
	class JDKProxy implements InvocationHandler{
		//˽�л�  ��������Ķ���
		private Object dealTask;
		//��ʼ���������
		public JDKProxy(Object dealTask) {
			this.dealTask=dealTask;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
			// ��¼ҵ����ʼʱ��
			long startTime = System.currentTimeMillis();
			// ����ֵ��һ��Object����Ҳ�ǵ��ñ������෽���ķ���ֵ������ֻ��ʵ�ּ�ʱ���������Է���ֵΪnull
			method.invoke(dealTask, args);
			// ��¼ҵ�����ʱ��
			long endTime = System.currentTimeMillis();
			System.out.println("��������ִ��ʱ��Ϊ��" + (endTime - startTime + "����"));
			
			return null;
		}
			
	}
	
	//����
	public static void main(String[] args) {
		ProxyB proxy = new ProxyB();
		DealTask dealTask = proxy.new DealTask();
		// ��ȡ��̬���������
		JDKProxy jdkProxy = proxy.new JDKProxy(dealTask);
		ITask iTask = (ITask)Proxy.newProxyInstance(dealTask.getClass().getClassLoader(), dealTask.getClass().getInterfaces(), jdkProxy);
		iTask.doTask("��Լ�ڣ�������������");
	}
	

}
