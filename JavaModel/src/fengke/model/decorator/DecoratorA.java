package fengke.model.decorator;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 	装饰模式
 * 	声明：
 * 		来自博客园：http://www.cnblogs.com/Coda/p/4296014.html
 * @author 锋客
 * 	
 * 	Decorator定义：
 * 				动态给一个对象添加一些额外的职责，就象在墙上刷油漆。使用Decorator模式相比用生成子类方式达到功能的扩充显得更为灵活。
 * 
 * 原理：
 * 			通过个体和动作实现相同的接口，然后将动作的添加到个体中，
 * 			在个体中的接口方法中，重写要执行的动作，将装饰内容加入到其中，重新执行。
 * 
 *
 */
public class DecoratorA {
	//接口
	public interface Work{
		public void insert();
	}
	//实现：插入方形桩或圆形桩
	class SquarePeg  implements Work{

		public void insert() {
			System.out.println("方形桩插入");
		}
	}
	//被装饰者
	class Decorator implements Work{
		//添加主要的方法
		private Work work;
		//增加额外的功能
		private ArrayList<String> others = new ArrayList<String>();
		//在构造器中使用组合new方式,引入Work对象;
		public Decorator(Work work){
			this.work=work;
			others.add("挖坑");
			others.add("钉木板");
		}
		//重写insert的方法，使其拥有更多的方法
		public void insert() {
			//调用的方法
			newMethod();
		}
		//控制动作的执行顺序
		 void newMethod() {
			 otherMethod();
			 //主要动作，或者称被修饰的动作，顺序无所谓
			 work.insert();
		}
		 //起到装饰的方法
		 void otherMethod() {
			 ListIterator<String> listIterator = others.listIterator();
			 while (listIterator.hasNext()){
				System.out.println(((String)(listIterator.next())) + " 正在进行");
			}
		}
	}
	//测试
	public static void main(String[] args) {
		DecoratorA temp = new DecoratorA();
		//创建一个主要的动作
		Work squarePeg = temp.new SquarePeg();
		//将动作加入到要执行的个体内，装饰其他的内容
		Work decorator = temp.new Decorator(squarePeg);
		//执行动作
		decorator.insert();

	}
	
	

}
