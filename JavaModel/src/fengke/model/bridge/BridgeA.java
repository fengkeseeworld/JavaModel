package fengke.model.bridge;

/**
 * ��ģʽ ������ �������Բ���԰��http://www.cnblogs.com/Coda/p/4289593.html
 * 
 * @author ���
 * 			 ��飺 
 * 				Bridge���壺
 * 						 ���������Ϊ���ֿ��������Զ��������ܶ�̬�Ľ�ϡ� 
 * 			Ϊʲôʹ����ģʽ��
 *         				ͨ������һ���������ӿ��ж������ʵ��(concrete subclass)����Щconcrete֮���ϵ�������������֣�
 *        					 1.��������ʵ��֮��ǡ���ǲ��еģ���ǰ���������׮��������concrete class������׮��Բ��׮����������״�ϵ�׮�ǲ��еģ�
 *        						 û�и����ϵ��ظ�����ô����ֻҪʹ�ü̳оͿ����ˡ�
 *         					 2��ʵ��Ӧ���ϣ������п���������concreteclass֮���и������ص�����ô��Ҫ���ǰѳ���ͬ���ֺ���Ϊ��ͬ���ָ��Զ���������
 *         						ԭ����׼������һ���ӿ��������Ҫ��������ӿڣ��ֱ���ó������Ϊ�� 
 *         ������ 
 *         		���磬һ������Ϊ�������б��ʹ�֮�֣�ͬʱ���м��̲�����֮�֡�����õ����ļ̳У����ĸ�����ʵ��(�б� �� ���� ������)֮���и����ص�,��Ϊ���б����̣�
 *         		Ҳ���б������̣���������б���һ����ʵ�������̳У�����Ȼ���ң���չ�Լ��
 * 
 */
public class BridgeA {
	// CoffeeImp �ǼӲ����̵���Ϊ�ӿ�
	abstract class CoffeeImp {
		abstract void pourCoffeeImp();
	}

	// ���ȴ�С���Ľӿ�
	abstract class Coffee {
		CoffeeImp coffeeImp;
		//ͨ���̳У�ʹ����ͨ�����ø����setCoffeeImp�����������Լ��Ĳ������Ƿ���̣���
		void setCoffeeImp() {
			//һ������ģʽ���Ʋ���
			this.coffeeImp = CoffeeImpSingleton.getTheCoffeeImp();
		}

		public CoffeeImp getCoffeeImp() {
			return this.coffeeImp;
		}

		public abstract void pourCoffee();
	}

	// �б�
	class MediumCoffee extends Coffee {
		public MediumCoffee() {
			setCoffeeImp();
		}

		@Override
		public void pourCoffee() {
			CoffeeImp coffeeImp = this.getCoffeeImp();
			for (int i = 0; i < 2; i++) {
				System.out.print("�б���");
				coffeeImp.pourCoffeeImp();
			}
		}

	}

	// ��
	class SuperSizeCoffee extends Coffee {
		public SuperSizeCoffee() {
			setCoffeeImp();
		}

		public void pourCoffee() {
			CoffeeImp coffeeImp = this.getCoffeeImp();
			// �������ظ�������˵���ǳ��б����Ǵ� ,�ظ�5���Ǵ�
			for (int i = 0; i < 5; i++) {
				System.out.print("�󱭣�");
				coffeeImp.pourCoffeeImp();
			}
		}

	}

	// ����
	class MilkCoffeeImp extends CoffeeImp {
		MilkCoffeeImp() {
		}

		void pourCoffeeImp() {
			System.out.println("������ζ��ţ��");
		}
	}

	// ������
	class FragrantCoffeeImp extends CoffeeImp {
		FragrantCoffeeImp() {
		}

		void pourCoffeeImp() {
			System.out.println("ʲôҲû��,����");
		}
	}

	// ����====���������Ƿ���̵���Ϊ
	static class CoffeeImpSingleton {
		private static CoffeeImp coffeeImp;

		public CoffeeImpSingleton(CoffeeImp coffeeImpIn) {
			coffeeImp = coffeeImpIn;
		}

		public static CoffeeImp getTheCoffeeImp() {
			return coffeeImp;
		}
	}

	// ����
	public static void main(String[] args) {
		BridgeA temp = new BridgeA();
		//ȷ���Ƿ����
		new CoffeeImpSingleton(temp.new MilkCoffeeImp());
		//������������
		MediumCoffee mediumCoffee = temp.new MediumCoffee();
		mediumCoffee.pourCoffee();
		SuperSizeCoffee superSizeCoffee = temp.new SuperSizeCoffee();
		superSizeCoffee.pourCoffee();
	}
	/*
	 * Bridgeģʽ��EJB�е�Ӧ��
	 * 
	 * EJB����һ��Data Access Object
	 * (DAO)ģʽ�����ǽ���ҵ�߼��;���������Դ�ֿ��ģ���Ϊ��ͬ�����ݿ��в�ͬ�����ݿ��������������ͬ���ݿ����Ϊ���������һ����Ϊ�ӿ�DAO�����£�
	 * Business Object (����Coffee)
	 * ʵ��һЩ�������ҵ��������Ѱ��һ���û������еĶ������漰���ݿ������ʹ��DAOImplementor��
	 * 
	 * Data Access Object (����CoffeeImp) һЩ����Ķ����ݿ���Դ������
	 * 
	 * DAOImplementor ��OrderDAOCS, OrderDAOOracle,
	 * OrderDAOSybase(����MilkCoffeeImp FragrantCoffeeImp)
	 * ��������ݿ��������"INSERT INTO "����䣬OrderDAOOracle��Oracle
	 * OrderDAOSybase��Sybase���ݿ⡣
	 * 
	 * ���ݿ� (Cloudscape, Oracle, or Sybase database via JDBC API)
	 */

}
