package fengke.model.proxy;

import java.util.Random;

public class Task {
	//ҵ��ʵ��
	public void doTask() {
		 System.out.println("����ִ������");
		 try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
