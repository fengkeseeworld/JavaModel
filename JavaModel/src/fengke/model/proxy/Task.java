package fengke.model.proxy;

import java.util.Random;

public class Task {
	//业务实体
	public void doTask() {
		 System.out.println("我在执行任务");
		 try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
