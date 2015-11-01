package fengke.model.single;
/**
 * ����ģʽ
 * @author ���
 *<br>	
 *<p>
 *����������ģʽ���������ԣ�����԰
 *		http://www.cnblogs.com/coffee/archive/2011/12/05/inside-java-singleton.html
 *����ģʽ��
 *		�ص㣺
 *			1��������ֻ����һ��ʵ����
 *			2������������Լ��Լ������Լ���Ψһʵ����
 *			3�������������������������ṩ��һʵ����
 *		������
 *			˽�л�������======����ֹ�ⲿ�������
 *			ͨ��static=====��ʵ�ֵ�������
 *			synchronized==���̰߳�ȫ
 *			
 *		���ࣺ
 *			1������������󲻴�����������أ�����ʹ�÷�������
 *			2�������Ҫ�����أ�������һ����������ģ�����ʹ�÷���һ�����ٷ�˵Ŀǰ�߰汾��synchronized�Ѿ��ȽϿ��ˣ�
 *			3�������Ҫ�����أ��Ҳ����鷳������ʹ�÷�������
 *			4�������Ҫ�����أ�û���ң��Ƽ�ʹ�÷����ġ� 
 *			
 *			
 *</p>
 */
/*
 * �����ĵ���ģʽ��
 * 			Lazyģʽ�����̰߳�ȫ
 * 	�ŵ㣺
 * 			lazy������ʹ��ʱʵ����������������Դ�˷�
 * 	ȱ�㣺
 * 			1��lazy�����ʵ����ʼ���ǳ���ʱ����ʼʹ��ʱ�����������������
 * 			2�����̰߳�ȫ�����߳��¿��ܻ��ж��ʵ������ʼ����
 * 	���ͣ�
 *      ���̰߳�ȫ��
 *      		��ǰ�������̣߳�a��b
 *      		���߳�a����if(instance==null),��ʱΪ��
 *      		���ң��߳�bҲ���뵽if(instance==null)��ҲΪ�գ�Ȼ���߳�b����ʵ�����ء�
 *      		�л����߳�a������֮ǰ���ж�Ϊ�գ�Ҳ���ᴴ��ʵ�������ҷ��أ������ͻᴴ��2���̡߳�
 * 	����취��
 * 			����һ��ͬ������������getInstance()�����ϼ���synchronized�ؼ��֡�  ===SingletonB.java
 * 			��������˫�ؼ�����Double-checked locking��===SingletonC.java
 * 			��������Ԥ�ȳ�ʼ��static������===SingletonE.java
 * 			�����ģ�ʹ���ڲ��ࡣ===SingletonF.java
 * 			�����壺ʹ�÷�����ơ�===SingletonG.java
 */
public class SingletonA {
	//����һ��˽�е��Լ��ĳ�Ա
	private static SingletonA instance=null;
	//˽�л�������,ȷ���ⲿ����ͨ��������ʵ������
	private SingletonA(){
	}
	//���ⲿ�ṩһ�����ʵ���ķ���
	public static SingletonA getInstance(){
		if(instance==null){
			instance=new SingletonA();
		}
		return instance;
	}

}
