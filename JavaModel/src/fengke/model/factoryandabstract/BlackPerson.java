package fengke.model.factoryandabstract;

import fengke.model.factoryandabstract.FactoryC.SkinInterface;

public class BlackPerson implements SkinInterface {

	@Override
	public void skin() {
		System.out.println("我是黑种人");

	}

}
