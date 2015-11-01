package fengke.model.single;

import java.lang.reflect.Constructor;

/*
 * 单例模式之反射实现
 * 
 * 注解：
 * 
 */
public class SingletonG {
	private static SingletonG instace=null;
	static{
		try {
			Class temp = Class.forName(instace.getClass().getName());
			//获得无参构造器
			Constructor con = temp.getDeclaredConstructor();
			//设置无参构造器可访问
			con.setAccessible(true);
			//产生一个实例对象
			instace=(SingletonG) con.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static SingletonG getInstance(){
		return instace;
	}

}
