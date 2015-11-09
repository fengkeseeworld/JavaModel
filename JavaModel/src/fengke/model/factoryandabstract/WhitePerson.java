package fengke.model.factoryandabstract;

import fengke.model.factoryandabstract.FactoryC.SkinInterface;

public class WhitePerson implements SkinInterface {

	@Override
	public void skin() {
		System.out.println("我是白种人");

	}

}
