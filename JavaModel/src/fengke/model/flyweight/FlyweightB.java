package fengke.model.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ������Ԫģʽ
 * 		��һЩ������Ԫʹ�úϳ�ģʽ���Ը��ϣ��γɸ�����Ԫ���������ĸ�����Ԫ�������ܹ����������ǿ��Էֽ�ɵ�����Ԫ���󣬶���������Թ���
 * ���漰�Ľ�ɫ��
 * 			������Ԫ(Flyweight)��ɫ ��
 * 						����һ������ӿڣ��Թ涨�����о�����Ԫ��ɫ��Ҫʵ�ֵķ�����
 * 			������Ԫ(ConcreteFlyweight)��ɫ��
 * 						ʵ�ֳ�����Ԫ��ɫ���涨���Ľӿڡ����������״̬�Ļ������븺��Ϊ����״̬�ṩ�洢�ռ䡣
 * 			������Ԫ(ConcreteCompositeFlyweight)��ɫ ��
 * 						������Ԫ��ɫ������Ķ����ǲ����Թ���ģ�����һ��������Ԫ������Էֽ��Ϊ��������ǵ�����Ԫ�������ϡ�������Ԫ��ɫ�ֳ������ɹ������Ԫ����
 * 			��Ԫ����(FlyweightFactory)��ɫ ��
 * 						���� ɫ���𴴽��͹�����Ԫ��ɫ������ɫ���뱣֤��Ԫ������Ա�ϵͳ�ʵ��ع���
 * 						��һ���ͻ��˶������һ����Ԫ�����ʱ����Ԫ������ɫ����ϵͳ���Ƿ��Ѿ��� һ������Ҫ�����Ԫ��������Ѿ����ˣ���Ԫ������ɫ��Ӧ���ṩ������е���Ԫ����
 * 						���ϵͳ��û��һ���ʵ�����Ԫ����Ļ�����Ԫ������ɫ��Ӧ������һ�� ���ʵ���Ԫ����
 * 
 * 
 * ��ȱ�㣺
 * 			������Ԫģʽ���ŵ�����������ȵؽ����ڴ��ж�������������ǣ���������һ���������Ĵ���Ҳ�Ǻܸߵģ�
 * 							��Ԫģʽʹ��ϵͳ���Ӹ��ӡ�Ϊ��ʹ������Թ�����Ҫ��һЩ״̬�ⲿ������ʹ�ó�����߼����ӻ���
 * 							��Ԫģʽ����Ԫ�����״̬�ⲿ��������ȡ�ⲿ״̬ʹ������ʱ����΢�䳤��
 */
public class FlyweightB {
	
	interface Flyweight {
	    //һ��ʾ���Է���������state������״̬
	    public void operation(String state);
	}
	//������Ԫ
	class ConcreteFlyweight implements Flyweight {
	    private Character intrinsicState = null;
	    /**
	     * ���캯��������״̬��Ϊ��������
	     * @param state
	     */
	    public ConcreteFlyweight(Character state){
	        this.intrinsicState = state;
	    }
	    
	    
	    /**
	     * ����״̬��Ϊ�������뷽���У��ı䷽������Ϊ��
	     * ���ǲ����ı���������״̬��
	     */
	    @Override
	    public void operation(String state) {
	        //������ʾ
	        System.out.println("Intrinsic State = " + this.intrinsicState);
	        System.out.println("Extrinsic State = " + state);
	    }

	}
	//������Ԫ
	class ConcreteCompositeFlyweight implements Flyweight {
	    
	    private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
	    /**
	     * ����һ���µĵ�����Ԫ���󵽾ۼ���
	     */
	    public void add(Character key , Flyweight fly){
	        files.put(key,fly);
	    }
	    /**
	     * ����״̬��Ϊ�������뵽������
	     */
	    @Override
	    public void operation(String state) {
	    	//���õ�����Ԫ�ķ���
	        Flyweight fly = null;
	        for(Object o : files.keySet()){
	            fly = files.get(o);
	            fly.operation(state);
	        }
	        
	    }

	}
	//����
	class FlyweightFactory {
	    private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
	    /**
	     * ������Ԫ��������
	     */
	    public Flyweight factory(List<Character> compositeState){
	        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
	        
	        for(Character state : compositeState){
	            compositeFly.add(state,this.factory(state));
	        }
	        
	        return compositeFly;
	    }
	    /**
	     * ������Ԫ��������
	     */
	    public Flyweight factory(Character state){
	        //�ȴӻ����в��Ҷ���
	        Flyweight fly = files.get(state);
	        if(fly == null){
	            //������󲻴����򴴽�һ���µ�Flyweight����
	            fly = new ConcreteFlyweight(state);
	            //������µ�Flyweight������ӵ�������
	            files.put(state, fly);
	        }
	        return fly;
	    }
	}
	
	//����
	public static void main(String[] args) {
		FlyweightB temp = new FlyweightB();
		List<Character> compositeState = new ArrayList<Character>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('a');
        compositeState.add('b');
        
        FlyweightFactory flyFactory = temp.new FlyweightFactory();
        Flyweight compositeFly1 = flyFactory.factory(compositeState);
        Flyweight compositeFly2 = flyFactory.factory(compositeState);
        compositeFly1.operation("Composite Call");
        
        System.out.println("---------------------------------");        
        System.out.println("������Ԫģʽ�Ƿ���Թ������" + (compositeFly1 == compositeFly2));
        
        Character state = 'a';
        Flyweight fly1 = flyFactory.factory(state);
        Flyweight fly2 = flyFactory.factory(state);
        System.out.println("������Ԫģʽ�Ƿ���Թ������" + (fly1 == fly2));
        /**
         * һ��������Ԫ��������е�����Ԫ����Ԫ�ص�����״̬�����븴����Ԫ���������״̬��ȵġ�������״̬������Composite Call��
         * һ��������Ԫ���������еĵ�����Ԫ���������״̬һ���ǲ���ȵġ�������״̬�ֱ�Ϊb��c��a��
         * ������Ԫ�����ǲ��ܹ���ġ���ʹ����ͬ�Ķ���compositeStateͨ�������ֱ����δ������Ķ�����ͬһ������
         * ������Ԫ�����ǿ��Թ���ġ���ʹ����ͬ�Ķ���stateͨ�������ֱ����δ������Ķ�����ͬһ������
         */

	}

}
