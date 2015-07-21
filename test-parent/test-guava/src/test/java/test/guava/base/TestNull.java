package test.guava.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Optional;

public class TestNull {

	public static void main(String[] args) {
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testNull() {
		// int i = null;//Type mismatch: cannot convert from null to int
		@SuppressWarnings("null")
		int i = (Integer) null;
		System.out.println(i);
	}

	@Test
	public void testInit() {
		@SuppressWarnings("unused")
		int t;
		// System.err.println(t);//The local variable t may not have been
		// initialized

		Object obj = null;
		System.err.println(obj);
	}

	@Test
	public void testNullCollection() {
		System.err.println("********testNullCollection**********");
		Set<String> set = new HashSet<String>();
		set.add(null);
		System.err.println(set);
		set.add(null);
		System.err.println(set);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(null, new Object());
		System.err.println(map);
		map.put(null, new Object());
		System.err.println(map);
	}

	@Test
	public void testOptional() {
		System.err.println("********testOptional**********");
		Optional<String> op = Optional.of("test optional");
		op = Optional.absent();
		System.err.println("op.get()--" + op.get());
	}
	
}
