package service;

import java.util.List;
import java.util.function.Function;

public interface IService {

  Function<?, List<?>> getReadFromFileFunction();
}
