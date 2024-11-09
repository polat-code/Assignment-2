import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FileDataManager fileDataManager = new FileDataManager("students.txt");
        List<User> users = fileDataManager.getUsers();
        UserManager userManager = new UserManager(users);

        // Print id and name
        userManager.printUsers();

        List<String> userNames = userManager.getUserNames();

        // Print only names
        userNames.forEach(System.out::println);

        // Update names
        userManager.addUser(new User(fileDataManager.getAndIncrementIdCounter(),"Ahmet"));
        userManager.addUser(new User(fileDataManager.getAndIncrementIdCounter(),"Fatih"));
        System.out.println();
        System.out.println("Updated List");
        userManager.printUsers();

        System.out.println("Found User : " + userManager.findById(5L));

    }
}