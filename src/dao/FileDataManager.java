package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileDataManager<T> {

  private final String fileName;

  public FileDataManager(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public List<T> getData(Function<String, List<T>> function) {
    List<T> data = getDataFromFile(function);
    if (data.isEmpty()) {
      System.out.println("No users found");
      throw new RuntimeException("No users found");
    }
    return data;
  }

  private List<T> getDataFromFile(Function<String, List<T>> function) {
    return function.apply(fileName);
  }
}
