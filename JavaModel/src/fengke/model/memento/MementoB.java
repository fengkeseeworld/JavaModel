package fengke.model.memento;
/**
 * 进一步优化
 * @author 锋客
 *
 */
public class MementoB {
	
	public static void main(String[] args) {
		Originator_B originator = new Originator_B();
        Caretaker_B caretaker = new Caretaker_B();
        //设置初始状态
        originator.setState("off");
        //创建备忘录对象(已经存了状态)，并把这个备忘录对象存起来
        caretaker.saveMemento(originator.createMemento());
        //更改状态
        originator.setState("no");
        //恢复状态
        originator.restoreMemento(caretaker.retrieveMemento());

	}

}
//发起人
class Originator_B {
    private String state;
    
    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }
    
    public String getState() {
        return this.state;
    }
    
    public MementoIF createMemento() {
        return new Memento(state);
    }
    
    public void restoreMemento(MementoIF memento) {
        this.setState(((Memento)memento).getState());
    }
    
    class Memento implements MementoIF {
        private String state;
        
        private Memento(String state) {
            this.state = state;
        }
        public String getState() {
            return this.state;
        }
        
        public void setState(String state) {
            this.state = state;
        }
    }
}

interface MementoIF {

}
//负责人
class Caretaker_B {
    private MementoIF memento;
    //备忘录对象获取
    public MementoIF retrieveMemento() {
        return memento;
    }
    //备忘录赋值
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}
