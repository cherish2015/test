package test.pattern.strategy;

public class QuackMute implements QuackBehavior {

	public void quack() {
		System.out.println("QuackMute.quack()");
	}

}
