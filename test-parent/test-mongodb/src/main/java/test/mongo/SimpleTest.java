package test.mongo;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.Mongo;

public class SimpleTest {

	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		Mongo mg = null;
		try {
			mg = new Mongo();
			List<String> dbs = mg.getDatabaseNames();
			for (int i = 0; i < dbs.size(); i++) {
				System.err.println(dbs.get(i));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			if (mg != null) {
				mg.close();
			}
		}
	}

}
