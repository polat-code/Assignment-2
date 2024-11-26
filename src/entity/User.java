package entity;

public class User {

    private final Integer id;
    private String name;

    public User(Integer id, String name,String surname) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Id : " + id + " Name : " + name;
    }
}
