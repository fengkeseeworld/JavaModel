package fengke.model.factoryandabstract;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import fengke.model.factoryandabstract.FactoryA.SkinInterface;

/*
 * ��������ģʽ���Ż���
 * 
 * 
 */
public class FactoryC {
	// һ����ɫ�Ľӿ�
	public interface SkinInterface {
		void skin();
	}

// ===============================================================================================
	/*
	 *  ��ȡ�����ļ�
	 */
	class PropertiesReader {

		public Map<String, String> getSkinMap() {
			Map<String, String> map = new HashMap<String, String>();
			Properties properties = new Properties();
			InputStream inStream = getClass().getResourceAsStream(
					"skin.properties");
			try {
				properties.load(inStream);
				// ȡ�������ļ��������keyֵ
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
	 * ����
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
	 * ����
	 */
	public static void main(String[] args) {
			FactoryC fac = new FactoryC();
			System.out.println("�����ķ���ģʽ�Ż�");
		 SkinFactory factory = fac.new SkinFactory();
		 PropertiesReader propertiesReader=fac.new PropertiesReader();
		 Map<String,String> map=propertiesReader.getSkinMap();
		 SkinInterface sf3=factory.getSkin(map.get("yellow"));
		 sf3.skin();

	}

}
