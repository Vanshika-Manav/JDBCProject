package dao;

import conn.JdbcConn;
import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUtil {
    //connectToDb to connect to database
    private static Connection connectToDb() {
        return JdbcConn.getInstance().getConnection();
    }

    //insertion into table using stored procedure
    public static String registerUser(User user) throws SQLException {
        CallableStatement call = connectToDb().prepareCall("Call newUser(?,?,?);");
        call.setInt(1,user.getUser_id());
        call.setString(2,user.setUsername("manu"));
        call.setString(3, user.setPassword("12345"));
        return call.executeUpdate()>0?"insertion successful":"insertion failed";
    }

    //deletion from table based on searched id
    public static String deleteuserById(int id) throws SQLException {
        PreparedStatement preparedStatement = connectToDb().prepareStatement("delete from user where user_id=?");
        preparedStatement.setInt(1, id);
        int rs = preparedStatement.executeUpdate();
        if (rs >= 1) {
            return "Record deleted with id: " + id;
        } else {
            return "record not found";
        }
    }
}

