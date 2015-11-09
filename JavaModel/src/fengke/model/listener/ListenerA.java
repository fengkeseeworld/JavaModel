package fengke.model.listener;
/**
 * 观察者模式
 * @author 锋客
 *	了解观察者模式的运行机制
 */
public class ListenerA {
	
	public static void main(String[] args) {
		Person p=new Person();
		//注入监听器
		p.register(new MyPersonListener() {
			
			@Override
			public void dorun(Event e) {
				Person p=e.getsource();
				System.out.println(p+"跑步了！！！");
			}
			
			@Override
			public void doeat(Event e) {
				Person p=e.getsource();
				System.out.println(p+"吃饭了！！！");
			}
		});
		
		p.eat();
		p.run();
		System.out.println(p);
	}
	
	

}

/*
 * 观察者 Person
 */
class Person{
	//监听动作
	private MyPersonListener listener=null;
	
	//跑的动作
	public void run() {
		
		if(listener!=null){
			listener.dorun(new Event(this));
			System.out.println("跑的事件！！！");
		}
	}
	//吃的动作
	public void eat(){
		if(listener!=null){
			listener.doeat(new Event(this));
			System.out.println("吃的事件！！！");
		}
	}
	//指令
	public void register(MyPersonListener listener){
		this.listener=listener;
	}
}

/*
 * 监听的对象---事件源
 */
class Event{
	private Person source;
	public Event(Person person){
		this.source=person;
	}
	public Person getsource(){
		return this.source;
	}
	
}


/*
 * 监听的接口
 */
interface MyPersonListener{
	public void dorun(Event e);
	public void doeat(Event e);
}
