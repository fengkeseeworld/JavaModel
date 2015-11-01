package fengke.model.single;
/*
 *  Ԥ�ȳ�ʼ��static���� �ĵ���ģʽ ��
 *				��Lazy  �̰߳�ȫ
 *	�ŵ㣺
 *		�̰߳�ȫ
 *	ȱ�㣺
 *		�������أ��������ĵ����ܴ󣬹�����ٳٲ�ʹ�ã��ᵼ����Դ�˷�
 *
 *	������
 *		����ܼ򵥣�����java�Ļ��ƣ�static�ĳ�Ա����ֻ�������ʱ��ʼ��һ�Σ�����ļ���
 *		���̰߳�ȫ�ġ������������ʵ�ֵĵ������̰߳�ȫ�ģ�������ȴ������lazy�����ԡ�������
 *		����ص�ʱ����Ѿ�ʵ�����������Դ�ٳٲ��ã��ᵼ����Դ�˷ѡ�
 *
 *	�Ľ���
 *		ͨ��ʹ���ڲ��࣬Ȼ��ͨ��˽�л����ڲ�����getInstance���������г�ʼ��static��instance
 * 
 *
 */
public class SingletonE {
			//����ʽ������.�����ʼ��ʱ���Ѿ�����ʵ���� 
			//����һ��˽�е��Լ��ĳ�Ա�����Ҹ�ֵ
			private static SingletonE instance=new SingletonE();
			//˽�л�������,ȷ���ⲿ����ͨ��������ʵ������
			private SingletonE(){
			}
			//���ⲿ�ṩһ�����ʵ���ķ���
			public static SingletonE getInstance(){
				return instance;
			}
}
