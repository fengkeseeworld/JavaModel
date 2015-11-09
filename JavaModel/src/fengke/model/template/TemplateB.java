package fengke.model.template;

/**
 * ʵ��
 * 
 * @author ���
 * 
 *         �ݲ裺 �տ�ˮ ==> ���ݲ�Ҷ ==> ���뱭�� ==> ������� 
 *         �ݿ��ȣ� �տ�ˮ ==> ���ݿ��� ==> ���뱭��==>����Ǻ�ţ��
 */
public class TemplateB {
	//���Է���
	public static void main(String[] args) {
		System.out.println("============= ׼���� =============");
		Beverage tea = new Tea();
		tea.prepareBeverage();

		System.out.println("============= ׼������ =============");
		Beverage coffee = new Coffee();
		coffee.prepareBeverage();
	}

}

abstract class Beverage {

	// ģ�巽�����������㷨�Ǽܡ��൱��TemplateMethod()����

	public void prepareBeverage() {

		boilWater();

		brew();

		pourInCup();

		if (customWantsCondiments())

		{

			addCondiments();

		}

	}

	// ���Բ�����ֱ���ڳ������ж���

	public void boilWater() {

		System.out.println("�տ�ˮ");

	}

	// ���Բ�����ֱ���ڳ������ж���

	public void pourInCup() {

		System.out.println("���뱭��");

	}

	// ���ӷ���������ĳЩ�㷨�����Ƿ�ҹ����㷨��

	public boolean customWantsCondiments() {

		return true;

	}

	// ����������������о���ʵ��

	public abstract void brew();

	// ����������������о���ʵ��

	public abstract void addCondiments();

}

class Tea extends Beverage {

	@Override
	public void brew() {

		System.out.println("���ݲ�Ҷ");

	}

	@Override
	public void addCondiments() {

		System.out.println("�������");

	}

}

class Coffee extends Beverage {

	@Override
	public void brew() {

		System.out.println("���ݿ��ȶ�");

	}

	@Override
	public void addCondiments() {

		System.out.println("����Ǻ�ţ��");

	}

}
