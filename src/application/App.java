package application;
//import dao.StudentUtil;
import model.Student;
import GlobalExceptionHandler.ExceptionHandler;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App
{
    public static void main(String[] args) throws SQLException, IOException {

            Student student=new Student();//object of student class
            User user = new User();//object of user class
            user.getUsername("manu");
            user.getPassword("12345");
//          student.setId(129);
//          student.setCourse("java n");
//          student.setAge((byte)25);
//          student.setName("manu");


//        List<Student> listOfStudents =  new ArrayList<>();
//        Collections.addAll(listOfStudents,
//                new Student(200,"ayush","java",26),
//                new Student(220,"lucky","aws",26));

//        ExceptionHandler.createtable();
//        ExceptionHandler.save(student);
//        ExceptionHandler.update(student);
//        ExceptionHandler.delete(126);
//        ExceptionHandler.savepro(student);
//        ExceptionHandler.display(student);
//        ExceptionHandler.searchbyid(student);
//        ExceptionHandler.batchinsertion(listOfStudents);
//        ExceptionHandler.upload(new File("C:/Users/vansh/Pictures/Camera Roll/assi.jpg"),110);

//        ExceptionHandler.register_user(user);
//        ExceptionHandler.deleteuserById(4);
        ExceptionHandler.aproveuser(5);
    }



}
