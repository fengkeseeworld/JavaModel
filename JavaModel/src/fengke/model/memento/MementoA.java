package fengke.model.memento;
/**
 * ����¼ģʽ
 * ������
 * 		��Դ�ڲ���԰    
 * @author ���
 * 
 * ��飺
 * 		memento��һ����������һ�������ڲ�״̬�����Ķ��������Ժ�Ϳ��Խ��ö���ָ���ԭ�ȱ����״̬��
 * 
 * 
 * ���⣺
 * 		�����˺͸����ȶ����Կ�������¼�е����ݡ�
 * 		�����ı���¼���ڸ����˵����С�
 *
 */
public class MementoA {
	public static void main(String[] args) {
		//������
		Originator originator = new Originator();
		//�����˽�ɫ
		Caretaker caretaker = new Caretaker();
		// ���ó�ʼ״̬
		originator.setState("off");
		// ��������¼����(�Ѿ�����״̬)�������������¼���������
		caretaker.saveMemento(originator.createMemennto());
		// ����״̬
		originator.setState("on");
		// �ָ�״̬
		originator.restoreMemento(caretaker.retrieveMemento());

	}

}

// �����˽�ɫ
class Originator {
	private String state;

	// ��������¼��ɫ
	public Memento createMemennto() {
		return new Memento(state);
	}

	// �ָ���ĳ������¼�����¼�Ľ�ɫ
	public void restoreMemento(Memento memento) {
		this.setState(memento.getState());
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("��ǰ״̬��" + this.state);
	}
}

// ����¼��ɫ
class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

// �����˽�ɫ
class Caretaker {
	private Memento memento;

	public void saveMemento(Memento memento) {
		this.memento = memento;
	}

	public Memento retrieveMemento() {
		return this.memento;
	}

}
