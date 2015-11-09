package fengke.model.chainofresponsibility;
/**
 * 责任链模式
 * @author 锋客
 * 简介：
 * 		定义：
 * 			Chain of Responsibility(CoR) 是用一系列类(classes)试图处理一个请求request，这些类之间是一个松散的耦合，
 * 			唯一共同点是在他们之间传递request。也就是说，来了一个请求，A类先处理，如果没有处理，就传递到B类处理，如果没有处理，就传递到C类处理，
 * 			就这样象一个链条(chain)一样传递下去。
 *	应用场景：
 *		图形用户界面中,各个控件构成树状拓扑结构.在做消息机制时,子控件无 法处理的消息,就继续传递给父控件来处理.
 *
 *	特点: a)责任链模式并不指定链的拓扑结构,可以是单链表,二叉树,环
 *       b)链接顺序由系统任意指定,甚至可以进行动态变化
 *
 *
 *责任链模式与命令模式的区别
 * 责任链模式:无需事先约定,服务器端可以对客户端的请求一个一个进行试验
 * 命令模式:需要事先约定,服务器端根据约定执行客户端的相应请求,如:
 * 	1代表start,2代表move,这些都封装在Request中.
 */
public class ChainOfResponsibilityA {
	
	//测试方法
	public static void main(String[] args) {
        System.out.println("开始测试责任链模式。。。");

        //定义两个请求实例
        Request request03=new Request(3);
        Request request08=new Request(8);
        
        //定义三个具体的处理者实例
        AbstractHandler firstConcreteHandler=new FirstConcreteHandler(1);
        AbstractHandler secondConcreteHandler=new SecondConcreteHandler(2);
        AbstractHandler thirdConcreteHandler=new ThirdConcreteHandler(3);
        
        //构建责任链
        firstConcreteHandler.setNextHandler(secondConcreteHandler);
        secondConcreteHandler.setNextHandler(thirdConcreteHandler);
        
        //每次请求都从责任链链头开始遍历
        firstConcreteHandler.handleRequest(request03);
        System.out.println();
        firstConcreteHandler.handleRequest(request08);
        System.out.println();
        
    }

	

}
//请求者
class Request {//请求者类，用flag标识
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
//抽象处理类
abstract class AbstractHandler {
	   private AbstractHandler nextHandler=null;
	   private int levelFlag;
	   
	   public void AbstractHandlerset(int levelFlag){
	       this.levelFlag=levelFlag;
	   }
	   
	   //通用的供外部直接调用的接口方法
	   public final void handleRequest(Request request){
	      if(this.levelFlag==request.getLevelFlag()){
	          this.concreteHandle(request);
	      }else{//当前处理者无法处理
	         if(this.nextHandler!=null){//有下一个处理者 
	            System.out.println("当前处理者无法处理，请求传递给下一个处理者");
	            this.nextHandler.handleRequest(request); 
	         }else{//没有下一个处理者
	             System.out.println("职责链上的所有处理者都不能处理该请求...");
	         }
	      }
	   }
	   
	   // 设置责任链中的下一个处理者  
	   protected void setNextHandler(AbstractHandler nextHandler) {  
	           this.nextHandler = nextHandler;  
	   }  
	     
	   // 定义链中每个处理者具体的处理方式  ,该抽象方法由每个责任者具体实现
	   protected abstract void concreteHandle(Request request);   
	     
	}
//主要任务：定义具体的处理方式
class FirstConcreteHandler extends AbstractHandler {

  public FirstConcreteHandler(int levelFlag) {
      super.AbstractHandlerset(levelFlag);
  }

  @Override
  protected void concreteHandle(Request request) {
    System.out.println("当前为第一个处理者，可处理该请求，请求级别为："+request.getLevelFlag());

  }

}
//主要任务：定义具体的处理方式
class SecondConcreteHandler extends AbstractHandler {

  public SecondConcreteHandler(int levelFlag) {
      super.AbstractHandlerset(levelFlag);
  }

  @Override
  protected void concreteHandle(Request request) {
    System.out.println("当前为第二个处理者，可处理该请求，请求级别为："+request.getLevelFlag());

  }

}
//主要任务：定义具体的处理方式
class ThirdConcreteHandler extends AbstractHandler {

  public ThirdConcreteHandler(int levelFlag) {
      super.AbstractHandlerset(levelFlag);
  }

  @Override
  protected void concreteHandle(Request request) {
    System.out.println("当前为第三个处理者，可处理该请求，请求级别为："+request.getLevelFlag());

  }

}
