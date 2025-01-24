package GlobalExceptionHandler;
import dao.AdminUtil;
import dao.StudentUtil;
import dao.UserUtil;
import model.Student;
import model.User;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class ExceptionHandler {
    public static void createtable(){
        try{
            StudentUtil.createstudenttable();
            System.out.println(AdminUtil.createstudenttable());
//            System.out.println(UserUtil.createstudenttable());
        }catch(SQLException e){
            System.out.println("table not created : "+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void save(Student st){
        try{
            System.out.println(StudentUtil.saveReco(st));;
        }catch(SQLException e){
            System.out.println("insertion failed :" + e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void update(Student st){
        try{
            System.out.println(StudentUtil.updateReco(st));
        }catch(SQLException e){
            System.out.println("Updation failed : "+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try{
            System.out.println(StudentUtil.deleteById(id));
        }catch(SQLException e){
            System.out.println("deletion failed : "+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void savepro(Student st){
        try{
            System.out.println(StudentUtil.insertsecpro(st));
        }catch(SQLException e){
            System.out.println("insertion failed using stored procedure :" + e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void display(Student st){
        try{
            StudentUtil.showAllrec(st);
        }catch(SQLException e){
            System.out.println(" records fetching failed : " +e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  static void searchbyid(Student st){
        try{
            StudentUtil.showrec(st);
        }catch(SQLException e){
            System.out.println(" Searching failed :"+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void batchinsertion(List<Student> st){
        try{
            System.out.println(StudentUtil.batchinsert(st));
        }catch(SQLException e){
            System.out.println("insertion failed :"+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  static void upload(File file , int id){
        try{
            System.out.println(StudentUtil.uploadPic(file,id));
        }catch(SQLException e){
            System.out.println("uploading failed : "+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void register_user(User u){
        try{
            System.out.println(UserUtil.registerUser(u));
        }catch(SQLException e){
            System.out.println("registration failed :"+e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteuserById(int id){
        try{
            System.out.println(UserUtil.deleteuserById(id));
        }catch(SQLException e){
            System.out.println("deletion failed : "+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void aproveuser(int id){
        try{
            System.out.println(AdminUtil.updateReco(id));
        }catch(SQLException e){
            System.out.println("access approved : "+e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
