package test.mongo;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class SimpleTest {

	public static void main(String[] args) {
		test();
	}
	
	@SuppressWarnings("deprecation")
	public static void test(){
		Mongo mg = null;
		try {
			mg = new Mongo();
			List<String> dbs = mg.getDatabaseNames();
			for (int i = 0; i < dbs.size(); i++) {
				System.err.println(dbs.get(i));
			}
			DB db = mg.getDB("mymongo");
			DBCollection colleciton = db.getCollection("colors");
			DBCursor dbCursor = colleciton.find();
			while(dbCursor.hasNext()){
				DBObject obj = dbCursor.next();
				Set<String> keys = obj.keySet();
				System.err.println(keys);
				Iterator<String> it = keys.iterator();
				while(it.hasNext()){
					String key = it.next();
					System.err.println(obj.get(key));
				}
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
