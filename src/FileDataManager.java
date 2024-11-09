import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataManager {

    private final String fileName;
    private long idCounter = 0L;
    public FileDataManager(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public List<User> getUsers() {
        List<User> users = getUsersFromFile();
        if(users.isEmpty()) {
            System.out.println("No users found");
            throw new RuntimeException("No users found");
        }
        return users;
    }
    public long getAndIncrementIdCounter() {
        return ++idCounter;
    }

    private List<User> getUsersFromFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(new User(idCounter + 1L,line));
                idCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
