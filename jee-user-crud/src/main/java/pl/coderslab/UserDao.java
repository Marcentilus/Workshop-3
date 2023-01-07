package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO WORKSHOP_3.Users(username, email, password) VALUES (?, ?,?)";
    private static final String READ_USER_QUERY = "Select * from WORKSHOP_3.Users where id = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE WORKSHOP_3.Users set username = ?, email = ?, password =? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM WORKSHOP_3.Users where id = ?";
    private static final String FINDALL_USER_QUERY = "Select * from WORKSHOP_3.Users";

    public static void main(String[] args) {

    }

    public User create(User user) {
        try (Connection connection = DBUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, hashPassword(user.getPassword()));
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User read(int userId){
        User user = new User();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, userId);
            try(ResultSet rs = statement.executeQuery()) {
                while (rs.next()){
                    // System.out.println(rs.getString("username") + " " + rs.getString("email") + " " + rs.getString("password"));
                    user.setId(userId);
                    user.setUserName(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    public void update(User user){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, hashPassword(user.getPassword()));
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(int userId){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public User[] findAll(){
        User[] users = new User[0];
        int counter = 1;
        try(Connection connection = DBUtil.getConnection()){
            Statement statement= connection.createStatement();
            try(ResultSet rs = statement.executeQuery(FINDALL_USER_QUERY)) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    users = addToArray(user, users);
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }


    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public User[] addToArray(User u, User[] users){
        User[] tmpUsers = Arrays.copyOf(users, users.length +1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }
}
