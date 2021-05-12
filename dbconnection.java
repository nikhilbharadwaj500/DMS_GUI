
import java.sql.*;
import java.sql.SQLException;
public class dbconnection
{
	public static void main(String[] args)
	{
		String url       = "jdbc:mysql://localhost:3306/";
		String user      = "root";
		String passwd    = "";


		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection(url, user, passwd);
			
			Statement stmt=(Statement) con.createStatement(); 
			
			
			/**
             * Create and select a database for use. 
             */
            stmt.execute("CREATE DATABASE IF NOT EXISTS donor_management");
            stmt.execute("USE donor_management");
			
			String sql="insert into registered_donor(id,name,f_name,Age,Gender,Live_status,Blood_group,Organ_type,phone,email,address) values ('1','nikhil','Swamy',22,'M','Alive','B+','Eyes','9632742482','nikhil@gmail.com','Bangalore') ";
			
			stmt.executeUpdate(sql);
			
			
			ResultSet rs=stmt.executeQuery("select * from donor");
			
			while(rs.next())  
				System.out.println(+rs.getInt("id")+" , "+rs.getString("name")+" , "+rs.getString("f_name")+" , "+rs.getInt("Age")+","+rs.getString("Gender"));  
				con.close();  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}