package a21_05_userManagerSort;

import java.util.Comparator;

public class UserBirthDateAndNameComparator implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        int birthDateCompare = user.getBirthDate().compareTo(t1.getBirthDate());
        int nameCompare = user.getName().compareTo(t1.getName());
        return (birthDateCompare == 0) ? nameCompare : birthDateCompare;
    }
}
