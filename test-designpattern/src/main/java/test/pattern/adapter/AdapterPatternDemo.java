package test.pattern.adapter;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		test();
	}

	
	private static void test(){
		FileWriteLog fileWriteLog = new FileWriteLog();
		IFileWriteLogger fileWriteLogger = new FileWriteLogAdapter(fileWriteLog);
		fileWriteLogger.writeLogToFile();
	}
	
	/**
	 * 适配器模式
	 * 
	 * 
	 * 概述
	 * 将一个类的接口转换成客户希望的另外一个接口。
	 * Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
	 * 
	 * 解决的问题
	 * 即Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
	 * 
	 * 
	 * 优点
	 *  通过适配器，客户端可以调用同一接口，因而对客户端来说是透明的。
	 *  这样做更简单、更直接、更紧凑。
	 *  复用了现存的类，解决了现存类和复用环境要求不一致的问题。
	 *  将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原有代码。
	 *  一个对象适配器可以把多个不同的适配者类适配到同一个目标，
	 *  也就是说，同一个适配器可以把适配者类和它的子类都适配到目标接口
	 *  
	 *  
	 * 缺点
	 *   在一些场景下更换适配器的实现过程比较的复杂
	 *   
	 * 适用的场景
	 *  系统需要使用现有的类，而这些类的接口不符合系统的接口。
	 *  想要建立一个可以重用的类，用于与一些彼此之间没有太大关联的一些类，
	 *  包括一些可能在将来引进的类一起工作。
	 *  两个类所做的事情相同或相似，但是具有不同接口的时候。
	 *  旧的系统开发的类已经实现了一些功能，但是客户端却只能以另外接口的形式访问，
	 *  但我们不希望手动更改原有类的时候。
	 *  使用第三方组件，组件接口定义和自己定义的不同，不希望修改自己的接口，
	 *  但是要使用第三方组件接口的功能。
	 *  
	 */
}