package test.java.util.sysytem;

import java.util.Properties;

public class TestSystem {

	public static void main(String[] args) {
		System.setProperty("user.name", "hadoop");
		Properties props = System.getProperties();
		props.list(System.out);
	}

}
