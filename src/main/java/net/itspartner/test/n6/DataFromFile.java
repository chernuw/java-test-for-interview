package net.itspartner.test.n6;

public class DataFromFile {
    private String username;
    private String password;
    private String email;

    @Override
    public String toString() {
        return username + ',' + password + ',' + email;
    }

    DataFromFile(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
