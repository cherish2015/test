package test.pattern.decorator;

public class DecoratorPatternDemo {
	
	/**
	 * 装饰模式（Decorator Pattern）
	 * 
	 * 概述：
	 *   装饰模式是在不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能。
	 *   它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
	 *   
	 * 装饰模式的特点：
	 * （1） 装饰对象和真实对象有相同的接口。这样客户端对象就可以和真实对象相同的方式和装饰对象交互。
	 * （2） 装饰对象包含一个真实对象的引用（reference）
	 * （3） 装饰对象接受所有来自客户端的请求。它把这些请求转发给真实的对象。
	 * （4） 装饰对象可以在转发这些请求以前或以后增加一些附加功能。
	 * 这样就确保了在运行时，不用修改给定对象的结构就可以在外部增加附加的功能。
	 * 在面向对象的设计中，通常是通过继承来实现对给定类的功能扩展。
	 * 
	 * 
	 * 适用性：
	 * 以下情况使用Decorator模式
	 * 1. 需要扩展一个类的功能，或给一个类添加附加职责。
	 * 2. 需要动态的给一个对象添加功能，这些功能可以再动态的撤销。
	 * 3. 需要增加由一些基本功能的排列组合而产生的非常大量的功能，从而使继承关系变的不现实。
	 * 4. 当不能采用生成子类的方法进行扩充时。一种情况是，可能有大量独立的扩展，
	 * 为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长。
	 * 另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
	 * 
	 * 
	 * 优点：
	 * 1. Decorator模式与继承关系的目的都是要扩展对象的功能，
	 * 但是Decorator可以提供比继承更多的灵活性。
	 * 2. 通过使用不同的具体装饰类以及这些装饰类的排列组合，
	 * 设计师可以创造出很多不同行为的组合。
	 * 
	 * 缺点：
	 * 1. 这种比继承更加灵活机动的特性，也同时意味着更加多的复杂性。
	 * 2. 装饰模式会导致设计中出现许多小类，如果过度使用，会使程序变得很复杂。
	 * 3. 装饰模式是针对抽象组件（Component）类型编程。
	 * 但是，如果你要针对具体组件编程时，就应该重新思考你的应用架构，以及装饰者是否合适。
	 * 当然也可以改变Component接口，增加新的公开的行为，实现“半透明”的装饰者模式。
	 * 在实际项目中要做出最佳选择。
	 * 
	 * 
	 * 设计原则：
	 * 1. 多用组合，少用继承。
	 * 利用继承设计子类的行为，是在编译时静态决定的，而且所有的子类都会继承到相同的行为。
	 * 然而，如果能够利用组合的做法扩展对象的行为，就可以在运行时动态地进行扩展。
	 * 2. 类应设计的对扩展开放，对修改关闭
	 * 
	 * http://www.diyibk.com/post/76.html
	 * 
	 */

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		Beverage beverage = new Espresso();
		System.err.println(beverage.getDescription()+" $"+beverage.cost());
		
		Beverage beverage2 = new Mocha(beverage);
		System.err.println(beverage2.getDescription()+" $"+beverage2.cost());
		
		Beverage beverage3 = new Mocha(beverage2);
		System.err.println(beverage3.getDescription()+" $"+beverage3.cost());
	}

}

abstract class Beverage{
	
	String description = "Unknown Beverage";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}

abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}

class Espresso extends Beverage{
	
	public Espresso(){
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.1;
	}

}

class HouseBlend extends Beverage{
	
	public HouseBlend(){
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return 2.2;
	}

}


class Mocha extends CondimentDecorator{
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 10.10;
	}
	
}
