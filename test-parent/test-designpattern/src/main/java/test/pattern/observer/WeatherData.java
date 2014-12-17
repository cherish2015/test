package test.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	
	private List<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	public void dataChanged(){
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		int index = observers.indexOf(observer);
		if (index >- 0) {
			observers.remove(index);
		}
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
