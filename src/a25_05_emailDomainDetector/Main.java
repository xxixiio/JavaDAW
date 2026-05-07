package a25_05_emailDomainDetector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailDomainDetector emailDomainDetector = new EmailDomainDetector();
        List<String> emails = new ArrayList<>(Arrays.asList(
                "anna@gmail.com",
                "joan@yahoo.com",
                "pere@gmail.com",
                "maria@outlook.com",
                "admin@gmail.com",
                "support@yahoo.com",
                "info@outlook.com",
                "invalidEmail",
                "test@GMAIL.com",
                "Anna@gmail.com",
                "lucia@gmail.com",
                "novalid@account@mail.com",
                "pere123@another.com",
                "admin@gmail.com",
                "support@yahoo.com",
                "invalid@yahoo",
                "invalid2@gmail"
        ));

        System.out.println(emailDomainDetector.countDomains(emails));
    }
}
