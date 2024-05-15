package jdbc;

import servlets.LabCRUDInterface;
import users.User1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements LabCRUDInterface<User1> {

    Connection connection;

    public SqlCRUD(){
        this.connection = new Connect().getCon();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User1 user) {
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO entity (name,age) VALUES (?,?)")) {
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User1> read() {
        List<User1> list = new ArrayList<>();
        try (
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM entity;")
        ) {
            while (rs.next()) {
                list.add(new User1(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, User1 user) {
        try (PreparedStatement st = connection.prepareStatement("UPDATE entity SET \"name\"=?, \"age\"=? WHERE id=?;")) {
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());
            st.setInt(3, id);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection.prepareStatement("DELETE FROM entity WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
