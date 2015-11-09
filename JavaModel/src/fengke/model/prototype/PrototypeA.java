package fengke.model.prototype;
/**
 * 原型模式
 * 声明：
 *    来源于博客园  http://www.cnblogs.com/Coda/p/4285744.html
 * @author 锋客
 * 简介：
 * 		prototype模式的定义：
 * 			用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
		
		Prototype模式允许一个对象再创建另外一个可定制的对象，根本无需知道任何如何创建的细节，
		
		工作原理是：通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建。
		
		实现方法：Java中提供了clone（）方法
				当然也可以结合工厂模式来创建AbstractSpoon实例。

 */
public class PrototypeA {
	
	abstract class AbstractSpoon implements Cloneable {
		String spoonName;

		public void setSpoonName(String spoonName) {
			this.spoonName = spoonName;
		}

		public String getSpoonName() {
			return spoonName;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Object object = null;
			try {
				object = super.clone();
			} catch (Exception e) {
				System.err.println("AbstractSpoon is not Cloneable");
			}
			return object;
		}
	}

	// 具体实现一：
	class SoupSpoon extends AbstractSpoon {
		public SoupSpoon() {
			setSpoonName("Soup Spoon");
		}
	}
	//具体实现二：
	class SaladSpoon extends AbstractSpoon{
		public SaladSpoon() {
			setSpoonName("Salad Spoon");
		}
	}
	//测试
	public static void main(String[] args) {
		PrototypeA temp = new PrototypeA();
		System.out.println(temp.new SaladSpoon().getSpoonName());
		System.out.println(temp.new SoupSpoon().getSpoonName());
	}

}
