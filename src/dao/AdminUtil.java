package dao;

import conn.JdbcConn;
import model.Student;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminUtil {

    //connectToDb to connect to database
    private static Connection connectToDb() {
        return JdbcConn.getInstance().getConnection();
    }

    //creating a table using execute statement
    public static boolean createstudenttable() throws SQLException {
        Statement stmt = connectToDb().createStatement();
        return !stmt.execute("CREATE TABLE IF NOT EXISTS admin(id int primary key auto_increment,username varchar(20),password varchar(10) ,_role varchar(10));");
    }

    //updating a record in a table
    public static String updateReco(int id) throws SQLException {
        PreparedStatement stmt = connectToDb().prepareStatement("update user SET grant_access=1 where user_id=?");
        stmt.setInt(1,id);
        int rs = stmt.executeUpdate();
        return rs>0?"record updated ":" updation failed";
    }
}
