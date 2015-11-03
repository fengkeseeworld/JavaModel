package fengke.model.Strategy;

/*
 * ��Ϊ���ӵĲ���ģʽʵ��
 * 	��飺
 * 			��Ҫ����context������
 */
public class StrategyB {
	// �������
	abstract class AbstractStrategy {
		public abstract void algorithm(Context context);
	}

	// ������ɫ
	static class Context {
		// ˽�л�������Զ���
		private AbstractStrategy strategy;
		//���廷������
		private int parameter1;
		private int parameter2;
		//��¼�����õ��ܴ���
		static int count  = 0; 
		//������
		public Context(AbstractStrategy strategy) {
			this.strategy=strategy;
		}
		public Context(AbstractStrategy strategy,int parameter1,int parameter2 ) {
			this.strategy=strategy;
			this.parameter1=parameter1;
			this.parameter2=parameter2;
		}
		//��ȡ����
		public int getParameter1() {
			return parameter1;
		}
		public int getParameter2() {
			return parameter2;
		}
		//���巽��====�㷨���
		public void algorithm() {
			count++;   
			System.out.println("���ǵ�"+count+"�ε���algorithm�㷨");  
			this.strategy.algorithm(this);
		}
	}

	// �����㷨�ĵ�һ��ʵ��
	class ConcreteStrategy1 extends AbstractStrategy {

		public void algorithm(Context context) {
			System.out.println("���ǲ���һ�㷨");
		}

	}

	// �����㷨�ĵڶ���ʵ��
	class ConcreteStrategy2 extends AbstractStrategy {

		public void algorithm(Context context) {
			System.out.println("���ǲ��Զ��㷨");
			System.out.println("�ҵĲ����ǣ�"+context.getParameter1()+"  "+context.getParameter2());
		}

	}

	// �����㷨�ĵ�����ʵ��
	class ConcreteStrategy3 extends AbstractStrategy {

		public void algorithm(Context context) {
			System.out.println("���ǲ������㷨");
			System.out.println("�ҵĲ����ǣ�"+context.parameter1);
		}

	}
	//���Է�����
	public static void main(String[] args) {
		StrategyB strategy = new StrategyB();

		Context context1=new Context(strategy.new ConcreteStrategy1());
		context1.algorithm();
		
		Context context2=new Context(strategy.new ConcreteStrategy2(),100,1000);
		context2.algorithm();
		
		Context context3=new Context(strategy.new ConcreteStrategy3(),999,000);
		context3.algorithm();
	}

}
