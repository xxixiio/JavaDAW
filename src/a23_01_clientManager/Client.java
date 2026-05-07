package a23_01_clientManager;

import java.util.Objects;

public class Client {
    private String account;
    private String dni;
    private String name;
    private String surname;
    private String phone;
    private float balance;

    public Client(String account, String dni, String name, String surname, String phone, float balance) {
        this.account = account;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.account == null) ? 0 : this.account.hashCode());
        result = prime * result + ((this.dni == null) ? 0 : this.dni.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Client other = (Client) obj;
        if (!Objects.equals(account, other.account)) return false;
        return Objects.equals(dni, other.dni);

//        if (account == null) {
//            if (other.account != null) return false;
//        } else if (!account.equals(other.account)) return false;
//
//        if (dni == null) {
//            if (other.dni != null) return false;
//        } else if (!dni.equals(other.dni)) return false;

//        return true;
    }

    @Override
    public String toString() {
        return "Client [" +
                "account='" + account + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ']';
    }
}
