package fengke.model.factory;
/*
 * 		抽象工厂模式
 * 				定义：
 * 					在抽象工厂模式中，抽象产品 (AbstractProduct) 可能是一个或多个，
 * 					从而构成一个或多个产品族(Product Family)。
 * 				简介：
 * 					实际产品的产生是实现特定接口的类，然后在工厂中被调用
 * 					流程：
 * 						       主程序=======《《《=======
 * 												||
 * 												||
 * 						产品=====》产品的接口=====》工厂======》工厂接口
 * 						||						||
 * 						||=========>>===========||
 */
public class FactoryB {
	//产品接口：男孩，女孩
	interface Boy{
		void boy();
	}
	interface Girl{
		void girl();
	}
	//产品实现类：美国男孩，美国女孩，中国男孩，中国女孩
	class AmericaBoy implements Boy{

		public void boy() {
			System.out.println("我是美国男孩");
		}
		
	}
	class AmericaGirl implements Girl{

		public void girl() {
			System.out.println("我是美国女孩");
		}
		
	}
	class ChinaBoy implements Boy{

		public void boy() {
			System.out.println("我是中国男孩");
		}
		
	}
	class ChinaGirl implements Girl{

		public void girl() {
			System.out.println("我是中国女孩");
		}
		
	}
	
	
	
	//抽象工厂类接口
	interface PersonFactory{
		Boy getBoy();
		Girl getGirl();
	}
	/*
	 * 工厂实现类:
	 * 			美国；中国
	 */
	class AmericaPersonFactory implements PersonFactory{

		public Boy getBoy() {
			return new AmericaBoy();
		}

		public Girl getGirl() {
			// TODO 自动生成的方法存根
			return new AmericaGirl();
		} 
		
	}
	class ChinaPersonFactory implements PersonFactory{

		public Boy getBoy() {
			return new ChinaBoy();
		}

		public Girl getGirl() {
			// TODO 自动生成的方法存根
			return new ChinaGirl();
		} 
		
	}
	//测试方法
	public static void main(String[] args) {
		FactoryB fac = new FactoryB();
		System.out.println("======中国工厂=====");
		fac.new ChinaPersonFactory().getBoy().boy();
		fac.new ChinaPersonFactory().getGirl().girl();;
		System.out.println("======美国工厂=====");
		fac.new AmericaPersonFactory().getBoy().boy();
		fac.new AmericaPersonFactory().getBoy().boy();
	}
	

}
