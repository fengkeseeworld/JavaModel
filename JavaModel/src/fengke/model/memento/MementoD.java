package fengke.model.memento;
/**
 * "������ʷ"
 * @author ���
 *
 */
/*
 * ʵ���Ͼ��Ǳ���¼ģʽ��һ�����֡��ڱ���¼ģʽ�У�������(Originator)��ɫ��������(Caretaker)��ɫ�ͱ���¼ (Memento)��ɫ���Ƕ����Ľ�ɫ��
 * ��Ȼ��ʵ���ϱ���¼����Գ�Ϊ����������ڲ���Ա�࣬���Ǳ���¼����Ȼ������Ϊһ����ɫ�Ķ������塣
 * �ڡ������� ʷ��ģʽ���棬�����˽�ɫ�Լ����θ����˽�ɫ��
 */
public class MementoD {
	public static void main(String[] args) {
        Originator_d originator = new Originator_d();
        
        originator.changeState("state one");
        //������ʷ��¼
        MementoIF memento = originator.createMemento();
        
        originator.changeState("state two");
        
        originator.restoreMemento(memento);
    }


	
}
//�ӿ�
interface MementoIF_d{

}
//������
class Originator_d{
    public String state;

    public void changeState(String state) {
        this.state = state;
        System.out.println("״̬��Ϊ��" + state);
    }

    public Memento createMemento() {
        return new Memento(this);
    }

    public void restoreMemento(MementoIF memento) {
        Memento memento2 = (Memento) memento;
        changeState(memento2.state);
    }

    private class Memento implements MementoIF {
        private String state;

        private Memento(Originator_d originator) {
            this.state = originator.state;
        }
    }
}
