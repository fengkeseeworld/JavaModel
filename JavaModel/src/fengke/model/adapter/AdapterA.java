package fengke.model.adapter;
/**
 * ������ģʽ
 * 		������
 * 			��Դ����԰��http://www.cnblogs.com/springside5/archive/2012/03/14/2486059.html
 * @author ���
 * 
 * ��飺
 * 		��һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿڡ�Adapterģʽʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ�����һ������
 * ���
 * 		1���������� ��ͨ���̳еķ�ʽ��
 * 		2������������ ����ȡ������ϵ�ģʽ��
 *
 */
/*
 * ��������
 */
public class AdapterA {
	 //������
	interface Target{  
	    public void method() ;  
	  
	}  
	//����������
	class Adaptee{
	  void method2() {
		  System.out.println("Adapter-->method2()") ;  
		}
	}
	//��������
	class Adapter extends Adaptee implements Target{

		@Override
		public void method() {
			super.method2() ;//����this.method2() ;  
		}
		
	}
	public static void main(String[] args) {
		AdapterA temp = new AdapterA();
		Target t = temp.new Adapter() ;
		t.method();
	}


}
