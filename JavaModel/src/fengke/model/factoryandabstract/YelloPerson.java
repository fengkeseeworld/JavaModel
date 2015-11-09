package fengke.model.factoryandabstract;

import fengke.model.factoryandabstract.FactoryC.SkinInterface;

public class YelloPerson implements SkinInterface {

	@Override
	public void skin() {
		System.out.println("我是黄种人");

	}

}
