package a23_02_playerManager;

import java.util.HashSet;
import java.util.Set;

public class PlayerManager {
    private Set<Player> players = new HashSet<>();

    public PlayerManager() {}

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void listPlayers() {
        players.forEach(System.out::println);
    }

    public Player getPlayerByNameSurnameAndAge(String name, String surname, byte age) {
        return players.stream().filter(p -> (
                                p.getName().equalsIgnoreCase(name)
                                && p.getSurname().equalsIgnoreCase(surname)
                                && p.getAge() == age
                ))
                .findFirst()
                .orElse(null);
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public boolean updatePlayer(String name, String surname, byte age, Player updatedPlayer) {
        Player player = getPlayerByNameSurnameAndAge(name, surname, age);

        if (player == null) {
            return false;
        }

        updatedPlayer.setName(player.getName());
        updatedPlayer.setSurname(player.getSurname());
        updatedPlayer.setAge(player.getAge());

        if (players.remove(player)) {
            return players.add(updatedPlayer);
        }

        return false;
    }

    public boolean removePlayer(String name, String surname, byte age) {
        return players.removeIf(p -> (
                p.getName().equalsIgnoreCase(name) && p.getSurname().equalsIgnoreCase(surname) && p.getAge() == age)
        );
    }

}
