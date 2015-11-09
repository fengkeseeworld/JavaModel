package fengke.model.template;

/**
 * ģ�巽��ģʽ ������ ��Դ�ڲ���԰
 * 
 * @author ���
 * 
 *         ��飺 ���壺������һ�������е��㷨�ĹǼܣ��������ֲ����ʵ������������ɡ�
 *         ģ�巽��ģʽʹ��������Բ��ı�һ���㷨�Ľṹ�����ض�����㷨��ĳЩ�ض�����
 * 
 *         ģ�巽��ģʽ������ģʽ����Ϊ�����ļ���ģʽ֮һ���ǻ��ڼ̳еĴ��븴�õĻ�����������ˣ�û�й�����ϵ��
 * 
 *         ��ˣ���ģ�巽��ģʽ����ṹͼ�У�ֻ�м̳й�ϵ��
 * 
 *         ģ�巽��ģʽ��Ҫ����������;�����������ʦ֮���Э����һ�����ʦ�������һ���㷨�������͹Ǽܣ�
 *         ��һЩ���ʦ�����������㷨�ĸ����߼����衣
 * 
 *         ������Щ�����߼�����ķ���������������(primitive method)��������Щ�����������������ķ�������ģ�巽��(template
 *         method)��������ģʽ�����־��ǴӴ˶�����
 * 
 *         ģ�巽��ģʽ�е������ɫ�� 1�����巽��(Concrete Method) 2�����󷽷�(Abstract Method)
 *         3�����ӷ���(Hook Method)
 * 
 *         �����ɫ�Ĺ����� 
 *         ��ģ�巽��ģʽ�У����ȸ���ᶨ��һ���㷨�Ŀ�ܣ���ʵ���㷨����������з����� ���У����й��ԵĴ�����ڸ���ľ��巽���С�
 *         �������������ԵĴ����������ľ��巽���С����Ǹ�������Ҫ�ж�Ӧ���󷽷������� ���ӷ�����������������Ƿ���㷨�Ĳ�ͬ����йҹ���
 * 
 *         �ܽ�
 *         ʹ��ģ�巽��ģʽ���Խ�����Ĺ�����Ϊ��ȡ���Դﵽ���õ�Ŀ�ġ�
 *         ���������⻯����Ϊ��������ʵ�֡������ģ�巽�����Կ��������еľ���ʵ�֡�
 *         ���������˽������㷨��ܣ�ֻ��ʵ���Լ���ҵ���߼�����
 * 
 * 
 */
public class TemplateA {

	public static void main(String[] args) {

		AbstractClass objA = new ConcreteClassA();

		AbstractClass objB = new ConcreteClassB();

		objA.TemplateMethod();

		objB.TemplateMethod();

	}

}

// ����һ��������
abstract class AbstractClass {

	public abstract void PrimitiveOperation1();

	public abstract void PrimitiveOperation2();

	public void TemplateMethod() {

		PrimitiveOperation1();

		PrimitiveOperation2();

	}

}

// ʵ�ָ���ķ���
class ConcreteClassA extends AbstractClass {

	@Override
	public void PrimitiveOperation1() {

		System.out.println("����A�෽��1");

	}

	@Override
	public void PrimitiveOperation2() {

		System.out.println("����A�෽��2");

	}

}

class ConcreteClassB extends AbstractClass {

	@Override
	public void PrimitiveOperation1() {

		System.out.println("����B�෽��1");

	}

	public void PrimitiveOperation2() {

		System.out.println("����B�෽��2");

	}

}
