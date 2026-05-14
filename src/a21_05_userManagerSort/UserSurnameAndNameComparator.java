package a21_05_userManagerSort;

import java.util.Comparator;

public class UserSurnameAndNameComparator implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        int surnameComparator = user.getSurname().compareTo(t1.getSurname());
        int nameComparator = user.getName().compareTo(t1.getName());
        return (surnameComparator == 0) ? nameComparator : surnameComparator;
    }
}
