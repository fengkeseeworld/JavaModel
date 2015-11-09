package fengke.model.memento;
/**
 * 备忘录模式
 * 声明：
 * 		来源于博客园    
 * @author 锋客
 * 
 * 简介：
 * 		memento是一个保存另外一个对象内部状态拷贝的对象，这样以后就可以将该对象恢复到原先保存的状态。
 * 
 * 
 * 问题：
 * 		发起人和负责热都可以看到备忘录中的内容。
 * 		创建的备忘录还在负责人的手中。
 *
 */
public class MementoA {
	public static void main(String[] args) {
		//发起人
		Originator originator = new Originator();
		//负责人角色
		Caretaker caretaker = new Caretaker();
		// 设置初始状态
		originator.setState("off");
		// 创建备忘录对象(已经存了状态)，并把这个备忘录对象存起来
		caretaker.saveMemento(originator.createMemennto());
		// 更改状态
		originator.setState("on");
		// 恢复状态
		originator.restoreMemento(caretaker.retrieveMemento());

	}

}

// 发起人角色
class Originator {
	private String state;

	// 创建备忘录角色
	public Memento createMemennto() {
		return new Memento(state);
	}

	// 恢复到某个备忘录对象记录的角色
	public void restoreMemento(Memento memento) {
		this.setState(memento.getState());
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("当前状态：" + this.state);
	}
}

// 备忘录角色
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

// 负责人角色
class Caretaker {
	private Memento memento;

	public void saveMemento(Memento memento) {
		this.memento = memento;
	}

	public Memento retrieveMemento() {
		return this.memento;
	}

}
