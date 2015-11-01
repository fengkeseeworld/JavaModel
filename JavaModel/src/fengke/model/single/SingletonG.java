package fengke.model.single;

import java.lang.reflect.Constructor;

/*
 * ����ģʽ֮����ʵ��
 * 
 * ע�⣺
 * 
 */
public class SingletonG {
	private static SingletonG instace=null;
	static{
		try {
			Class temp = Class.forName(instace.getClass().getName());
			//����޲ι�����
			Constructor con = temp.getDeclaredConstructor();
			//�����޲ι������ɷ���
			con.setAccessible(true);
			//����һ��ʵ������
			instace=(SingletonG) con.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static SingletonG getInstance(){
		return instace;
	}

}
