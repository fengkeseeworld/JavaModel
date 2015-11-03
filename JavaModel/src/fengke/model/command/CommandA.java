package fengke.model.command;
/**
 * 命令模式
 * 声明：
 * 		内容来自：博客园
 * 				http://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html     
 * 				http://www.cnblogs.com/devinzhang/archive/2012/01/06/2315235.html
 * @author 锋客
 *	简介：
 *		概念：
 *			将来自客户端的请求传入一个对象，从而使你可用不同的请求对客户进行参数化。
 *			用于“行为请求者”与“行为实现者”解耦，可实现二者之间的松耦合，以便适应变化。分离变化与不变的因素。	
 *		
 *		在面向对象的程序设计中，一个对象调用另一个对象，一般情况下的调用过程是：创建目标对象实例；设置调用参数；调用目标对象的方法。
 *		但在有些情况下有必要使用一个专门的类对这种调用过程加以封装，我们把这种专门的类称作command类。
 *	
 *	应用场景：
 *		a）整个调用过程比较繁杂，或者存在多处这种调用。这时，使用Command类对该调用加以封装，便于功能的再利用。
 *		b）调用前后需要对调用参数进行某些处理。
 *		c）调用前后需要进行某些额外处理，比如日志，缓存，记录历史操作等。
 *
 *	Command模式有如下效果：
 *		a）将调用操作的对象和知道如何实现该操作的对象解耦。
 *		b）Command是头等对象。他们可以像其他对象一样被操作和扩展。
 *		c）你可将多个命令装配成一个符合命令。
 *		d）增加新的Command很容易，因为这无需改变现有的类。
 *
 *	角色：
 *		客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者。
 *		命令(Command)角色：声明了一个给所有具体命令类的抽象接口。
 *		具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。
 *		请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。
 *		接收者(Receiver)角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 */
public class CommandA {
	
	//抽象命令
	interface Command{
		//方法
		public void execute();
	}
	//具体命令角色
	class ConcreteCommand implements Command{
		private Receiver receiver = null;
		
		public ConcreteCommand(Receiver receiver) {
			this.receiver=receiver;
		}
		public void execute() {
			receiver.action();	
		}
		
	}
	//接收者
	class Receiver {
		public void action(){
			System.out.println("执行了动作");
		}
	}
	//请求者
	class Invoker {
		private Command command = null;
		
		public Invoker(Command command) {
			this.command=command;
		}

		public Command getCommand() {
			return command;
		}

		public void setCommand(Command command) {
			this.command = command;
		}
		
		public void action(){
			command.execute();
		}
		
	}
	//客户端
	public static void main(String[] args) {
		CommandA command = new CommandA();
		//先得有命令的接受者
		Receiver receiver=command.new Receiver();
		//命令
		Command temp=command.new ConcreteCommand(receiver);
		//发送命令的对象
		Invoker invoker=command.new Invoker(temp);
		//执行命令
		invoker.action();
		
		
	}
	
	
}
