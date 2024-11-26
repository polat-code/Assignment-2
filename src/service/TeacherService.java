package service;

import entity.Teacher;
import entity.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TeacherService{

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
                                    Integer.parseInt(lineProperties[0]),
                                    lineProperties[1],
                                    lineProperties[2]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return teachers;
        });

    }
}
