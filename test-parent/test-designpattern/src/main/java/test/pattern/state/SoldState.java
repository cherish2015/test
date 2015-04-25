package test.pattern.state;

import org.apache.log4j.Logger;

public class SoldState implements IState {
	
	private static Logger logger = Logger.getLogger(SoldState.class);
	
	private GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		logger.warn("Please wait,we're already giving you a gumball.");
	}

	public void ejectQuarter() {
		logger.warn("Sorry,you already turned the crank.");
	}

	public void turnCrank() {
		logger.warn("Turning twice doesn't get you another gumball.");
	}

	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			logger.warn("Oops,out of gumball.");
			gumballMachine.setSoldOutState(gumballMachine.getSoldOutState());
		}
	}

}
