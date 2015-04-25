package test.java.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TestPriorityQueue {
	
	public static void main(String[] args) {
		test2();
	}
	
	@SuppressWarnings("unused")
	private static void test(){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add((int)(Math.random()*10));
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.addAll(list);
		System.err.println(queue.toString());
		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			Integer ii = it.next();
			System.err.println(ii);
		}
	}
	
	private static void test2(){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add((int)(Math.random()*10));
		}
		System.err.println(queue.toString());

		while(queue.size()>0){
			System.err.println(queue.poll());
		}
		
		
	}
	
	static class Person implements Comparator<Person>{

		public int compare(Person o1, Person o2) {
			return 0;
		}}
	

}
