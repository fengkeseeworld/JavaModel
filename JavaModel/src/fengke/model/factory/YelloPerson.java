package fengke.model.factory;

import fengke.model.factory.FactoryC.SkinInterface;

public class YelloPerson implements SkinInterface {

	@Override
	public void skin() {
		System.out.println("我是黄种人");

	}

}
