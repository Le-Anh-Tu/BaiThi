package dao.category;

import dao.DBConnection;
import dao.IGeneralDao;

import model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDao implements IClassroomDao {
    public static final String FIND_CATEGORY_BY_ID = "SELECT * FROM classroom WHERE id = ?";
    public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM classroom";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Classroom> show() {
        List<Classroom> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Classroom(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
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
        Classroom classroom = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_CATEGORY_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int keyId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classroom = new Classroom(keyId, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

}
