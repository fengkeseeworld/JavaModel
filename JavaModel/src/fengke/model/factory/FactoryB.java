package fengke.model.factory;
/*
 * 		���󹤳�ģʽ
 * 				���壺
 * 					�ڳ��󹤳�ģʽ�У������Ʒ (AbstractProduct) ������һ��������
 * 					�Ӷ�����һ��������Ʒ��(Product Family)��
 * 				��飺
 * 					ʵ�ʲ�Ʒ�Ĳ�����ʵ���ض��ӿڵ��࣬Ȼ���ڹ����б�����
 * 					���̣�
 * 						       ������=======������=======
 * 												||
 * 												||
 * 						��Ʒ=====����Ʒ�Ľӿ�=====������======�������ӿ�
 * 						||						||
 * 						||=========>>===========||
 */
public class FactoryB {
	//��Ʒ�ӿڣ��к���Ů��
	interface Boy{
		void boy();
	}
	interface Girl{
		void girl();
	}
	//��Ʒʵ���ࣺ�����к�������Ů�����й��к����й�Ů��
	class AmericaBoy implements Boy{

		public void boy() {
			System.out.println("���������к�");
		}
		
	}
	class AmericaGirl implements Girl{

		public void girl() {
			System.out.println("��������Ů��");
		}
		
	}
	class ChinaBoy implements Boy{

		public void boy() {
			System.out.println("�����й��к�");
		}
		
	}
	class ChinaGirl implements Girl{

		public void girl() {
			System.out.println("�����й�Ů��");
		}
		
	}
	
	
	
	//���󹤳���ӿ�
	interface PersonFactory{
		Boy getBoy();
		Girl getGirl();
	}
	/*
	 * ����ʵ����:
	 * 			�������й�
	 */
	class AmericaPersonFactory implements PersonFactory{

		public Boy getBoy() {
			return new AmericaBoy();
		}

		public Girl getGirl() {
			// TODO �Զ����ɵķ������
			return new AmericaGirl();
		} 
		
	}
	class ChinaPersonFactory implements PersonFactory{

		public Boy getBoy() {
			return new ChinaBoy();
		}

		public Girl getGirl() {
			// TODO �Զ����ɵķ������
			return new ChinaGirl();
		} 
		
	}
	//���Է���
	public static void main(String[] args) {
		FactoryB fac = new FactoryB();
		System.out.println("======�й�����=====");
		fac.new ChinaPersonFactory().getBoy().boy();
		fac.new ChinaPersonFactory().getGirl().girl();;
		System.out.println("======��������=====");
		fac.new AmericaPersonFactory().getBoy().boy();
		fac.new AmericaPersonFactory().getBoy().boy();
	}
	

}
