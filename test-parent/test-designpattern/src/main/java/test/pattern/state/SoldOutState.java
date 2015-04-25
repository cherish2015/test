package test.pattern.state;

public class SoldOutState implements IState {
	
	@SuppressWarnings("unused")
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		// TODO Auto-generated method stub

	}

	public void ejectQuarter() {
		// TODO Auto-generated method stub

	}

	public void turnCrank() {
		// TODO Auto-generated method stub

	}

	public void dispense() {
		// TODO Auto-generated method stub

	}

}
