package service.student;

import model.Student;
import service.IGeneralService;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    List<Student> searchProductByName(String name);
}
