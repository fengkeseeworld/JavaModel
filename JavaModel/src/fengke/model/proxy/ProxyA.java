package fengke.model.proxy;

import java.util.Random;

/**
 * ����ģʽ
 * ������
 * 		ժ�Բ���԰  http://www.cnblogs.com/lichenwei/p/4200992.html
 * @author ���
 * 
 * ��飺
 * 		����ģʽ���ֳ�ί��ģʽ
 * 
 * ���
 * 		Ϊĳ�������ṩһ�������Կ��ƶ��������ķ��ʡ� ������ͱ��������й�ͬ�ĸ���򸸽ӿڣ�
 * 		�������κ�ʹ�ñ����������ĵط��������ô�����������
 * 		�����ฺ�������Ԥ�������ˡ���������ɸ��������ദ���Լ���������ִ���������ĺ�������
 * 
 *proxy.PNG  ���ͣ� 		
 * 		����ӿڣ�Subject���������ࣨProxySubject�����������ࣨRealSubject���γ�һ��"Ʒ"�ֽṹ��
 * 		������ͱ������඼ͬʱʵ���˴���ӿڣ�Ȼ�������ͨ�����ñ�������Ķ����������û��ķ�������
 * 
 * ���ࣺ
 * 		һ���Ǿ�̬����һ���Ƕ�̬����
 * 
 */

/*
 * ��̬����
 * 
 * ��飺
 * 		�ɿ�����Ա������ĳ�������ɴ������Դ�룬�ٱ�������ࡣ��ν��̬Ҳ�����ڳ�������ǰ���Ѿ����ڴ�������ֽ����ļ���
 * 		�ڴ�����ͱ�����������ǰ��ȷ���ˡ� 
 * 		�ڳ�������ǰ���������.class�ļ����Ѿ�������
 * 
 * �ܽ᣺
 * 		�����򴴽�һ��ҵ�����Ȼ�󽫶��󽻸���������в�����
 * 		��������ҵ���������ʵ������ͬ�Ľӿڣ����Խ�ҵ�����˽�л�Ϊ�Լ������ԣ�Ȼ��ͨ�����췽�����䴫��
 * 
 * �ŵ㣺
 * 		��������ֻ��Ҫȥ��ע��Ҫ��ҵ��ʵ�֣��������������־��¼����ʱ��Ȩ�޿��Ƶȶ����Խ���������ȥ����Ĵ���
 * 
 * ȱ�㣺
 * 		�ܶ��ҵ�񷽷���ʵ�ּ�ʱ���ܣ������Щ�����ֲ��ڲ�ͬ���࣬��ô�ǲ���ҪΪÿһ�����ٵ�����ȥ���������࣬��������������������ͻᱬը�ġ�
 * 
 * 		�������ڶ����Ҫ��չҵ���ڴ���ӿ�������µ�ҵ�񷽷�����ô���˱�������Ҫȥʵ������������⣬
 * 		�ǲ������еĴ�����Ҳ��Ҫȥ��������ʵ�������������ν��"ǣһ������ȫ��"����Ҫ�������Ӵ������ظ����룬����Υ��������ԭ��ġ�
 * 		
 * 		�������ֻ������һ�����͵Ķ������Ҫ��������͵Ķ����Ʊ�ҪΪÿһ�ֶ��󶼽��д�����̬�����ڳ����ģ�Դ�ʱ���޷�ʤ���ˡ�
 * 
 * ���⣺
 * 		���ʵ���˾�̬�Ĵ�����̬�����ںδ�?
 * 				��̬�����еĴ�����󣬱���������ڳ�������ǰװ����ɡ�
 * 		Ϊʲô������ͱ�������Ҫʵ����ͬ��ҵ��ӿڣ�
 * 				
 * 
 */
public class ProxyA {
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
	//������
	class ProxyTask implements ITask{
		//���ù��췽������һ����������Ķ���Ϊ������
		private ITask dealTask;
		//��������--�ص�--������
		//����һ����������Ķ���
		public ProxyTask(ITask dealTask) {
			this.dealTask=dealTask;
		}
		
		public void doTask(String taskName) {
			//��¼ҵ����ʼʱ��
			long startTime=System.currentTimeMillis();
			//ִ�б����������Ҫҵ��
			dealTask.doTask(taskName);
			//��¼ҵ�����ʱ��
			long endTime=System.currentTimeMillis();
			//���
			System.out.println("��������ִ��ʱ��Ϊ��"+(endTime-startTime+"����"));
		}
	}
	//���Է���
	public static void main(String[] args) {
		 ProxyA proxy = new ProxyA();
		 //��ȡ��������Ķ���
		 ITask dealTask=proxy.new DealTask();
	     //����������Ķ���ע��,��ȡ��̬���������
		 ITask proxyTask=proxy.new ProxyTask(dealTask);
		 proxyTask.doTask("������..");


	}
	

}
