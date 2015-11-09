package fengke.model.memento;
/**
 * ��һ���Ż�
 * @author ���
 *
 */
public class MementoB {
	
	public static void main(String[] args) {
		Originator_B originator = new Originator_B();
        Caretaker_B caretaker = new Caretaker_B();
        //���ó�ʼ״̬
        originator.setState("off");
        //��������¼����(�Ѿ�����״̬)�������������¼���������
        caretaker.saveMemento(originator.createMemento());
        //����״̬
        originator.setState("no");
        //�ָ�״̬
        originator.restoreMemento(caretaker.retrieveMemento());

	}

}
//������
class Originator_B {
    private String state;
    
    public void setState(String state) {
        this.state = state;
        System.out.println("��ǰ״̬��" + this.state);
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
//������
class Caretaker_B {
    private MementoIF memento;
    //����¼�����ȡ
    public MementoIF retrieveMemento() {
        return memento;
    }
    //����¼��ֵ
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}
