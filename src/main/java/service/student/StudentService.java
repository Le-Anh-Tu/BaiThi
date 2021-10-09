package service.student;


import dao.category.ClassroomDao;
import dao.category.IClassroomDao;
import dao.student.IStudentDao;

import dao.student.StudentDao;
import model.Classroom;
import model.Student;


import java.util.List;

public class StudentService implements IStudentService {
    IStudentDao StudentDao = new StudentDao();
    IClassroomDao classroomDao = new ClassroomDao();

    @Override
    public List<Student> show() {
            List<Student> students = StudentDao.show();
            for (Student student : students) {
                Classroom classroom = classroomDao.findById(student.getClassroomId());
                student.setClassroom(classroom);
            }
            return students;
    }

    @Override
    public boolean create(Student student) {
        return StudentDao.create(student);
    }

    @Override
    public boolean update(int id, Student student) {
        return StudentDao.update(id, student);
    }

    @Override
    public boolean delete(int id) {
        return StudentDao.delete(id);
    }

    @Override
    public Student findById(int id) {
        return StudentDao.findById(id);
    }

    @Override
    public List<Student> searchProductByName(String name) {
        name = "%" + name + "%";
        List<Student> students =  StudentDao.searchStudentByName(name);
        for (Student student : students) {
            Classroom classroom = classroomDao.findById(student.getClassroomId());
            student.setClassroom(classroom);
        }
        return students;
    }
}
