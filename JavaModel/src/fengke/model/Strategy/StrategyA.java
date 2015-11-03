package fengke.model.Strategy;
/**
 * ����ģʽ
 * ������
 * 		��Դ�ڲ���԰  http://www.cnblogs.com/freeliver54/archive/2012/06/29/2569647.html
 * @author ���
 *	��飺
 *		���壺
 *			Strategy���������ģʽ�� ������Ϊ��ģʽ����Ҫ�Ƕ���һϵ�е��㷨������Щ�㷨һ������װ�ɵ������ࡣ
 *		����ģʽ��Ҫ��Ϊ����������ɫ�� 
 *				1.������ɫ��Context��:����һ������������ 
 *				2.������ԣ�Strategy��:�����˶��������ԵĹ����ӿڣ�����������и��ֲ�ͬ���㷨�Բ�ͬ�ķ�ʽʵ������ӿڣ�
 *								   Contextʹ����Щ�ӿڵ��ò�ͬʵ�ֵ��㷨��һ��ģ�����ʹ�ýӿڻ������ʵ�֡� 
 *				3.������ԣ�ConcreteStrategy��:ʵ�ֳ���������е���ص��㷨�������
 *
 *	���ͣ�
 *			���ģ�����Ĳ���
 *			�������ͨ����ͬ�ķ�ʽʵ�ֳ���Ĳ��ԣ�Ȼ����в�ͬ�Ĵ���ʽ��
 *			���������ࣨ���ڴ�����ͨ��˽�л�һ������Ĳ������ԣ����������Ĳ��ԡ�
 *			����ִ�з���
 *						1.����һ�����������Ķ���
 *						2.������ֵ�������Ĺ�����������һ�������ھ�����������Ĵ�����󣨻���������Ķ��󣩡�
 *						3.�ⲿͨ�����û���������Ķ���ִ����Ӧ�Ĳ��Է�����
 */
public class StrategyA {
	/*
	 * ����Ĳ���
	 */
	abstract class AbstractStrategy {
		//����ķ���
		public abstract void algorithm();
		
	}
	//���Ե�ʵ��ConcreteStrategy1
	class ConcreteStrategy1 extends AbstractStrategy{

		public void algorithm() {
			System.out.println("���ǵ�һ�ֲ���");
			
		}
		
	}
	//���Ե�ʵ��ConcreteStrategy2
	class ConcreteStrategy2 extends AbstractStrategy{

		public void algorithm() {
			System.out.println("���ǵڶ��ֲ���");
			
		}
		
	}
	//����
	class Context {
		private AbstractStrategy strategy;  
		//������
		public Context(AbstractStrategy abstractStrategy){
			this.strategy=abstractStrategy;
		}
		//���þ��������ķ���
		public void algorithm(){
			strategy.algorithm();
		}
	}
	//����
	public static void main(String[] args) {
		StrategyA strategy = new StrategyA();
		Context context1 = strategy.new Context(strategy.new ConcreteStrategy1());
		context1.algorithm();
		Context context2 = strategy.new Context(strategy.new ConcreteStrategy2());
		context2.algorithm();
	}
	
	
	/*		�������ݣ�
	 * 				���Գ���ֱ��ʹ���´��������࣬���кη���
	 * 				���磺	
	 * 						Strategy strategy = new Strategy();
	 * 						AbstractStrategy object = strategy.new ConcreteStrategy1();   
	 * 						object.algorithm();   
	 * 				���Կ������ƺ����ַ�ʽ���Ӽ򵥡�
	 * 
	 * 		����context�Ľ��ͣ�
	 * 				1.���������Ҫ�Բ�ͬ��������ͬ�㷨�Ĳ�����ִ����ͬ�İ�ȫ�Լ�飬�������û�л�����ɫContext��
	 * 				     ��ֻ����ÿ��ʵ�ֵĿ�ʼ���֣����ð�ȫ�Լ����룻������Context�����ɫ�����ǿ����ڵ���Context�Ĺ�����ʱ��
	 * 				    ͳһ���а�ȫ�Լ�顣�������ǵ�ʵ�ֲ��ԱȽ϶��ʱ�򣬱���˵7��8����ʱ���ر����ã����Դ�����������Ĵ������� 
	 * 				2.���������Ҫ�ı�ԭ���㷨ʱ����Ҫ�����µĲ��������û��Context��������ô�죿һ�ְ취�����ظ��㷨�������µĺ����ӿڣ�
	 * 				    ����һ�ְ취����ȫ����ԭ�еĺ����ӿڣ�����д�µĺ����ӿڡ���ӹ���ɣ���2�ְ취�Ĵ��۶��ܴ��������������µĲ���
	 * 				    ֻ�в���ʵ�ֲ����еĸ��㷨ʵ���õ���ʱ�򡣶�����ʹ��Context�Ϳ�����ȫ���������⡣
	 * 
	 * 		���ڱȽϸ���������ο���һ������
	 * 
	 */

}
