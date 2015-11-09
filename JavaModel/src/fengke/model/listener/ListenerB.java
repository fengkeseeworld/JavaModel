package fengke.model.listener;
/**
 * 学习总结
 * @author 锋客
 * <br>
 * 通过学习Demo1.java，自行编写一个观察者模式。
 *
 */
public class ListenerB {
	//测试
	public static void main(String[] args) {
	//创建被监听者
	Actor ac=new Actor("被监听者");
	//设置监听器
	ac.setListenertools(new listenertools() {
		@Override
		public void dorun(Listener listener) {
			listener.setName("监听者B");
			System.out.println(listener.getName()+"看到：   "+listener.getActor()+"跑步了");
			
		}
		@Override
		public void doeat(Listener listener) {
			listener.setName("监听者C");
			System.out.println(listener.getName()+"看到：   "+listener.getActor()+"吃饭了");
			
		}
	});
	
	ac.run();
	ac.eat();
	
		
	}

}

/*
 * 被监听者
 */
class Actor{
	//设置一个属性
	private String name;
	//配置监听器
	private listenertools listenertools;
	//构造器
	public Actor(String name) {
		super();
		this.name = name;
	}
	//获取名字的方法
	public String getName(){
		return this.name;
	}
	//设置监听
	public void  setListenertools(listenertools lis){
		this.listenertools=lis;
	}
	
	public void run(){
		System.out.println(name+"跑步了！！！");
		//如果存在监听，则给一个匿名内部类，将被监听者信息传入
		if(listenertools!=null){
			listenertools.dorun(new Listener(this));
		}
	}
	
	
	public void eat(){
		System.out.println(name+"吃了饭了！！！");
		//如果存在监听，则给一个匿名内部类，将被监听者信息传入
		if(listenertools!=null){
			listenertools.doeat(new Listener(this));
		}
	}
}
/*
 * 监听者
 */
class Listener{
	//监听者
	private String name;
	//被监听的人
	private Actor actor;
	//构造器
	public Listener(Actor actor){
		super();
		this.actor=actor;
	}
	//获取监听者信息
	public String getName(){
		return this.name;
	}
	//获取被监听者信息
	public Actor getActor() {
		return actor;
	}
	//设置监听者信息
	public void setName(String name){
		this.name=name;
	}
	//设置被监听者信息
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
/*
 * 监听工具
 * 
 * 作用：将被监听者和监听者链接起来
 */
interface listenertools{
	
	public void dorun(Listener listener);
	
	public void doeat(Listener listener);
	
}

