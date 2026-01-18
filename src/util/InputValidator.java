package util;

public class InputValidator {

	public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidId(int id) {
        return id > 0;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
