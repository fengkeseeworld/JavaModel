package fengke.model.factory;

import fengke.model.factory.FactoryC.SkinInterface;

public class BlackPerson implements SkinInterface {

	@Override
	public void skin() {
		System.out.println("我是黑种人");

	}

}
