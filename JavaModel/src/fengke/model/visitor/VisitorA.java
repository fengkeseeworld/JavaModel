package fengke.model.visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * ����ģʽ
 * ������
 * 		��Դ����԰  http://www.cnblogs.com/Coda/p/4317421.html
 * @author ���
 * 
 * ��飺
 * 		���壺
 * 			Visitor���壺������ĳ������Ⱥ�и�������Ĳ�����������ʹ���ڲ��ı���Щ�����������£�������������Щ������²�����
 * 		
 *
 */
public class VisitorA {
	
	public static void main(String[] args) {
		// �����߼�ʵ��
        Service service1 = new Saving();
        Service service2 = new Fund();
        Service service3 = new Draw();
        List<Service> ls = new ArrayList<Service>();
        ls.add(service1);
        ls.add(service2);
        ls.add(service3);
        for (Service service : ls) {
            if (service instanceof Saving) {
                System.out.println("���");
            } else if (service instanceof Fund) {
                System.out.println("����");
            } else if (service instanceof Draw) {
                System.out.println("���");
            }
        }
        //����������������ҵ�������� ����ά������ǳ��Ĵ� ��Ҫ���ϵ�ȥ�ж� 
        
        //���÷�����ģʽ���
        Service saving = new Saving();
        Service fund = new Fund();
        Service draw = new Draw();
        Visitor visitor = new Visitor();
        saving.accept(visitor);
        fund.accept(visitor);
        draw.accept(visitor);
        //������accept��ʵ�����й۲��ߵ�Ӱ�� ʵ���� ����������Ҳ��������һ����ҵ����Ϥ�Ĺ۲���
        //�����Ϲ۲����Ƿ����µ�ҵ������ �еĻ� ������Ӧ��ҵ����
        //�����߽�������java�Ķ�̬�������,ʹ��visitor����˳����ִ����Ӧ����ķ���
	}

}
//��������
interface Service {

    public void accept(Visitor visitor);
}
//������
class Visitor {

    public void process(Service service) {
        // ����ҵ��
        System.out.println("����ҵ��");
    }

    public void process(Saving service) {
        // ���
        System.out.println("���");
    }

    public void process(Draw service) {
        // ���
        System.out.println("���");
    }

    public void process(Fund service) {
        System.out.println("����");
        // ����
    }

}

class Saving implements Service {

    public void accept(Visitor visitor) {
        visitor.process(this);

    }
}

class Draw implements Service {

    public void accept(Visitor visitor) {
        visitor.process(this);

    }
}

class Fund implements Service {

    public void accept(Visitor visitor) {
        visitor.process(this);

    }
}
