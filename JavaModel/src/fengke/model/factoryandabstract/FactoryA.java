package fengke.model.factoryandabstract;
/**
 * ����ģʽ
 * 
 * ������ժ�Բ���԰       http://www.cnblogs.com/lichenwei/p/4213611.html
 * 
 * @author ���
 * 
 * ������
 * 		���壺
 * 			����ģʽ����õ�ʵ��������ģʽ�����ù�����������new������һ��ģʽ��������Jive��̳ ,�ʹ���ʹ���˹���ģʽ��
 * 			����ģʽ��Java����ϵͳ����˵���洦�ɼ�����Ϊ����ģʽ���൱�ڴ���ʵ�������new�����Ǿ���Ҫ������Class����ʵ������
 * 			��A a=new A() ����ģʽҲ����������ʵ������ģ�����new����ʱҪע�⣬�Ƿ���Կ���ʹ�ù���ģʽ����Ȼ��������
 * 			���ܶ���һЩ�������������ϵͳ��������Ŀ���չ�Ժ;����ٵ��޸�����
 * 			�򵥵���˵������ģʽ�����ṩһ������ʵ������������쳧��ÿһ�����������ṩ���ƵĶ���ʵ�ֹ�ͬ�ӿڣ�����������Ҫĳ�����ʵ��������ʱ��
 * 			���ǲ���Ҫ���ķ������ͨ��ʲô��ʽ����ȡ����ģ�����ֱ�����Ӧ�Ĺ���������ǵ����󼴿ɣ�ʵ���˿ͻ��˺ͷ���˵ķ��룩��
 * 		
 * 		���ࣺ
 * 			1���򵥹���ģʽ��Simple Factory��
 * 			2����������ģʽ��Factory Method��
 * 			3�����󹤳�ģʽ��Abstract Factory��
 * 			һ�����ǰѼ򵥹���ģʽҲ��Ϊ��������ģʽ��Ȼ����󹤳�ģʽ�ǹ�������ģʽ����չ��
 * 
 *
 */
/*
 * 		��������ģʽ��
 * 				
 * 		��ɣ�
 * 			�������ɫ�����Ǳ�ģʽ�ĺ��ģ�����һ������ҵ�߼����ж��߼�����java����������һ��������ʵ�֡�
 * 			�����Ʒ��ɫ����һ���Ǿ����Ʒ�̳еĸ������ʵ�ֵĽӿڡ���java���ɽӿڻ��߳�������ʵ�֡�
 * 			�����Ʒ��ɫ���������������Ķ�����Ǵ˽�ɫ��ʵ������java����һ��������ʵ�֡� 
 * 			
 * 
 * 
 * 
 */
public class FactoryA {
	//һ����ɫ�Ľӿ�
	interface SkinInterface{
		void skin();
	}
	//����һ�������˵�ʵ����
	class YellowPerson implements SkinInterface{

		public void skin() {
			System.out.println("���ǻ�����");
		}
		
	}
	//����һ�������˵�ʵ����
	class WhitePerson implements SkinInterface{

		public void skin() {
			System.out.println("���ǰ�����");
		}
		
	}
	//����һ�������˵�ʵ����
	class BlackPerson implements SkinInterface{

		public void skin() {
			System.out.println("���Ǻ�����");
		}
		
	}
	//���󣨲�ͬ������ˣ�����������
	class SkinFactory{
		//type ��Ϊ�������������
		public SkinInterface getSkin(String type){
			switch (type) {
			case "yellow":
				return new YellowPerson();
			case "white":
				return new WhitePerson();
			case "black":
				return new BlackPerson();
			default:
				return null;
			}
			
		}
	}
	
	//����
	public static void main(String[] args) {
		//����һ��FactoryA
		FactoryA fac = new FactoryA();
		//����һ��SkinFactory��������������
		SkinFactory fac_skin = fac.new SkinFactory();
		//����
		System.out.println("========��������ģʽ==========");
		fac_skin.getSkin("black").skin();
		fac_skin.getSkin("white").skin();
		fac_skin.getSkin("yellow").skin();
	}
	
}



