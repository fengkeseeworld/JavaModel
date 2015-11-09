package fengke.model.template;

/**
 * 实例
 * 
 * @author 锋客
 * 
 *         泡茶： 烧开水 ==> 冲泡茶叶 ==> 倒入杯中 ==> 添加柠檬 
 *         泡咖啡： 烧开水 ==> 冲泡咖啡 ==> 倒入杯中==>添加糖和牛奶
 */
public class TemplateB {
	//测试方法
	public static void main(String[] args) {
		System.out.println("============= 准备茶 =============");
		Beverage tea = new Tea();
		tea.prepareBeverage();

		System.out.println("============= 准备咖啡 =============");
		Beverage coffee = new Coffee();
		coffee.prepareBeverage();
	}

}

abstract class Beverage {

	// 模板方法，决定了算法骨架。相当于TemplateMethod()方法

	public void prepareBeverage() {

		boilWater();

		brew();

		pourInCup();

		if (customWantsCondiments())

		{

			addCondiments();

		}

	}

	// 共性操作，直接在抽象类中定义

	public void boilWater() {

		System.out.println("烧开水");

	}

	// 共性操作，直接在抽象类中定义

	public void pourInCup() {

		System.out.println("倒入杯中");

	}

	// 钩子方法，决定某些算法步骤是否挂钩在算法中

	public boolean customWantsCondiments() {

		return true;

	}

	// 特殊操作，在子类中具体实现

	public abstract void brew();

	// 特殊操作，在子类中具体实现

	public abstract void addCondiments();

}

class Tea extends Beverage {

	@Override
	public void brew() {

		System.out.println("冲泡茶叶");

	}

	@Override
	public void addCondiments() {

		System.out.println("添加柠檬");

	}

}

class Coffee extends Beverage {

	@Override
	public void brew() {

		System.out.println("冲泡咖啡豆");

	}

	@Override
	public void addCondiments() {

		System.out.println("添加糖和牛奶");

	}

}
