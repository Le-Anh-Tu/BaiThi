package service.classroom;


import dao.category.ClassroomDao;
import dao.category.IClassroomDao;
import model.Classroom;

import java.util.List;

public class ClassroomService implements IClassroomService {
    IClassroomDao classroomDao = new ClassroomDao();

    @Override
    public List<Classroom> show() {
        return classroomDao.show();
    }

    @Override
    public boolean create(Classroom classroom) {
        return false;
    }

    @Override
    public boolean update(int id, Classroom classroom) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Classroom findById(int id) {
        return classroomDao.findById(id);
    }
}
