package fengke.model.state;
/**
 * ״̬ģʽ��
 * 
 * �ֳ�״̬����ģʽ��Pattern of Objects for States����״̬ģʽ�Ƕ������Ϊģʽ��
 * 
 * ������
 * 		��Դ����԰��   http://www.cnblogs.com/java-my-life/archive/2012/06/08/2538146.html
 * @author ���
 * 
 * ��飺
 * 		״̬ģʽ�Ľṹ��
 * 			
 * 			��һ�仰��������״̬ģʽ�����о��Ķ������Ϊ��װ�ڲ�ͬ��״̬�����ÿһ��״̬��������һ������״̬���һ�����ࡣ״̬ģʽ����ͼ����һ�����������ڲ�״̬�ı��ʱ������ΪҲ��֮�ı䡣
 * 		
 * 		״̬ģʽ���漰���Ľ�ɫ�У�
 * 			����(Context)��ɫ��Ҳ�������ģ�����ͻ���������Ȥ�Ľӿڣ����ұ���һ������״̬���ʵ�����������״̬���ʵ�������˻������������״̬��
 * 			����״̬(State)��ɫ������һ���ӿڣ����Է�װ������Context�������һ���ض���״̬����Ӧ����Ϊ��
 * 			����״̬(ConcreteState)��ɫ��ÿһ������״̬�඼ʵ���˻�����Context����һ��״̬����Ӧ����Ϊ��
 * 
 *
 */
public class StateA {
	
	public static void main(String[] args){
        //����״̬
        State state1 = new ConcreteStateA();
        State state2 = new ConcreteStateB();
        //��������
        Context context = new Context();
        //��״̬���õ�������
        context.setState(state1);
        //����
        context.request("test");
        
        context.setState(state2);
        context.request("test");
	}


}
//������ɫ
class Context {
    //����һ��State���͵Ķ���ʵ��
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * �û�����Ȥ�Ľӿڷ���
     */
    public void request(String sampleParameter) {
        //ת��state������
        state.handle(sampleParameter);
    }
}
//����״̬��
interface State {
    /**
     * ״̬��Ӧ�Ĵ���
     */
    public void handle(String sampleParameter);
}
//����״̬��
class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {
        
        System.out.println("ConcreteStateA handle ��" + sampleParameter);
    }

}
class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {
        
        System.out.println("ConcreteStateB handle ��" + sampleParameter);
    }

}
