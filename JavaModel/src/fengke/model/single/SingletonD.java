package fengke.model.single;
/*
 * ˫�ؼ�����Double-checked locking�Ľ�һ���Ľ�
 * 
 * ������
 * 		����SingletonC.java�ĸĽ������Ƿ���java������еġ�����д���������̵߳Ĳ���ȫ
 * �Ľ���
 * 		ͨ�����һ���м����temp�����������д�������µ��̲߳���ȫ��
 * 
 * ���������
 * 		1.�߳�a����getInstance()����ΪinstanceΪ�գ����Խ���ͬ����һ
 * 		2.��Ϊtemp=instance�����Խ���ͬ����������г�ʼ��������instance����Ϊ�ǿգ���û���ù��췽��
 * 		3.��ʱa�������߳�b��ʼ���У�����a��ͬ����һ�У������߳�b���ж�if��instance==null���ɹ���ֻ�ܵȴ�
 * 		4.�߳�a���ִ�й���������ɸ�ֵtemp=new SingletonD();instance=temp;�˳�ͬ��������˳�ͬ����һ
 * 		5.�߳�a����ʵ�����߳�b����
 * 		6.�߳�b����ͬ����һ����������instanceʵ����ֵ����temp�ı��ر�������if(temp==null)�ж�Ϊ�٣����ܽ���ͬ�����
 * 		7.�߳�bȻ�󷵻�instance
 * 
 * 		�����й�������������������԰�ȫ�ȶ���ִ���ˣ����Ǵ���������ˣ����Ҹ��Ӹ����ˡ�
 * 
 */
public class SingletonD {
	//����һ��˽�е��Լ��ĳ�Ա
	private static SingletonD instance=null;
	//˽�л�������,ȷ���ⲿ����ͨ��������ʵ������
	private SingletonD(){
	}
	//���ⲿ�ṩһ�����ʵ���ķ���
	public static  SingletonD getInstance(){
		if(instance==null){
			//���ͬ����һ
			synchronized (SingletonD.class) {
				SingletonD temp=instance;
				if(temp==null){
					//���ͬ�����
					synchronized (SingletonD.class) {
						//������������������һ��ͬʱ��ɣ�˳��Ҳ��һ��
						temp=new SingletonD();
					}
				instance=temp;
				}
				
				
			}
		}
		return instance;
	}
}
