package fengke.model.adapter;
/**
 * 适配器模式
 * 		声明：
 * 			来源博客园，http://www.cnblogs.com/springside5/archive/2012/03/14/2486059.html
 * @author 锋客
 * 
 * 简介：
 * 		将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 类别：
 * 		1）类适配器 （通过继承的方式）
 * 		2）对象适配器 （采取对象组合的模式）
 *
 */
/*
 * 类适配器
 */
public class AdapterA {
	 //适配器
	interface Target{  
	    public void method() ;  
	  
	}  
	//被适配器类
	class Adaptee{
	  void method2() {
		  System.out.println("Adapter-->method2()") ;  
		}
	}
	//适配器类
	class Adapter extends Adaptee implements Target{

		@Override
		public void method() {
			super.method2() ;//或者this.method2() ;  
		}
		
	}
	public static void main(String[] args) {
		AdapterA temp = new AdapterA();
		Target t = temp.new Adapter() ;
		t.method();
	}


}
