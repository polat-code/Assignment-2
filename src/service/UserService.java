package service;

import entity.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService {

    private final List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public static Function<String, List<User>> getReadFromFileFunction() {
        return (fileName -> {
            List<User> users = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] lineProperties = line.split(" ");
                    users.add(
                            new User(
                                    Integer.parseInt(lineProperties[0]),
                                    lineProperties[1],
                                    lineProperties[2]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users;
        });

    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void printUsers() {
        users.forEach(System.out::println);
    }

    public List<String> getUserNames() {
        return users.stream().map(User::getName).collect(Collectors.toList());
    }


    public User findById(long id) {
        return users.stream().filter(user ->user.getId() == id).findFirst().orElse(null);
    }
}
