package fengke.model.single;
/*
 * �����ڲ���ĵ���ģʽ :
 * 			Lazy  �̰߳�ȫ
 * �ŵ㣺
 * 		�̰߳�ȫ��lazy
 * ȱ�㣺
 * 		������
 * ���ͣ�
 * 		lazy��
 * 		����һ�£���Ϊjava���ƹ涨���ڲ���SingletonHolderֻ����getInstance()������һ�ε���
 * 		��ʱ��Żᱻ���أ�ʵ����lazy������������ع������̰߳�ȫ�ģ�ʵ���̰߳�ȫ����
 * 		�ڲ�����ص�ʱ��ʵ����һ��instance
 * 	
 */
public class SingletonF {
	//ͨ���ڲ���ʵ��lazy�ļ��ػ���
	private static class SingletonHolder{
	//��������
	private static SingletonF instance=new SingletonF();
	}
	//ͨ��˽�л���������ʹ���ⲿ���ܴ���ʵ����
	private SingletonF(){
		
	}
	//��ȡ��������
	public static SingletonF getInstance(){
		return SingletonHolder.instance;
	}
	

}
