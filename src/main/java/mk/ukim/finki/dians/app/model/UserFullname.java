package mk.ukim.finki.dians.app.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserFullname implements Serializable {
    private String name;
    private String surname;

    public UserFullname() {
    }

    public UserFullname(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
