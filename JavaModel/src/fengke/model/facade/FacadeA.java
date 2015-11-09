package fengke.model.facade;

import javax.swing.Box;

/**
 * 外观模式
 * 声明：
 *   来源博客园   http://www.cnblogs.com/Coda/p/4297876.html
 * @author 锋客
 * 简介：
 * 		外观模式（Facade）的定义：为子系统中的一组接口提供一个一致的界面
 * 
 *分析：
 *		优点：
 *			对客户屏蔽子系统组件，减少了客户处理的对象数目并使得子系统使用起来更加容易。
 *			同时，客户代码变简单实现了子系统与客户之间的松耦合关系。       
 *			 降低了大型软件系统中的编译依赖性，并简化了系统在不同平台之间的移植过程。
 *			只是提供了一个访问子系统的统一入口，并不影响用户直接使用子系统类。
 *		缺点：
 *			不能很好地限制客户使用子系统类，如果对客户访问子系统类做太多的限制则减少了可变性和灵活性。
 *			在不引入抽象外观类的情况下，增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”。
 *
 *
 *
 *应用场景：
 *			1）为一个复杂子系统提供一个简单接口。
 *			2）提高子系统的独立性。
 *			3）在层次化结构中，可以使用Facade模式定义系统中每一层的入口。
 */
public class FacadeA {
	//箱子
	class Box_open{
		void open(){
			System.out.println("把冰箱门打开");
		}
	}
	//把大象装进去
	class Elephant{
	void	pack(){
		System.out.println("把大象装进去");
	}
	
	}
	//封箱子
	class Box_close{
		void close(){
			System.out.println("把冰箱门关上");

		}
	}
	//给外部看的方法
	class Facade{
		 private Box_open open = new Box_open();
		 private Elephant elephant = new Elephant();
		 private Box_close close = new Box_close();
		 
		 public void methodA(){
		 this.open.open();
		 this.elephant.pack();
		 this.close.close();
		 }
	
	 }
	public static void main(String[] args) {
		FacadeA temp = new FacadeA();
		temp.new Facade().methodA();
	}

}
