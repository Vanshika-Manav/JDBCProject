package model;

public class User {
    private int user_id;
    private String username;
    private String password;

    public User() {
    }

    public User(String password, String username, int user_id) {
        this.password = password;
        this.username = username;
        this.user_id = user_id;
    }

    public String getPassword(String i) {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String getUsername(String manu) {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                '}';
    }
}
