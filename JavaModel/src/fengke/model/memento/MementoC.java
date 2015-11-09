package fengke.model.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 更进一步优化
 * @author 锋客
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

		System.out.println("打印当前所有状态");
		originator.printStates();

		caretaker.restoreMemento(2);

		System.out.println("打印恢复后的所有状态");
		originator.printStates();

	}

}

// 发起人
class Originator_c {
	private List<String> states;

	public Originator_c() {
		states = new ArrayList<String>();
	}

	// 创建备忘录
	public Memento_c createMemento() {
		return new Memento_c(states);
	}

	// 恢复到备忘录记录的状态
	public void restoreMemento(Memento_c memento) {
		states = memento.getStates();
	}

	// 状态赋值
	public void setState(String state) {
		states.add(state);
	}

	// 打印状态
	public void printStates() {
		for (String state : states) {
			System.out.println(state);
		}
	}
}

// 备忘录
class Memento_c {
	private List<String> states;

	public Memento_c(List<String> states) {
		this.states = new ArrayList<String>(states);
	}

	public List<String> getStates() {
		return states;
	}

}

// 负责人
class Caretaker_c {
	private Originator_c originator;

	private List<Memento_c> mementos = new ArrayList<Memento_c>();

	public Caretaker_c(Originator_c originator) {
		this.originator = originator;
	}

	// 创建备忘录
	public void createMemento() {
		Memento_c memento = originator.createMemento();
		mementos.add(memento);
	}

	// 恢复到备忘录记录的状态
	public void restoreMemento(int index) {
		Memento_c memento = mementos.get(index);
		originator.restoreMemento(memento);
	}

}