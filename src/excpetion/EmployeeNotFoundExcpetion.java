package excpetion;

public class EmployeeNotFoundExcpetion extends RuntimeException {

	public EmployeeNotFoundExcpetion(String message)
	{
		super(message);
	}
}
