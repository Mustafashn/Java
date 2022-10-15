
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Employees {
   private Connection con = null;
   private Statement statement = null;
   private PreparedStatement preparedStatement = null;
   
   public Employees () {
       //jdbc:mysql://localhost:3306/companyemployees
       String url ="jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.db_name+"?useUnicode=true&characterEncoding=utf8";
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           
           con =DriverManager.getConnection(url,Database.userName, Database.password);
           
            
        } catch (SQLException ex) {
            System.out.println("Sql connection failed.");
        }
     
   }
   public boolean login(String userName,String password) {
       String query ="Select * from adminler where username = ? and password = ?";
       
       try {
           preparedStatement = con.prepareStatement(query);
           preparedStatement.setString (1,userName);
           preparedStatement.setString(2,password);
           ResultSet rs = preparedStatement.executeQuery();
           
           return rs.next();
       } catch (SQLException ex) {
           Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
            return false;
       }
     
   }
   public ArrayList<Employee> getEmployee() {
    ArrayList<Employee> calisan = new ArrayList<Employee>();
       try {
           statement = con.createStatement();
           String query = "Select * from calisanlar";
           ResultSet rs = statement.executeQuery(query);
           while (rs.next()) {
               int id= rs.getInt("id");
               String name =rs.getString("ad");
               String surname =rs.getString("soyad");
               String departmant =rs.getString("departman");
               String salary =rs.getString("maas");
               calisan.add(new Employee(id, name,surname, departmant, salary));
           }
           return calisan;
       } catch (SQLException ex) {
           Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    
}
   public void addEmployee(String name,String surname,String department,String salary) {
       try {
           String query = "insert into calisanlar(ad,soyad,departman,maas) values (?,?,?,?)";
           preparedStatement = con.prepareStatement(query);
           preparedStatement.setString(1, name);
           preparedStatement.setString(2, surname);
           preparedStatement.setString(3, department);
           preparedStatement.setString(4, salary);
           preparedStatement.executeUpdate();
           
       } catch (SQLException ex) {
           Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
       }
        
   }
   public void deleteEmployee(int id) {
       
       try {
           String query = "Delete from calisanlar where id = ?";
           preparedStatement  =con.prepareStatement(query);
           preparedStatement.setInt(1,id);
           preparedStatement.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
   }
   public void updateEmployee(String name,String surname,String department,String salary,int id) {
       try {
            String query ="Update calisanlar set ad = ? , soyad = ? , departman = ? , maas = ? where id = ?";   
            preparedStatement =con.prepareStatement(query);
            preparedStatement = con.prepareStatement(query);
           preparedStatement.setString(1, name);
           preparedStatement.setString(2, surname);
           preparedStatement.setString(3, department);
           preparedStatement.setString(4, salary);
           preparedStatement.setInt(5, id);
           preparedStatement.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
