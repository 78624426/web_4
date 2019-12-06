package day4.el;

public class User {
    String name;
    String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
