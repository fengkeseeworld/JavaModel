package fengke.model.builder;

/**
 * ������ģʽ
 * 
 * @author ���
 * 
 *         ��飺 
 *         	���壺
 *         	 ��һ�����Ӷ���Ĺ��������ı�ʾ���룬ʹ��ͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ�� [�������ʾ���룬ͬ������ͬ��ʾ]
 * 
 *         ����󹤳������� 
 *         �ڽ�����ģʽ��и�ָ���ߣ���ָ�������������ߣ��û�����ָ������ϵ�ģ�ָ������ϵ���������õ���Ʒ��
 *         ������ģʽ����ǿ��ʵ��һ�ֲַ�����еĽ�����̡�
 * 
 *         ������ģʽ�ǽ����ӵ��ڲ�������װ���ڲ��������ⲿ���õ�����˵��ֻ��Ҫ���뽨���ߺͽ��칤�ߣ������ڲ�����ν���ɳ�Ʒ�ģ�������������ġ�
 * 
 *         Ϊ��ʹ�ý�����ģʽ�� ��Ϊ�˽��������Ӷ���Ĺ��̺����Ĳ������ע�⣺�ǽ�����̺Ͳ�����
 *         ��Ϊһ�����ӵĶ��󣬲����кܶ������ɲ��֣����������кܶಿ�������֡������̡������������и���С����ȵȣ�
 *         �����ܶ࣬��Զ��ֹ��Щ����ν���Щ����װ���һ�����������װ�����Ҳ�ܸ���(��Ҫ�ܺõ���װ����)��
 *         Builderģʽ����Ϊ�˽���������װ���̷ֿ���
 * 
 * 
 */
public class BuilderA {
	// �ӿ�
	interface Builder {
		void buildPartA();

		void buildPartB();

		void buildPartC();

		Product getResult();

	}

	// ��Ʒ
	interface Product {

	}
	
	//
	interface Part{
		
	}

	// ������
	class ConcreteBuilder implements Builder {
		Part partA, partB, partC;
		@Override
		public void buildPartA() {
			System.out.println("�ɹ�����A");

		}

		@Override
		public void buildPartB() {
			System.out.println("�ɹ�����B");

		}

		@Override
		public void buildPartC() {
			System.out.println("�ɹ�����C");

		}

		@Override
		public Product getResult() {
			System.out.println("�ɹ���װ����");
			return null;
		}

	}

	//������
	class Director {
		private Builder builder; 
		public Director(Builder builder) {
			this.builder=builder;
		}
		void construct(){
			builder.buildPartA();
			builder.buildPartB();
			builder.buildPartC();
		}


	}
	
	public static void main(String[] args) {
		BuilderA temp = new BuilderA();
		ConcreteBuilder builder = temp.new ConcreteBuilder();
		Director director = temp.new Director( builder ); 
		director.construct(); 
		Product product = builder.getResult();
	}
}
