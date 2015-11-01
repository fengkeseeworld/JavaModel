package fengke.model.single;
/*
 * ͬ�������ĵ���ģʽ��
 * 			Lazyģʽ���̰߳�ȫ
 * �ŵ�:
 * 			1��lazy������ʹ��ʱʵ����������������Դ�˷�
 * 			2���̰߳�ȫ
 * ȱ�㣺
 * 			1��lazy�����ʵ����ʼ���ǳ���ʱ����ʼʹ��ʱ�����������������
 * 			2��ÿ�ε���getInstance()��Ҫ���ͬ�������������ġ�
 * 
 * ���ͣ�
 * 		synchronized��
 * 					ͬ��
 * 
 * 		��������������
 * 					�������� getInstance()����synchronized��ȷʵ�ܱ�֤���̵߳�
 * 					������ʣ��Ӷ���֤�̵߳İ�ȫ�����ǣ�������SingleA�е������ǣ������
 * 					���ڷ���if��instance==null��������ͬ�������󣬼��ڵ�һ�����ɵ���
 * 					ʱ�����ֵĲ�ͬ�����⡣�������ڷ����ϼ�synchronized����Ȼ����ʵ����
 * 					�̰�ȫ�����ǣ�������û��Ҫ���������ģ�ÿ�ε��÷�����ͬ����
 * 					�����ʵ�֣�ֻ���ڲ�������ʱ��ͬ�����ɡ�
 * 		
 */
public class SingletonB {
		//����ʽ������.�ڵ�һ�ε��õ�ʱ��ʵ����
		//����һ��˽�е��Լ��ĳ�Ա
		private static SingletonB instance=null;
		//˽�л�������,ȷ���ⲿ����ͨ��������ʵ������
		private SingletonB(){
		}
		//���ⲿ�ṩһ�����ʵ���ķ���
		//����getInstance()�����ϼ���synchronized�ؼ��֣�ʹ����ͬ��
		public static synchronized SingletonB getInstance(){
			if(instance==null){
				instance=new SingletonB();
			}
			return instance;
		}

}
