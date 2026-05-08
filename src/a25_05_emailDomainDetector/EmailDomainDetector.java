package a25_05_emailDomainDetector;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailDomainDetector {
    /**
     * Receives a list of email addresses with duplicates,
     * removes duplicated emails using a Set,
     * and returns a TreeMap with the number of unique emails per domain.
     */
    public Map<String, Integer> countDomains(List<String> emails) {
        Set<String> uniqueEmails = new HashSet<>(emails.stream().map(String::toLowerCase).toList());
        Map<String, Integer> domainsMap = new TreeMap<>();

        for (String email : uniqueEmails) {
            Pattern pattern = Pattern.compile("^[a-z0-9_\\-.]+@[a-z0-9_\\-.]+\\.[a-z]+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                String domain = email.split("@")[1];
                domainsMap.put(domain, domainsMap.getOrDefault(domain, 0) + 1);
            }
        }

        return domainsMap;
    }
}
