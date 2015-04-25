package test.java.util;

import java.util.HashMap;
import java.util.Map;

public class TestCollection {
	
	public static <K,V> HashMap<K,V> newHashMap(){
		return new HashMap<K, V>();
	}
	
	public static void main(String[] args) {
		Map<String,Integer> map = TestCollection.newHashMap();
		map.put("test", 1);
	}

}
