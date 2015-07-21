package test.java.util;

public class TestEnum {

	public static void main(String[] args) {
		for (WeekDays day : WeekDays.values()) {
			System.err.println(day);
		}
	}

}

enum WeekDays {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

	private int price;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	WeekDays() {
	}

	WeekDays(int price) {
	}
}

