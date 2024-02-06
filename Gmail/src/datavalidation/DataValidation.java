package datavalidation;
import java.sql.*;

public class DataValidation {

	private String email;
	private String fname;
	private String lname;
	private String password;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean valid = false;
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail()
	{
			return email;
	}
	public String getFname()
	{
			return fname;
	}
	public String getLname()
	{
			return lname;
	}
	public String getPassword()
	{
			return password;
	}
	
	public boolean login()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps = con.prepareStatement("select * from praveen_gmail where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(email.equals(rs.getString("email"))&& password.equals(rs.getString("password")))
				{
					valid=true;
				}
			}
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
		return valid;
	}
	
	public boolean addData()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps = con.prepareStatement("select * from praveen_gmail where email=? ");
			ps.setString(1,email);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(email.equals(rs.getString("email")))
				{
					valid=true;
				}
			}
			if(!valid)
			{
				ps = con.prepareStatement("insert into praveen_gmail values (?,?,?,?)");
				ps.setString(1,email);
				ps.setString(2,fname);
				ps.setString(3,lname);
				ps.setString(4,password);
				ps.executeUpdate();
			}
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
		return valid;
	}
}
