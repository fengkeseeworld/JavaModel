package fengke.model.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���Ż�
 * @author ���
 *
 */
public class MementoC {
	public static void main(String[] args) {
		Originator_c originator = new Originator_c();

		Caretaker_c caretaker = new Caretaker_c(originator);

		originator.setState("state one");

		caretaker.createMemento();

		originator.setState("state two");

		caretaker.createMemento();

		originator.setState("state three");

		caretaker.createMemento();

		originator.setState("state four");

		caretaker.createMemento();

		System.out.println("��ӡ��ǰ����״̬");
		originator.printStates();

		caretaker.restoreMemento(2);

		System.out.println("��ӡ�ָ��������״̬");
		originator.printStates();

	}

}

// ������
class Originator_c {
	private List<String> states;

	public Originator_c() {
		states = new ArrayList<String>();
	}

	// ��������¼
	public Memento_c createMemento() {
		return new Memento_c(states);
	}

	// �ָ�������¼��¼��״̬
	public void restoreMemento(Memento_c memento) {
		states = memento.getStates();
	}

	// ״̬��ֵ
	public void setState(String state) {
		states.add(state);
	}

	// ��ӡ״̬
	public void printStates() {
		for (String state : states) {
			System.out.println(state);
		}
	}
}

// ����¼
class Memento_c {
	private List<String> states;

	public Memento_c(List<String> states) {
		this.states = new ArrayList<String>(states);
	}

	public List<String> getStates() {
		return states;
	}

}

// ������
class Caretaker_c {
	private Originator_c originator;

	private List<Memento_c> mementos = new ArrayList<Memento_c>();

	public Caretaker_c(Originator_c originator) {
		this.originator = originator;
	}

	// ��������¼
	public void createMemento() {
		Memento_c memento = originator.createMemento();
		mementos.add(memento);
	}

	// �ָ�������¼��¼��״̬
	public void restoreMemento(int index) {
		Memento_c memento = mementos.get(index);
		originator.restoreMemento(memento);
	}

}