package service;

import entity.Teacher;
import entity.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TeacherService {

  private final List<Teacher> teachers;

  public TeacherService(List<Teacher> teachers) {
    this.teachers = teachers;
  }

  public static Function<String, List<Teacher>> getReadFromFileFunction() {
    return (fileName -> {
      List<Teacher> teachers = new ArrayList<>();
      try {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
          String[] lineProperties = line.split(" ");
          teachers.add(
              new Teacher(
                  Integer.parseInt(lineProperties[0]), lineProperties[1], lineProperties[2]));
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      return teachers;
    });
  }

  public void addUser(Teacher teacher) {
    teachers.add(teacher);
  }

  public void removeUser(Teacher teacher) {
    teachers.remove(teacher);
  }

  public void printUsers() {
    teachers.forEach(System.out::println);
  }

  public List<String> getUserNames() {
    return teachers.stream().map(Teacher::getName).collect(Collectors.toList());
  }

  public Teacher findById(Integer id) {
    return teachers.stream()
        .filter(user -> Objects.equals(user.getId(), id))
        .findFirst()
        .orElse(null);
  }
}
