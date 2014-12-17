package test.pattern.observer;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

public class ObserverPatternDemo {

	@Test
	public void test() {
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(
				weatherData);
		weatherData.dataChanged();
		System.err.println(weatherData);
		System.out.println(ToStringBuilder.reflectionToString(
				conditionsDisplay, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	/**
	 * 观察者模式
	 * 
	 * 概述：
	 *  在软件构建过程中，我们需要为某些对象建立一种“通知依赖关系” ——一个对象（目标对象）的状态发生改变，
	 *  所有的依赖对象（观察者对象）都将得到通知。如果这样的依赖关系过于紧密，将使软件不能很好地抵御变化。
	 *  使用面向对象技术，可以将这种依赖关系弱化，并形成一种稳定的依赖关系。
	 *  从而实现软件体系结构的松耦合。
	 *  定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时, 
	 *  所有依赖于它的对象都得到通知并被自动更新。
	 *  
	 * 实现效果
	 *  1．使用面向对象的抽象，Observer模式使得我们可以独立地改变目标与观察者，
	 *  从而使二者之间的依赖关系达到松耦合。
	 *  2．目标发送通知时，无需指定观察者，通知（可以携带通知信息作为参数）会自动传播。
	 *  观察者自己决定是否需要订阅通知。目标对象对此一无所知。
	 *  3．在C#中的Event。委托充当了抽象的Observer接口，而提供事件的对象充当了目标对象，
	 *  委托是比抽象Observer接口更为松耦合的设计。
	 *  
	 *  
	 * 适用场景：
	 *  1．当一个抽象模型有两个方面, 其中一个方面依赖于另一方面。
	 *  将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。
	 *  2．当对一个对象的改变需要同时改变其它对象, 而不知道具体有多少对象有待改变。
	 *  3．当一个对象必须通知其它对象，而它又不能假定其它对象是谁。
	 *  换言之, 你不希望这些对象是紧密耦合的
	 *  
	 *  http://www.diyibk.com/post/97.html
	 * 
	 * 设计原则
	 * 为了交互对象之间的松耦合设计而努力；
	 */

}
