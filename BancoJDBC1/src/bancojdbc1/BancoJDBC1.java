package bancojdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class BancoJDBC1 {
   private Connection con;
   private Statement stmt;
    
public BancoJDBC1(){
  try{
    Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver encontrado!");
      }catch(ClassNotFoundException e){
     System.out.println("Driver não encontrado!" + e);
     System.out.println("Error: "+ e.getMessage());
     }
     String url = "jdbc:mysql://localhost:3306/Banco";
     String user = "root";
     String password = "";
  try{
    con=DriverManager.getConnection(url,user,password);
    stmt = con.createStatement();
    }catch(SQLException e){
     System.out.println("Error: "+ e.getMessage());
}
    inserirRegistros();
    listarRegistros();
   } 
 private void listarRegistros(){
     try{
     ResultSet rs;
    rs = stmt.executeQuery("SELECT * FROM Empregado");
    while ( rs.next() ) {
        int matricula = rs.getInt("matricula");
           String nome = rs.getString("nome");
           String telefone = rs.getString("telefone");
             float salario = rs.getFloat("salario");
           System.out.println(matricula + "\t" + nome + "\t" +
               telefone + "\t" + salario);
}
 }catch(SQLException e){
 System.out.println("Erro: "+ e.getMessage());
 }
     
     
     
 }
 
 private void inserirRegistros(){
   try{
 stmt.executeUpdate("INSERT INTO Empregado VALUES (5,'Evandra','6291376654','6780.00'),(6,'Evandral','6291376654','6780.00')");
    }catch(SQLException e){
      System.out.println("Error: "+ e.getMessage());
    }
 }
 public static void main(String[] args){
     BancoJDBC1 bancoJDBC1 = new BancoJDBC1();
     }
  }
  