package dao;

import conn.JdbcConn;
import model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class StudentUtil {

    //connectToDb to connect to database
    private static Connection connectToDb() {
        return JdbcConn.getInstance().getConnection();
    }

    //creating a table using execute statement
    public static boolean createstudenttable() throws SQLException {
            Statement stmt = connectToDb().createStatement();
            return !stmt.execute("CREATE TABLE IF NOT EXISTS details(stu_id int primary key auto_increment,Stud_Name varchar(20),Stud_course varchar(15),Stu_age int);");
    }

    //insertion a record in a table using prepared statements
    public static String saveReco(Student st) throws SQLException {
            PreparedStatement stmt = connectToDb().prepareStatement("insert into details(stu_id , Stud_Name,Stud_course,Stu_age) values (?,?,?,?)");
            stmt.setInt(1, st.getId());
            stmt.setString(2, st.getName());
            stmt.setString(3, st.getCourse());
            stmt.setInt(4, st.getAge());
            int rs = stmt.executeUpdate();
            return "record created " + rs;
    }

    //updating a record in a table
    public static String updateReco(Student st) throws SQLException {
            PreparedStatement stmt = connectToDb().prepareStatement("update details SET stu_age=20 where stu_id=?");
            stmt.setInt(1,st.getId());
            int rs = stmt.executeUpdate();
            return "record updated" + rs;
    }

    //deletion from table based on searched id
    public static String deleteById(int id) throws SQLException {
            PreparedStatement preparedStatement = connectToDb().prepareStatement("delete from details where stu_id=?");
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            if (rs >= 1) {
                return "Record deleted with id: " + id;
            } else {
                return "record not found";
            }
    }

    //insertion into table using stored procedure
    public static String insertsecpro(Student stu) throws SQLException {
            CallableStatement call = connectToDb().prepareCall("Call newRec(?,?,?,?);");
            call.setInt(1,stu.getId());
            call.setString(2,stu.getName());
            call.setString(3, stu.getCourse());
            call.setInt(4,stu.getAge());
            return call.executeUpdate()>0?"insertion successful":"insertion failed";
    }

//show all data of table using executeQuery
public static ResultSet showAllrec(Student st) throws SQLException {
    CallableStatement call = connectToDb().prepareCall("select * from details;");
    ResultSet resultSet = call.executeQuery();
    while(resultSet.next()){
        System.out.println(resultSet.getInt("stu_id")+"\t"+resultSet.getString("Stud_Name")+"\t"+resultSet.getString("Stud_course")+"\t"+resultSet.getInt("Stu_age"));
    }
    return resultSet;
    }

//retrives the data according to id searched using stored procedure and executeQuery
    public static ResultSet showrec(Student st) throws SQLException {
            CallableStatement cstmt = connectToDb().prepareCall("call showRec(?)");
            cstmt.setInt(1,st.getId());

            ResultSet resultSet = cstmt.executeQuery();

            while(resultSet.next()){
                System.out.println("\n Name : "+resultSet.getString("stud_Name")+"\n course : "+resultSet.getString("stud_course")+"\n Age : "+resultSet.getInt("stu_age"));
            }
            return resultSet;
    }

    //batch operation to insert multiple records
    public static int batchinsert(List<Student> st) throws SQLException {
            Connection con = connectToDb();
            con.setAutoCommit(false);
            PreparedStatement p = con.prepareStatement("insert into details values(?,?,?,?,?);");
            int[] rec = null;
            for(Student student : st){
                p.setInt(1,student.getId());
                p.setString(2,student.getName());
                p.setString(3,student.getCourse());
                p.setInt(4,student.getAge());
                p.setString(5,null);
                p.addBatch();
            }
             rec = p.executeBatch();
            con.commit();
            return rec.length;
    }

    public static String uploadPic(File f,int id) throws SQLException, IOException {
        PreparedStatement psmt = connectToDb().prepareStatement("update details set photo = ? where stu_id = ?;");
        FileInputStream fis = new FileInputStream(f);
//        psmt.setBlob(1,fis);
        psmt.setBinaryStream(1,fis,fis.available());
        psmt.setInt(2,id);

        return psmt.executeUpdate()>=1?"record updated":"not uploaded";

    }
}