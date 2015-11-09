package fengke.model.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 组合模式
 * 声明：
 * 		来源于博客园  http://www.cnblogs.com/Coda/p/4296397.html
 * @author 锋客
 * 简介：
 * 		Composite定义：
 * 				将对象以树形结构组织起来，以达成“部分－整体” 的层次结构，使得客户端对单个对象和组合对象的使用具有一致性。
 * 		优点：
 * 				使客户端调用简单，客户端可以一致的使用组合结构或其中单个对象，用户就不必关系自己处理的是单个对象还是整个组合结构，这就简化了客户端代码。
 * 				更容易在组合体内加入对象部件。客户端不必因为加入了新的对象部件而更改代码。
 * 	
 *	
 */
public class CompositeA {
	/**
	 * Composite有个规定，要在接口内部定义一个用于访问和管理Composite组合体的对象们（或称部件Component）。
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
	//Leaf : 表示叶节点对象。叶子节点没有子节点。
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
	//Composite : 定义枝节点行为，用来存储子部件，在 Component 接口中实现与子部件相关的操作。例如 Add 和 Remove。
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
