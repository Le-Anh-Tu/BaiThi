package dao.student;

import dao.IGeneralDao;

import model.Student;

import java.util.List;

public interface IStudentDao extends IGeneralDao<Student> {
    List<Student> searchStudentByName(String name);
}
