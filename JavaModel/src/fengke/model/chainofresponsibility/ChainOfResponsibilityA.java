package fengke.model.chainofresponsibility;
/**
 * ������ģʽ
 * @author ���
 * ��飺
 * 		���壺
 * 			Chain of Responsibility(CoR) ����һϵ����(classes)��ͼ����һ������request����Щ��֮����һ����ɢ����ϣ�
 * 			Ψһ��ͬ����������֮�䴫��request��Ҳ����˵������һ������A���ȴ������û�д����ʹ��ݵ�B�ദ�����û�д����ʹ��ݵ�C�ദ��
 * 			��������һ������(chain)һ��������ȥ��
 *	Ӧ�ó�����
 *		ͼ���û�������,�����ؼ�������״���˽ṹ.������Ϣ����ʱ,�ӿؼ��� ���������Ϣ,�ͼ������ݸ����ؼ�������.
 *
 *	�ص�: a)������ģʽ����ָ���������˽ṹ,�����ǵ�����,������,��
 *       b)����˳����ϵͳ����ָ��,�������Խ��ж�̬�仯
 *
 *
 *������ģʽ������ģʽ������
 * ������ģʽ:��������Լ��,�������˿��ԶԿͻ��˵�����һ��һ����������
 * ����ģʽ:��Ҫ����Լ��,�������˸���Լ��ִ�пͻ��˵���Ӧ����,��:
 * 	1����start,2����move,��Щ����װ��Request��.
 */
public class ChainOfResponsibilityA {
	
	//���Է���
	public static void main(String[] args) {
        System.out.println("��ʼ����������ģʽ������");

        //������������ʵ��
        Request request03=new Request(3);
        Request request08=new Request(8);
        
        //������������Ĵ�����ʵ��
        AbstractHandler firstConcreteHandler=new FirstConcreteHandler(1);
        AbstractHandler secondConcreteHandler=new SecondConcreteHandler(2);
        AbstractHandler thirdConcreteHandler=new ThirdConcreteHandler(3);
        
        //����������
        firstConcreteHandler.setNextHandler(secondConcreteHandler);
        secondConcreteHandler.setNextHandler(thirdConcreteHandler);
        
        //ÿ�����󶼴���������ͷ��ʼ����
        firstConcreteHandler.handleRequest(request03);
        System.out.println();
        firstConcreteHandler.handleRequest(request08);
        System.out.println();
        
    }

	

}
//������
class Request {//�������࣬��flag��ʶ
    private int levelFlag;
    
    public Request(int levelFlag) {
        this.levelFlag=levelFlag;
    }

    public int getLevelFlag() {
        return levelFlag;
    }

    public void setLevelFlag(int levelFlag) {
        this.levelFlag = levelFlag;
    }
}
//��������
abstract class AbstractHandler {
	   private AbstractHandler nextHandler=null;
	   private int levelFlag;
	   
	   public void AbstractHandlerset(int levelFlag){
	       this.levelFlag=levelFlag;
	   }
	   
	   //ͨ�õĹ��ⲿֱ�ӵ��õĽӿڷ���
	   public final void handleRequest(Request request){
	      if(this.levelFlag==request.getLevelFlag()){
	          this.concreteHandle(request);
	      }else{//��ǰ�������޷�����
	         if(this.nextHandler!=null){//����һ�������� 
	            System.out.println("��ǰ�������޷��������󴫵ݸ���һ��������");
	            this.nextHandler.handleRequest(request); 
	         }else{//û����һ��������
	             System.out.println("ְ�����ϵ����д����߶����ܴ��������...");
	         }
	      }
	   }
	   
	   // �����������е���һ��������  
	   protected void setNextHandler(AbstractHandler nextHandler) {  
	           this.nextHandler = nextHandler;  
	   }  
	     
	   // ��������ÿ�������߾���Ĵ���ʽ  ,�ó��󷽷���ÿ�������߾���ʵ��
	   protected abstract void concreteHandle(Request request);   
	     
	}
//��Ҫ���񣺶������Ĵ���ʽ
class FirstConcreteHandler extends AbstractHandler {

  public FirstConcreteHandler(int levelFlag) {
      super.AbstractHandlerset(levelFlag);
  }

  @Override
  protected void concreteHandle(Request request) {
    System.out.println("��ǰΪ��һ�������ߣ��ɴ�����������󼶱�Ϊ��"+request.getLevelFlag());

  }

}
//��Ҫ���񣺶������Ĵ���ʽ
class SecondConcreteHandler extends AbstractHandler {

  public SecondConcreteHandler(int levelFlag) {
      super.AbstractHandlerset(levelFlag);
  }

  @Override
  protected void concreteHandle(Request request) {
    System.out.println("��ǰΪ�ڶ��������ߣ��ɴ�����������󼶱�Ϊ��"+request.getLevelFlag());

  }

}
//��Ҫ���񣺶������Ĵ���ʽ
class ThirdConcreteHandler extends AbstractHandler {

  public ThirdConcreteHandler(int levelFlag) {
      super.AbstractHandlerset(levelFlag);
  }

  @Override
  protected void concreteHandle(Request request) {
    System.out.println("��ǰΪ�����������ߣ��ɴ�����������󼶱�Ϊ��"+request.getLevelFlag());

  }

}
