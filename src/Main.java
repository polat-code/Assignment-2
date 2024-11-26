import dao.FileDataManager;
import entity.User;
import service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileDataManager<User> fileDataManager = new FileDataManager<>("students.txt");

        List<User> users = fileDataManager.getData(UserService.getReadFromFileFunction());
        UserService userService = new UserService(users);

        // Print id and name
        userService.printUsers();
        List<String> userNames = userService.getUserNames();

        // Print only names
        userNames.forEach(System.out::println);

        // Update names
        //userManager.addUser(new User(fileDataManager.getAndIncrementIdCounter(),"Ahmet"));
        //userManager.addUser(new User(fileDataManager.getAndIncrementIdCounter(),"Fatih"));
        System.out.println();
        System.out.println("Updated List");
        userService.printUsers();

        System.out.println("Found entity.User : " + userService.findById(2));

    }
}