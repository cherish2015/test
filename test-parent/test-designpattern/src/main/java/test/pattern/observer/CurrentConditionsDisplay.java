package test.pattern.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.setWeatherData(weatherData);
		weatherData.registerObserver(this);
	}
	
	public void display() {
		System.out.println("CurrentConditionsDisplay.display()");
	}

	public void update() {
		System.out.println("CurrentConditionsDisplay.update()");
		display();
	}

	public Subject getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(Subject weatherData) {
		this.weatherData = weatherData;
	}

}
