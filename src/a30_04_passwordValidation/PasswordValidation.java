package a30_04_passwordValidation;

public class PasswordValidation {
    public static void main(String[] args) {
        PasswordValidation passwordValidation = new PasswordValidation();
        String[] passwords = {
                null,
                "",
                "Ab1",
                "Abc 1234",
                "Abcdefgh",
                "abcdefg1",
                "Abcdef1!",
                "Abcdef1%",
                "Abcdef1&",
                "Abcdef1?",
                "password123A",
                "password123A",
                "12345678Abc",
                "Abcdefg1"
        };

        for (String password : passwords) {
            System.out.printf("%s -> ", password == null ? "null" : "\"" + password + "\"");
            try {
                boolean isValid = passwordValidation.validatePassword(password);
                System.out.printf("%s%n", isValid ? "valid" : "not valid");
            } catch (Exception e) {
                System.out.printf("%s%n", e.getMessage());
            }
        }
    }

    public boolean validatePassword(String password) throws IllegalAccessException {
        if (password == null)
            throw new NullPointerException("Password can't be null.");
        if (password.isEmpty())
            throw new IllegalArgumentException("Password can't be empty.");
        if (password.length() < 8)
            throw new IllegalArgumentException("Password must have at least 8 characters.");

        boolean hasBlanks = password.matches(".*\\s.*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChars = password.matches(".*[!%&?].*");

        if (hasBlanks)
            throw new IllegalStateException("Password can't contain spaces.");
        if (!hasNumber)
            throw new IllegalArgumentException("Password must contain at least one number.");
        if (!hasUpperCase)
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        if (hasSpecialChars)
            throw new UnsupportedOperationException("Characters !, %, &, ? are not allowed.");

        password = password.trim().toLowerCase();

        if (password.contains("password") || password.contains("12345678"))
            throw new SecurityException("Weak password is not allowed.");

        return true;
    }
}
