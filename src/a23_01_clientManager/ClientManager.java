package a23_01_clientManager;

import java.util.HashSet;
import java.util.Set;

public class ClientManager {
    private Set<Client> clients = new HashSet<>();

    public ClientManager() {}

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void listClients() {
        clients.forEach(System.out::println);
    }

    public Client getClientByAccountAndDni(String account, String dni) {
        return clients.stream().filter((c) ->
                    c.getAccount().equalsIgnoreCase(account) && c.getDni().equalsIgnoreCase(dni)
                )
                .findFirst()
                .orElse(null);
    }

    public boolean addClient(Client client) {
        return clients.add(client);
    }

    public boolean updateClient(String account, String dni, Client updatedClient) {
        Client client = getClientByAccountAndDni(account, dni);
        if (client == null) return false;

        client.setBalance(updatedClient.getBalance());
        client.setName(updatedClient.getName());
        client.setSurname(updatedClient.getSurname());
        client.setPhone(updatedClient.getPhone());
        return true;
    }

    public boolean removeClient(String account, String dni) {
        return clients.removeIf((c) -> (
                c.getAccount().equals(account) && c.getDni().equals(dni)
                ));
    }
}
