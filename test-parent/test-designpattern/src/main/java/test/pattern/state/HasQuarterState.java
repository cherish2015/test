package test.pattern.state;

import org.apache.log4j.Logger;

public class HasQuarterState implements IState {
	
	private static Logger logger = Logger.getLogger(HasQuarterState.class);
	
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		logger.warn("You can't insert another quarter.");
	}

	public void ejectQuarter() {
		logger.debug("Quarter returned.");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void turnCrank() {
		logger.debug("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	public void dispense() {
		logger.warn("No gumball dispensed");
	}

}
