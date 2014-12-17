package test.pattern.strategy;

public class DuckMallard extends Duck {
	
	public DuckMallard() {
		setFlyBehavior(new FlyWithWings());
		setQuackBehavior(new Quack());
	}
	
	@Override
	public void display(){
		System.out.println("DuckMallard.display()");
	}

}
