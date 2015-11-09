package fengke.model.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 复合享元模式
 * 		将一些单纯享元使用合成模式加以复合，形成复合享元对象。这样的复合享元对象本身不能共享，但是它们可以分解成单纯享元对象，而后者则可以共享。
 * 所涉及的角色：
 * 			抽象享元(Flyweight)角色 ：
 * 						给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 * 			具体享元(ConcreteFlyweight)角色：
 * 						实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
 * 			复合享元(ConcreteCompositeFlyweight)角色 ：
 * 						复合享元角色所代表的对象是不可以共享的，但是一个复合享元对象可以分解成为多个本身是单纯享元对象的组合。复合享元角色又称作不可共享的享元对象。
 * 			享元工厂(FlyweightFactory)角色 ：
 * 						本角 色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。
 * 						当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有 一个符合要求的享元对象。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；
 * 						如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个 合适的享元对象。
 * 
 * 
 * 优缺点：
 * 			　　享元模式的优点在于它大幅度地降低内存中对象的数量。但是，它做到这一点所付出的代价也是很高的：
 * 							享元模式使得系统更加复杂。为了使对象可以共享，需要将一些状态外部化，这使得程序的逻辑复杂化。
 * 							享元模式将享元对象的状态外部化，而读取外部状态使得运行时间稍微变长。
 */
public class FlyweightB {
	
	interface Flyweight {
	    //一个示意性方法，参数state是外蕴状态
	    public void operation(String state);
	}
	//单纯享元
	class ConcreteFlyweight implements Flyweight {
	    private Character intrinsicState = null;
	    /**
	     * 构造函数，内蕴状态作为参数传入
	     * @param state
	     */
	    public ConcreteFlyweight(Character state){
	        this.intrinsicState = state;
	    }
	    
	    
	    /**
	     * 外蕴状态作为参数传入方法中，改变方法的行为，
	     * 但是并不改变对象的内蕴状态。
	     */
	    @Override
	    public void operation(String state) {
	        //调用显示
	        System.out.println("Intrinsic State = " + this.intrinsicState);
	        System.out.println("Extrinsic State = " + state);
	    }

	}
	//复合享元
	class ConcreteCompositeFlyweight implements Flyweight {
	    
	    private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
	    /**
	     * 增加一个新的单纯享元对象到聚集中
	     */
	    public void add(Character key , Flyweight fly){
	        files.put(key,fly);
	    }
	    /**
	     * 外蕴状态作为参数传入到方法中
	     */
	    @Override
	    public void operation(String state) {
	    	//调用单纯享元的方法
	        Flyweight fly = null;
	        for(Object o : files.keySet()){
	            fly = files.get(o);
	            fly.operation(state);
	        }
	        
	    }

	}
	//工厂
	class FlyweightFactory {
	    private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
	    /**
	     * 复合享元工厂方法
	     */
	    public Flyweight factory(List<Character> compositeState){
	        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
	        
	        for(Character state : compositeState){
	            compositeFly.add(state,this.factory(state));
	        }
	        
	        return compositeFly;
	    }
	    /**
	     * 单纯享元工厂方法
	     */
	    public Flyweight factory(Character state){
	        //先从缓存中查找对象
	        Flyweight fly = files.get(state);
	        if(fly == null){
	            //如果对象不存在则创建一个新的Flyweight对象
	            fly = new ConcreteFlyweight(state);
	            //把这个新的Flyweight对象添加到缓存中
	            files.put(state, fly);
	        }
	        return fly;
	    }
	}
	
	//测试
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
        System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));
        
        Character state = 'a';
        Flyweight fly1 = flyFactory.factory(state);
        Flyweight fly2 = flyFactory.factory(state);
        System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));
        /**
         * 一个复合享元对象的所有单纯享元对象元素的外蕴状态都是与复合享元对象的外蕴状态相等的。即外运状态都等于Composite Call。
         * 一个复合享元对象所含有的单纯享元对象的内蕴状态一般是不相等的。即内蕴状态分别为b、c、a。
         * 复合享元对象是不能共享的。即使用相同的对象compositeState通过工厂分别两次创建出的对象不是同一个对象。
         * 单纯享元对象是可以共享的。即使用相同的对象state通过工厂分别两次创建出的对象是同一个对象。
         */

	}

}
