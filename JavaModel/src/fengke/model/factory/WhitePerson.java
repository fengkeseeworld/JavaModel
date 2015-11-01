package fengke.model.factory;

import fengke.model.factory.FactoryC.SkinInterface;

public class WhitePerson implements SkinInterface {

	@Override
	public void skin() {
		System.out.println("我是白种人");

	}

}
