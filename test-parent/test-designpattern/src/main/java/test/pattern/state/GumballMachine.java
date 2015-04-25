package test.pattern.state;

import org.apache.log4j.Logger;

public class GumballMachine {
	
	private static Logger logger = Logger.getLogger(GumballMachine.class);
	
	private IState state;
	
	private int count = 0;
	
	private NoQuarterState noQuarterState;
	
	private HasQuarterState hasQuarterState;
	
	private SoldState soldState;
	
	private SoldOutState soldOutState;
	
	private WinnerState winnerState;
	
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		this.count = numberGumballs;
		if (count > 0) {
			state = noQuarterState;
		}
	}
	
	public void insertQuarter(){
		state.insertQuarter();
	}
	
	public void ejectQuarter(){
		state.ejectQuarter();
	}
	
	public void turnCrank(){
		state.turnCrank();
	}
	
	void releaseBall(){
		logger.debug("A gumball comes rolling out the slot...");
		if (count > 0) {
			count--;
		}
	}
	
	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public NoQuarterState getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(NoQuarterState noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public HasQuarterState getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(HasQuarterState hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public SoldState getSoldState() {
		return soldState;
	}

	public void setSoldState(SoldState soldState) {
		this.soldState = soldState;
	}

	public SoldOutState getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(SoldOutState soldOutState) {
		this.soldOutState = soldOutState;
	}

	public WinnerState getWinnerState() {
		return winnerState;
	}

	public void setWinnerState(WinnerState winnerState) {
		this.winnerState = winnerState;
	}
	
}
