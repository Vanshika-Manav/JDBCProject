package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConn {
    private static JdbcConn ob;
    private Connection connection;
    private final String url="jdbc:mysql://localhost:3306/db";
    private final String user="root";
    private final String pass="12345678";

    private JdbcConn()  {
        try {
            connection= DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static JdbcConn getInstance()
    {
        if (ob==null)
        {
            synchronized (JdbcConn.class)
            {
                if (ob==null){
                    ob=new JdbcConn();
                }
            }
        }
        return ob;
    }

    public Connection getConnection(){
        return connection;
    }


}
