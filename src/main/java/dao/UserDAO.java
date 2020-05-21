package dao;

import libs.DbConnection;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDAO implements DAO<User> {
    private List<User> users;

    public UserDAO() {
        read();
    }

    @Override
    public void read() {
        users = new LinkedList<>();
        try {
            Connection conn = DbConnection.getConnection();
            final String SQLQ = "SELECT * FROM users";
            PreparedStatement preparedStatement = conn.prepareStatement(SQLQ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("email"),
                        resultSet.getString("password"), resultSet.getString("username"),
                        resultSet.getString("job"), resultSet.getString("imgurl")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getDatabase() {
        return users;
    }


    @Override
    public List<Integer> getAllId() {
        read();
        List<Integer> result = new LinkedList<>();
        users.forEach(user -> result.add(user.getId()));
        return result;
    }

    @Override
    public void clear() throws SQLException {
        Connection connection = DbConnection.getConnection();
        final String SQLQ = "DELETE FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQ);
        preparedStatement.executeUpdate();
        users = new LinkedList<>();
    }

    @Override
    public void add(User user) {
        try {
            Connection conn = DbConnection.getConnection();
            final String SQLQ = "INSERT INTO users (email, password, username, job, imgurl) values (?,?,?,?,?)";
            PreparedStatement insertUser = conn.prepareStatement(SQLQ);
            insertUser.setString(1, user.getEmail());
            insertUser.setString(2, user.getPassword());
            insertUser.setString(3, user.getUsername());
            insertUser.setString(4, user.getJob());
            if (user.getImgURL().equals(""))
                insertUser.setString(5, "https://robohash.org/24.218.243.26.png");
            else
                insertUser.setString(5, user.getImgURL());


            insertUser.executeUpdate();
            users.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) {
        return stream().filter(oneUser -> oneUser.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public Stream<User> stream() {
        return users.stream();
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}
