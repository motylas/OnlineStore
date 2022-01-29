import java.sql.*;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws Exception{
      Connection con = null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost/programs", "root", "");
          System.out.println("Xampp Mysql Connected..");
          Statement stat = con.createStatement();
          //stat.executeUpdate("CREATE DATABASE PROGRAMS");
          ResultSet rs = stat.executeQuery("SELECT * FROM programs JOIN xyz ON programs.id = xyz.id");
          while(rs.next()){
              String name = rs.getString("name");
              String siema = rs.getString("siema");
              System.out.println(name + " " + siema);
          }
          //System.out.println("database created...");
      } catch(Exception e){
          System.out.println(e.getMessage());
      }
    }
}