package fengke.model.facade;

import javax.swing.Box;

/**
 * ���ģʽ
 * ������
 *   ��Դ����԰   http://www.cnblogs.com/Coda/p/4297876.html
 * @author ���
 * ��飺
 * 		���ģʽ��Facade���Ķ��壺Ϊ��ϵͳ�е�һ��ӿ��ṩһ��һ�µĽ���
 * 
 *������
 *		�ŵ㣺
 *			�Կͻ�������ϵͳ����������˿ͻ�����Ķ�����Ŀ��ʹ����ϵͳʹ�������������ס�
 *			ͬʱ���ͻ�������ʵ������ϵͳ��ͻ�֮�������Ϲ�ϵ��       
 *			 �����˴������ϵͳ�еı��������ԣ�������ϵͳ�ڲ�ͬƽ̨֮�����ֲ���̡�
 *			ֻ���ṩ��һ��������ϵͳ��ͳһ��ڣ�����Ӱ���û�ֱ��ʹ����ϵͳ�ࡣ
 *		ȱ�㣺
 *			���ܺܺõ����ƿͻ�ʹ����ϵͳ�࣬����Կͻ�������ϵͳ����̫�������������˿ɱ��Ժ�����ԡ�
 *			�ڲ������������������£������µ���ϵͳ������Ҫ�޸�������ͻ��˵�Դ���룬Υ���ˡ�����ԭ�򡱡�
 *
 *
 *
 *Ӧ�ó�����
 *			1��Ϊһ��������ϵͳ�ṩһ���򵥽ӿڡ�
 *			2�������ϵͳ�Ķ����ԡ�
 *			3���ڲ�λ��ṹ�У�����ʹ��Facadeģʽ����ϵͳ��ÿһ�����ڡ�
 */
public class FacadeA {
	//����
	class Box_open{
		void open(){
			System.out.println("�ѱ����Ŵ�");
		}
	}
	//�Ѵ���װ��ȥ
	class Elephant{
	void	pack(){
		System.out.println("�Ѵ���װ��ȥ");
	}
	
	}
	//������
	class Box_close{
		void close(){
			System.out.println("�ѱ����Ź���");

		}
	}
	//���ⲿ���ķ���
	class Facade{
		 private Box_open open = new Box_open();
		 private Elephant elephant = new Elephant();
		 private Box_close close = new Box_close();
		 
		 public void methodA(){
		 this.open.open();
		 this.elephant.pack();
		 this.close.close();
		 }
	
	 }
	public static void main(String[] args) {
		FacadeA temp = new FacadeA();
		temp.new Facade().methodA();
	}

}
