package entity;

public class Teacher {

    private final Integer id;
    private String name;
    private String surname;

    public Teacher(Integer id, String name,String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
