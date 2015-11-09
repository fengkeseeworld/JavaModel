package fengke.model.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ģʽ/��Ԫģʽ
 * ������
 * 		��Դ�ڲ���԰      http://www.cnblogs.com/java-my-life/archive/2012/04/26/2468499.html
 * @author ���
 *	��飺
 *		Flyweight���壺
 *				�������ӵ����ͬ���ݵ�С��Ŀ���(��ķ��ڴ�)��ʹ��ҹ���һ����(Ԫ��)��
 *		Ϊʲôʹ����Ԫģʽ��
 *				����������Ե�ԭ�����һ�ж��Ƕ��󣬵����������ʹ����������ʱ�����������Եú��Ӵ�
 *				���磬�ִ�������������ÿ�����ֶ���Ϊһ�����󣬼�ǧ���֣����������Ǽ�ǧ�����ɺķ��ڴ棬
 *				��ô���ǻ���Ҫ"��ͬ����"���ҳ���Щ����Ⱥ�Ĺ�ͬ�㣬���һ��Ԫ�࣬��װ���Ա�������࣬����
 *				����һЩ������ȡ����Ӧ��(context)���ǲ��ɹ���ģ���ҲFlyweight��������Ҫ�����ڲ�
 *				״̬intrinsic���ⲿ״̬extrinsic֮�֡�
 *		
 *		ֱ�۵㣬��������һ����ԭʼģ�ͣ�Ȼ�����Ų�ͬ���Ϻͻ������ٲ������������ľ���ģ�ͣ�����Ȼ����������Ҫ��
 *		����ͬ���¶�������Flyweightģʽ�г�����Factoryģʽ��Flyweight���ڲ�״̬����������ģ�Flyweight factory
 *		����ά��һ��Flyweight pool(ģʽ��)������ڲ�״̬�Ķ���
 *
 *		Flyweightģʽ��һ����߳���Ч�ʺ����ܵ�ģʽ������ӿ����������ٶȡ�Ӧ�ó��Ϻࣺܶ������Ҫ��һ�����ݿ��ж�ȡһϵ���ַ�����
 *		��Щ�ַ�������������ظ��ģ���ô���ǿ��Խ���Щ�ַ���������Flyweight��(pool)�С�
 *
 *		��Ԫģʽ�Ľṹ��
 *				��Ԫģʽ����һ���������������ӵ����ͬ���ݶ���Ŀ��������ֿ����������ֱ�۵ľ����ڴ����ġ���Ԫ��������������Ĺؼ�������
 *				����״̬(Internal State)������״̬(External State)��
 *				һ������״̬�Ǵ洢����Ԫ�����ڲ��ģ������ǲ����滷���ĸı��������ͬ����ˣ�һ����Ԫ���Ծ�������״̬�����Թ���
 *				һ������״̬���滷���ĸı���ı�ġ������Թ���ġ���Ԫ���������״̬�����ɿͻ��˱��棬������Ԫ���󱻴���֮������Ҫʹ�õ�ʱ����
 *				���뵽��Ԫ�����ڲ�������״̬������Ӱ����Ԫ���������״̬���������໥�����ġ�
 *
 *	ע�⣺
 *		String���;���ʹ������Ԫģʽ��String������final���ͣ�����һ�������Ͳ��ɸı䡣
 *		��Ԫģʽ���Էֳɵ�����Ԫģʽ�͸�����Ԫģʽ������ʽ��
 *
 *
 */
/*
 * ������Ԫģʽ
 * 				��������Ԫģʽ�У����е���Ԫ�����ǿ��Թ���ġ�
 * ������Ԫģʽ�Ľ�ɫ��
 * 				������Ԫ(Flyweight)��ɫ ������һ������ӿڣ��Թ涨�����о�����Ԫ��ɫ��Ҫʵ�ֵķ�����
 * 				������Ԫ(ConcreteFlyweight)��ɫ��ʵ�ֳ�����Ԫ��ɫ���涨���Ľӿڡ����������״̬�Ļ������븺��Ϊ����״̬�ṩ�洢�ռ䡣
 * 				��Ԫ����(FlyweightFactory)��ɫ ������ɫ���𴴽��͹�����Ԫ��ɫ������ɫ���뱣֤��Ԫ������Ա�ϵͳ�ʵ��ع���
 * 											��һ���ͻ��˶������һ����Ԫ�����ʱ����Ԫ������ɫ����ϵͳ���Ƿ��Ѿ���һ������Ҫ��
 * 											����Ԫ��������Ѿ����ˣ���Ԫ������ɫ��Ӧ���ṩ������е���Ԫ�������ϵͳ��û��һ��
 * 											�ʵ�����Ԫ����Ļ�����Ԫ������ɫ��Ӧ������һ�����ʵ���Ԫ����	
 */
public class FlyweightA {
	//������Ԫ��ɫ��
	interface Flyweight{
		void operation(String state);
	}
	//�ӿڵľ���ʵ��
	class ConcreteFlyweight implements Flyweight{
		private Character  intrinsicState = null;
		//���캯��
		public ConcreteFlyweight(Character state) {
			this.intrinsicState=state;
		}
		
		//�������
		@Override
		public void operation(String state) {
			System.out.println("Intrinsic State = " + this.intrinsicState);
			System.out.println("Extrinsic State = " + state);
		}
		
	}
	//��Ԫ������ͻ��˲�����ֱ�ӽ�������Ԫ��ʵ������������ͨ��һ����������
    //����һ��factory()�����õ���Ԫ����һ����ԣ���Ԫ��������������ϵͳ��ֻ��һ�������Ҳ����ʹ�õ���ģʽ��
	class FlyweightFactory {
		private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
		public Flyweight factory(Character state){
			//�ȴӻ����в��Ҷ���
	        Flyweight fly = files.get(state);
	        if (fly==null) {
				fly=new ConcreteFlyweight(state);
				files.put(state, fly);
			}
			return fly;
		}
	}
	
	
	public static void main(String[] args) {
		FlyweightA temp = new FlyweightA();
		//��������
		 FlyweightFactory factory = temp.new FlyweightFactory();
		 //�����ַ�a
		 Flyweight fly = factory.factory(new Character('a'));
		 fly.operation("First Call");
		 fly = factory.factory(new Character('b'));
		 fly.operation("Second Call");
		 fly = factory.factory(new Character('a'));
		 fly.operation("Third Call");

	}

}
