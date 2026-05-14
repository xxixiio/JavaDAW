package a21_05_userManagerSort;

import java.util.Comparator;

public class UserEmailComparator implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        return user.getEmail().compareTo(t1.getEmail());
    }
}
