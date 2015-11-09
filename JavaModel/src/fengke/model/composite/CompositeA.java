package fengke.model.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ���ģʽ
 * ������
 * 		��Դ�ڲ���԰  http://www.cnblogs.com/Coda/p/4296397.html
 * @author ���
 * ��飺
 * 		Composite���壺
 * 				�����������νṹ��֯�������Դ�ɡ����֣����塱 �Ĳ�νṹ��ʹ�ÿͻ��˶Ե����������϶����ʹ�þ���һ���ԡ�
 * 		�ŵ㣺
 * 				ʹ�ͻ��˵��ü򵥣��ͻ��˿���һ�µ�ʹ����Ͻṹ�����е��������û��Ͳ��ع�ϵ�Լ�������ǵ���������������Ͻṹ����ͼ��˿ͻ��˴��롣
 * 				��������������ڼ�����󲿼����ͻ��˲�����Ϊ�������µĶ��󲿼������Ĵ��롣
 * 	
 *	
 */
public class CompositeA {
	/**
	 * Composite�и��涨��Ҫ�ڽӿ��ڲ�����һ�����ڷ��ʺ͹���Composite�����Ķ����ǣ���Ʋ���Component����
	 * 
	 * 
	 */
	abstract class Component {
		protected String name;

		public Component(String name) {
			this.name = name;
		}

		public abstract void Add(Component c);

		public abstract void Remove(Component c);

		public abstract void Display(int depth);
	}
	//Leaf : ��ʾҶ�ڵ����Ҷ�ӽڵ�û���ӽڵ㡣
	class Leaf extends Component {

		public Leaf(String name) {

			super(name);

		}

		@Override
		public void Add(Component c) {

			System.out.println("Can not add to a leaf");

		}

		@Override
		public void Remove(Component c) {

			System.out.println("Can not remove from a leaf");

		}

		@Override
		public void Display(int depth) {

			String temp = "";

			for (int i = 0; i < depth; i++)

				temp += '-';

			System.out.println(temp + name);

		}

	}
	//Composite : ����֦�ڵ���Ϊ�������洢�Ӳ������� Component �ӿ���ʵ�����Ӳ�����صĲ��������� Add �� Remove��
	class Composite extends Component {

		private List<Component> children = new ArrayList<Component>();

		public Composite(String name) {

			super(name);

		}

		@Override
		public void Add(Component c) {

			children.add(c);

		}

		@Override
		public void Remove(Component c) {

			children.remove(c);

		}

		@Override
		public void Display(int depth) {

			String temp = "";

			for (int i = 0; i < depth; i++)

				temp += '-';

			System.out.println(temp + name);

			for (Component c : children) {

				c.Display(depth + 2);

			}

		}

	}
	
	public static void main(String[] args) {
		CompositeA temp = new CompositeA();
		 Composite root = temp.new Composite("root");

	        root.Add(temp.new Leaf("Leaf A"));

	        root.Add(temp.new Leaf("Leaf B"));

	        

	        Composite compX = temp.new Composite("Composite X");

	        compX.Add(temp.new Leaf("Leaf XA"));

	        compX.Add(temp.new Leaf("Leaf XB"));

	        root.Add(compX);

	        

	        Composite compXY = temp.new Composite("Composite XY");

	        compXY.Add(temp.new Leaf("Leaf XYA"));

	        compXY.Add(temp.new Leaf("Leaf XYB"));

	        compX.Add(compXY);

	        

	        root.Display(1);


	}

}
