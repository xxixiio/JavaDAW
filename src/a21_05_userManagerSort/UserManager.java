package a21_05_userManagerSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UserManager {
    List<User> users = new ArrayList<>();

    public UserManager() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void listUsers() {
        this.users.forEach(System.out::println);
    }

    public boolean addUser(User user) {
        List<User> newUsers = new ArrayList<>(users);
        newUsers.add(user);

        if (new HashSet<>(newUsers).size() < newUsers.size()) return false;
        else {
            this.users = newUsers;
            return true;
        }
    }

    public User getUserByEmail(String email) {
        return this.users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }

    public boolean updateUser(String email, User updatedUser) {
        User user = getUserByEmail(email);
        if (user == null) return false;

        user.setPassword(updatedUser.getPassword());
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setBirthDate(updatedUser.getBirthDate());
        user.setActive(updatedUser.isActive());

        return true;
    }

    public boolean removeUserByEmail(String email) {
        User user = getUserByEmail(email);
        return this.users.remove(user);
    }

    public List<User> sortByNameAndSurname() {
        Collections.sort(this.getUsers());
        return this.users;
    }

    public List<User> sortByEmail() {
        this.getUsers().sort(new UserEmailComparator());
        return this.users;
    }

    public List<User> sortByBirthdateAndName() {
        this.getUsers().sort(new UserBirthDateAndNameComparator());
        return this.users;
    }

    public List<User> sortBySurnameAndName() {
        this.getUsers().sort(new UserSurnameAndNameComparator());
        return this.users;
    }
}
