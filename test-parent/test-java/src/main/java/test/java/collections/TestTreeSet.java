package test.java.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		testIterator();
	}
	
	private static void testIterator(){
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(1);
		ts.add(2);
		ts.add(10);
		ts.add(4);
		Iterator<Integer> it = ts.iterator();
		while(it.hasNext()){
			Integer ii = it.next();
			System.err.println(ii);
		}
	}
	
	static class Player implements Comparable<Player>{
		
		private String name;
		private int age;

		public int compareTo(Player other) {
			return this.age-other.age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
	}

}
