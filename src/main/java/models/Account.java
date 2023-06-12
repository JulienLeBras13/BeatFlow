package models;

public class Account {
    private String id, password;
    private Boolean admin;

    public Account(String id, String password, Boolean admin){
        this.id = id;
        this.password = password;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return admin;
    }
}
