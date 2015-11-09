package fengke.model.state;
/**
 * 状态模式，
 * 
 * 又称状态对象模式（Pattern of Objects for States），状态模式是对象的行为模式。
 * 
 * 声明：
 * 		来源博客园：   http://www.cnblogs.com/java-my-life/archive/2012/06/08/2538146.html
 * @author 锋客
 * 
 * 简介：
 * 		状态模式的结构：
 * 			
 * 			用一句话来表述，状态模式把所研究的对象的行为包装在不同的状态对象里，每一个状态对象都属于一个抽象状态类的一个子类。状态模式的意图是让一个对象在其内部状态改变的时候，其行为也随之改变。
 * 		
 * 		状态模式所涉及到的角色有：
 * 			环境(Context)角色，也成上下文：定义客户端所感兴趣的接口，并且保留一个具体状态类的实例。这个具体状态类的实例给出此环境对象的现有状态。
 * 			抽象状态(State)角色：定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
 * 			具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 * 
 *
 */
public class StateA {
	
	public static void main(String[] args){
        //创建状态
        State state1 = new ConcreteStateA();
        State state2 = new ConcreteStateB();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state1);
        //请求
        context.request("test");
        
        context.setState(state2);
        context.request("test");
	}


}
//环境角色
class Context {
    //持有一个State类型的对象实例
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        //转调state来处理
        state.handle(sampleParameter);
    }
}
//抽象状态类
interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}
//具体状态类
class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {
        
        System.out.println("ConcreteStateA handle ：" + sampleParameter);
    }

}
class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {
        
        System.out.println("ConcreteStateB handle ：" + sampleParameter);
    }

}
