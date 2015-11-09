package fengke.model.prototype;
/**
 * ԭ��ģʽ
 * ������
 *    ��Դ�ڲ���԰  http://www.cnblogs.com/Coda/p/4285744.html
 * @author ���
 * ��飺
 * 		prototypeģʽ�Ķ��壺
 * 			��ԭ��ʵ��ָ��������������࣬����ͨ��������Щԭ�ʹ����µĶ���
		
		Prototypeģʽ����һ�������ٴ�������һ���ɶ��ƵĶ��󣬸�������֪���κ���δ�����ϸ�ڣ�
		
		����ԭ���ǣ�ͨ����һ��ԭ�Ͷ��󴫸��Ǹ�Ҫ���������Ķ������Ҫ���������Ķ���ͨ������ԭ�Ͷ��󿽱������Լ���ʵʩ������
		
		ʵ�ַ�����Java���ṩ��clone��������
				��ȻҲ���Խ�Ϲ���ģʽ������AbstractSpoonʵ����

 */
public class PrototypeA {
	
	abstract class AbstractSpoon implements Cloneable {
		String spoonName;

		public void setSpoonName(String spoonName) {
			this.spoonName = spoonName;
		}

		public String getSpoonName() {
			return spoonName;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Object object = null;
			try {
				object = super.clone();
			} catch (Exception e) {
				System.err.println("AbstractSpoon is not Cloneable");
			}
			return object;
		}
	}

	// ����ʵ��һ��
	class SoupSpoon extends AbstractSpoon {
		public SoupSpoon() {
			setSpoonName("Soup Spoon");
		}
	}
	//����ʵ�ֶ���
	class SaladSpoon extends AbstractSpoon{
		public SaladSpoon() {
			setSpoonName("Salad Spoon");
		}
	}
	//����
	public static void main(String[] args) {
		PrototypeA temp = new PrototypeA();
		System.out.println(temp.new SaladSpoon().getSpoonName());
		System.out.println(temp.new SoupSpoon().getSpoonName());
	}

}
