package fengke.model.memento;
/**
 * "自述历史"
 * @author 锋客
 *
 */
/*
 * 实际上就是备忘录模式的一个变种。在备忘录模式中，发起人(Originator)角色、负责人(Caretaker)角色和备忘录 (Memento)角色都是独立的角色。
 * 虽然在实现上备忘录类可以成为发起人类的内部成员类，但是备忘录类仍然保持作为一个角色的独立意义。
 * 在“自述历 史”模式里面，发起人角色自己兼任负责人角色。
 */
public class MementoD {
	public static void main(String[] args) {
        Originator_d originator = new Originator_d();
        
        originator.changeState("state one");
        //保存历史纪录
        MementoIF memento = originator.createMemento();
        
        originator.changeState("state two");
        
        originator.restoreMemento(memento);
    }


	
}
//接口
interface MementoIF_d{

}
//发起者
class Originator_d{
    public String state;

    public void changeState(String state) {
        this.state = state;
        System.out.println("状态改为：" + state);
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
