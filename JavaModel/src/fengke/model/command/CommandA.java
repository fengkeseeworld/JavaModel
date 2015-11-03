package fengke.model.command;
/**
 * ����ģʽ
 * ������
 * 		�������ԣ�����԰
 * 				http://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html     
 * 				http://www.cnblogs.com/devinzhang/archive/2012/01/06/2315235.html
 * @author ���
 *	��飺
 *		���
 *			�����Կͻ��˵�������һ�����󣬴Ӷ�ʹ����ò�ͬ������Կͻ����в�������
 *			���ڡ���Ϊ�����ߡ��롰��Ϊʵ���ߡ������ʵ�ֶ���֮�������ϣ��Ա���Ӧ�仯������仯�벻������ء�	
 *		
 *		���������ĳ�������У�һ�����������һ������һ������µĵ��ù����ǣ�����Ŀ�����ʵ�������õ��ò���������Ŀ�����ķ�����
 *		������Щ������б�Ҫʹ��һ��ר�ŵ�������ֵ��ù��̼��Է�װ�����ǰ�����ר�ŵ������command�ࡣ
 *	
 *	Ӧ�ó�����
 *		a���������ù��̱ȽϷ��ӣ����ߴ��ڶദ���ֵ��á���ʱ��ʹ��Command��Ըõ��ü��Է�װ�����ڹ��ܵ������á�
 *		b������ǰ����Ҫ�Ե��ò�������ĳЩ����
 *		c������ǰ����Ҫ����ĳЩ���⴦��������־�����棬��¼��ʷ�����ȡ�
 *
 *	Commandģʽ������Ч����
 *		a�������ò����Ķ����֪�����ʵ�ָò����Ķ�����
 *		b��Command��ͷ�ȶ������ǿ�������������һ������������չ��
 *		c����ɽ��������װ���һ���������
 *		d�������µ�Command�����ף���Ϊ������ı����е��ࡣ
 *
 *	��ɫ��
 *		�ͻ���(Client)��ɫ������һ����������(ConcreteCommand)����ȷ��������ߡ�
 *		����(Command)��ɫ��������һ�������о���������ĳ���ӿڡ�
 *		��������(ConcreteCommand)��ɫ������һ�������ߺ���Ϊ֮�������ϣ�ʵ��execute()������������ý����ߵ���Ӧ������execute()����ͨ������ִ�з�����
 *		������(Invoker)��ɫ����������������ִ��������صķ��������ж�������
 *		������(Receiver)��ɫ���������ʵʩ��ִ��һ�������κ�һ���඼���Գ�Ϊ�����ߣ�ʵʩ��ִ������ķ��������ж�������
 */
public class CommandA {
	
	//��������
	interface Command{
		//����
		public void execute();
	}
	//���������ɫ
	class ConcreteCommand implements Command{
		private Receiver receiver = null;
		
		public ConcreteCommand(Receiver receiver) {
			this.receiver=receiver;
		}
		public void execute() {
			receiver.action();	
		}
		
	}
	//������
	class Receiver {
		public void action(){
			System.out.println("ִ���˶���");
		}
	}
	//������
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
	//�ͻ���
	public static void main(String[] args) {
		CommandA command = new CommandA();
		//�ȵ�������Ľ�����
		Receiver receiver=command.new Receiver();
		//����
		Command temp=command.new ConcreteCommand(receiver);
		//��������Ķ���
		Invoker invoker=command.new Invoker(temp);
		//ִ������
		invoker.action();
		
		
	}
	
	
}
