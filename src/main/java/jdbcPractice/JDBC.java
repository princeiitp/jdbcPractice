package jdbcPractice;
import java.sql.*;

public class JDBC {

	
	
	public static void main(String args[]) throws Exception {  
		
	  			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDB","root","87573471");  
			
			Statement stmt=con.createStatement();
			
			
			
			
			insertInTable(stmt);
			
			System.out.println("\nTable before truncate\n");
			fetchWholeTable(stmt);
			
			
			updateTableRows(stmt);
			
			deleteTableData(stmt);
			
			
			String truncateQuery = "truncate table testTable";
			stmt.executeUpdate(truncateQuery);
			
			
			System.out.println("\nTable after truncate\n");
			fetchWholeTable(stmt);
		
			stmt.close();
			con.close();  
		
		   
		
	}  
	
   public static void deleteTableData(Statement stmt) throws Exception {
		
		String deleteQuery = "delete from testTable where name = 'gopal' ";
		
		int rowsAffected = stmt.executeUpdate(deleteQuery);
		
		System.out.println(rowsAffected + " rows Affected");
		
		
	}
	
	public static void updateTableRows(Statement stmt) throws Exception {
		
		String updateQuery = "update testTable set age = 14 where name = 'rishi' ";
		
		int rowsAffected = stmt.executeUpdate(updateQuery);
		
		System.out.println(rowsAffected + " rows Affected");
		
		
	}
	
	public static void insertInTable(Statement stmt) throws Exception {
		
		String insertQuery = "insert into testTable values(11,'Prince',22),(12,'rishi',23),(66,'rathore',23)";
		
		int rowsAffected = stmt.executeUpdate(insertQuery);
		
		System.out.println(rowsAffected + " rows Affected");
					
		
	}
	
	public static  void fetchWholeTable(Statement stmt) throws Exception {
		
		String executeQuery = "select * from testTable";	
		
		ResultSet rs = stmt.executeQuery(executeQuery); 
		
		while(rs.next())
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
		
	}
	
	
	
 }
