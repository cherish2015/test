package test.pattern.state;

import org.apache.log4j.Logger;

public class NoQuarterState implements IState {
	
	private static Logger logger = Logger.getLogger(NoQuarterState.class);
	
	private GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		logger.debug("You inserted a quarter.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	public void ejectQuarter() {
		logger.warn("You haven't inserted a quarter.");
	}

	public void turnCrank() {
		logger.warn("You turned,but there's no quarter.");
	}

	public void dispense() {
		logger.warn("You need to pay first.");
	}

}
