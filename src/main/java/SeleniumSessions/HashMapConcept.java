package SeleniumSessions;

import java.util.HashMap;
import java.util.Map;

public class HashMapConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// collection ---dynamic
		// stores values -K,V
		// can have only one null key
		// can have any number of null values

		Map<String, String> empMap = new HashMap<String, String>();
		empMap.put("name", "Tom");
		empMap.put("ID", "101");
		empMap.put("city", "Bangalore");
		empMap.put("Country", "IN");
		empMap.put(null, "Selenium");
		empMap.put(null, "QTP");
		empMap.put("Phone", null);
		empMap.put("name", "Lisa");

		// to iterate map
		// entryset to fetch all key values;

		for (Map.Entry<String, String> entry : empMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}

		// keySet() for getting the keys

		for (String s : empMap.keySet()) {
			System.out.println("key = " + s);
		}

		// Values : for getting the values

		for (String v : empMap.values()) {
			System.out.println("value = " + v);
		}

		// Lambda:
		empMap.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

		System.out.println(empMap.get("name"));
		System.out.println(empMap.get(null));
		System.out.println(empMap.get("Phone"));
	}

}
