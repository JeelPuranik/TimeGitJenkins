package time;

public class InvalidStartingMonthException extends Exception {
	@SuppressWarnings("serial")

	
	public InvalidStartingMonthException()

	{

	super("Must start in September or January");

	}

	
}
