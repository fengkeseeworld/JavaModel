package fengke.model.decorator;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 	װ��ģʽ
 * 	������
 * 		���Բ���԰��http://www.cnblogs.com/Coda/p/4296014.html
 * @author ���
 * 	
 * 	Decorator���壺
 * 				��̬��һ���������һЩ�����ְ�𣬾�����ǽ��ˢ���ᡣʹ��Decoratorģʽ������������෽ʽ�ﵽ���ܵ������Եø�Ϊ��
 * 
 * ԭ��
 * 			ͨ������Ͷ���ʵ����ͬ�Ľӿڣ�Ȼ�󽫶�������ӵ������У�
 * 			�ڸ����еĽӿڷ����У���дҪִ�еĶ�������װ�����ݼ��뵽���У�����ִ�С�
 * 
 *
 */
public class DecoratorA {
	//�ӿ�
	public interface Work{
		public void insert();
	}
	//ʵ�֣����뷽��׮��Բ��׮
	class SquarePeg  implements Work{

		public void insert() {
			System.out.println("����׮����");
		}
	}
	//��װ����
	class Decorator implements Work{
		//�����Ҫ�ķ���
		private Work work;
		//���Ӷ���Ĺ���
		private ArrayList<String> others = new ArrayList<String>();
		//�ڹ�������ʹ�����new��ʽ,����Work����;
		public Decorator(Work work){
			this.work=work;
			others.add("�ڿ�");
			others.add("��ľ��");
		}
		//��дinsert�ķ�����ʹ��ӵ�и���ķ���
		public void insert() {
			//���õķ���
			newMethod();
		}
		//���ƶ�����ִ��˳��
		 void newMethod() {
			 otherMethod();
			 //��Ҫ���������߳Ʊ����εĶ�����˳������ν
			 work.insert();
		}
		 //��װ�εķ���
		 void otherMethod() {
			 ListIterator<String> listIterator = others.listIterator();
			 while (listIterator.hasNext()){
				System.out.println(((String)(listIterator.next())) + " ���ڽ���");
			}
		}
	}
	//����
	public static void main(String[] args) {
		DecoratorA temp = new DecoratorA();
		//����һ����Ҫ�Ķ���
		Work squarePeg = temp.new SquarePeg();
		//���������뵽Ҫִ�еĸ����ڣ�װ������������
		Work decorator = temp.new Decorator(squarePeg);
		//ִ�ж���
		decorator.insert();

	}
	
	

}
