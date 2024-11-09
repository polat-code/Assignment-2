import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    private final List<User> users;

    public UserManager(List<User> users) {
        this.users = users;
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
