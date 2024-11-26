package entity;

public class Teacher {

  private final Integer id;
  private String name;
  private String surname;

  public Teacher(Integer id, String name, String surname) {
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

  @Override
  public String toString() {
    return "Teacher{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", surname='"
        + surname
        + '\''
        + '}';
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Teacher teacher)) return false;

    return getId().equals(teacher.getId())
        && getName().equals(teacher.getName())
        && getSurname().equals(teacher.getSurname());
  }

  @Override
  public int hashCode() {
    int result = getId().hashCode();
    result = 31 * result + getName().hashCode();
    result = 31 * result + getSurname().hashCode();
    return result;
  }
}
