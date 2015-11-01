package fengke.model.single;
/*
 * ˫�ؼ�����Double-checked locking
 * 
 * ������
 * 		����SingtonB�ĸĽ������Ƿ���ֻҪ��֤instance = new SingletonOne(); ���̻߳������
 * 		�ľͿ��Ա�֤�̰߳�ȫ��
 * �Ľ���
 * 		�ǰ�ͬ���������Ը��죬ֻ��synchronized�������һ�䡣
 * 
 * 
 * �Y��������
 * 		��Ȼ��instance=new SingletonC();������ͬ���飬����������Ȼ���ڡ�	
 * 	����ԭ��
 *		javaƽ̨�ڴ�ģ������һ���С�����д����out-of-order writes���Ļ��ơ�
 *		����������Ƶ�����˫�ؼ�����������ʧЧ�� 	
 * 	������ͣ�
 * 		instance=new SingletonC();
 * 		��ʵ�����������飺1.���ù�����������һ��ʵ����2.��ʵ����ֵ��instance���ʵ��������
 * 		����������jvm�ǲ���֤˳��ġ������ڵ��ù�����֮ǰ��instance�Ѿ�������Ϊ�ǿ���
 * 		
 * 		1.�߳�a����if(instance==null)������
 * 		2.��Ϊ��ʱinstanceΪ�գ����Խ���synchronized��
 * 		3.�߳�aִ��instance=new SingletonC();��instance����Ϊ�ǿգ�ע�⣺�ڵ��ù��췽��֮ǰ��
 * 		4.�߳�a�˳����߳�b���롣
 * 		5.�߳�b���instance�Ƿ�Ϊ�գ���ʱ��Ϊ�գ��ڵ��������߳�a���óɷǿգ����߳�b����instance�����á�
 * 		������֣���ʱinstance�����ò�����SingletonThree��ʵ������Ϊû�е��ù��췽����
 * 		6.�߳�b�˳����߳�a���롣
 * 		7.�߳�a�������ù��췽�������instance�ĳ�ʼ����	
 * 		
 */
public class SingletonC {
			//����һ��˽�е��Լ��ĳ�Ա
			private static SingletonC instance=null;
			//˽�л�������,ȷ���ⲿ����ͨ��������ʵ������
			private SingletonC(){
			}
			//���ⲿ�ṩһ�����ʵ���ķ���
			public static  SingletonC getInstance(){
				if(instance==null){
					//���ͬ����
					synchronized (SingletonC.class) {
						//������������������һ��ͬʱ��ɣ�˳��Ҳ��һ��
						instance=new SingletonC();
					}
				}
				return instance;
			}
}
