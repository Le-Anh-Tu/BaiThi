package dao.student;

import dao.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {
    public static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
    public static final String CREATE_NEW_STUDENT = "INSERT INTO student (name, address, phoneNumber, email, classroomId) VALUES (?,?,?,?,?)";
    public static final String SEARCH_STUDENT_BY_NAME = "SELECT * FROM student WHERE name like ?";
    public static final String FIND_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    public static final String UPDATE_STUDENT_BY_ID = "UPDATE student SET name = ?, address = ?, phoneNumber = ?, email = ?, classroomId = ? WHERE id = ?";
    public static final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Student> show() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("classroomId");
                students.add(new Student(id, name, address, phoneNumber, email, classroomId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean create(Student student) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_NEW_STUDENT);
            statement.setString(1, student.getName());
            statement.setString(2, student.getAddress());
            statement.setString(3, student.getPhoneNumber());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getClassroomId());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, Student student) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
            statement.setString(1, student.getName());
            statement.setString(2, student.getAddress());
            statement.setString(3, student.getPhoneNumber());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getClassroomId());
            statement.setInt(6, id);
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_BY_ID);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_STUDENT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("classroomId");
                student = new Student( id, name, address, phoneNumber, email, classroomId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SEARCH_STUDENT_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int classroomId = resultSet.getInt("classroomId");
                students.add(new Student(id, name1, address, phoneNumber, email, classroomId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
