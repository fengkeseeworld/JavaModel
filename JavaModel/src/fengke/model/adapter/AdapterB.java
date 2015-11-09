package fengke.model.adapter;
/*
 * ����������
 */
public class AdapterB {
	// ������
	interface Target {
		public void method();

	}

	// ����������
	class Adaptee {
		void method2() {
			System.out.println("Adapter-->method2()");
		}
	}

	// ��������
	class Adapter implements Target {
		private Adaptee adaptee;

		public Adapter(Adaptee adaptee) {
			this.adaptee = adaptee;
		}

		@Override
		public void method() {
			this.adaptee.method2();
		}

	}
	//�yԇ
	public static void main(String[] args) {
		 AdapterB temp = new AdapterB();
		Adaptee adaptee = temp.new Adaptee() ;  
		 Target t = temp.new Adapter(adaptee) ; 
		 t.method();
	}
	

}
