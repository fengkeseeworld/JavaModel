package fengke.model.factoryandabstract;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import fengke.model.factoryandabstract.FactoryA.SkinInterface;

/*
 * 工厂方法模式的优化：
 * 
 * 
 */
public class FactoryC {
	// 一个肤色的接口
	public interface SkinInterface {
		void skin();
	}

// ===============================================================================================
	/*
	 *  读取配置文件
	 */
	class PropertiesReader {

		public Map<String, String> getSkinMap() {
			Map<String, String> map = new HashMap<String, String>();
			Properties properties = new Properties();
			InputStream inStream = getClass().getResourceAsStream(
					"skin.properties");
			try {
				properties.load(inStream);
				// 取得配置文件里的所有key值
				Enumeration enumeration = properties.propertyNames();
				while (enumeration.hasMoreElements()) {
					String key = (String) enumeration.nextElement();
					map.put(key, properties.getProperty(key));
				}
				return map;

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

		}
	}
//=========================================================================================
	/*
	 * 工厂
	 */
	class SkinFactory {
		public SkinInterface getSkin(String classname) {
			try {
				return (SkinInterface) Class.forName(classname).newInstance();
			} catch (Exception e) {
			
			}
			
			return null;
		}
	}
//==========================================================================================
	/*
	 * 测试
	 */
	public static void main(String[] args) {
			FactoryC fac = new FactoryC();
			System.out.println("工厂的方法模式优化");
		 SkinFactory factory = fac.new SkinFactory();
		 PropertiesReader propertiesReader=fac.new PropertiesReader();
		 Map<String,String> map=propertiesReader.getSkinMap();
		 SkinInterface sf3=factory.getSkin(map.get("yellow"));
		 sf3.skin();

	}

}
