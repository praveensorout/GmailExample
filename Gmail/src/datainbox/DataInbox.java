package datainbox;
import java.sql.*;
import java.util.Date;

public class DataInbox {

	private String to;
	private String email;
	private String subj;
	private String msg;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean valid = false;
	Date d = new Date();
	String date = d.toString();
	
	public void setTo(String to)
	{
		this.to = to;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setSubj(String subj)
	{
		this.subj = subj;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getTo()
	{
		return to;
	}
	public String getEmail()
	{
		return email;
	}
	public String getSubj()
	{
		return subj;
	}
	public String getMsg()
	{
		return msg;
	}
	public String getDate()
	{
		return date;
	}
	
	public boolean addData()
	{
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps = con.prepareStatement("select receiver from praveen_compose where receiver=?");
			ps.setString(1,to);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(email.equals(rs.getString("receiver")))
				{
					valid = true;
				}
			}
			if(!valid)
			{
				ps = con.prepareStatement("insert into praveen_compose(receiver,sender,subject,message,date) values (?,?,?,?,?)");
				ps.setString(1,to);
				ps.setString(2,email);
				ps.setString(3,subj);
				ps.setString(4,msg);
				ps.setString(5,date);
				ps.executeUpdate();
				
				ps = con.prepareStatement("insert into praveen_sent(receiver,sender,subject,message,date) values (?,?,?,?,?)");
				ps.setString(1,to);
				ps.setString(2,email);
				ps.setString(3,subj);
				ps.setString(4,msg);
				ps.setString(5,date);
				ps.executeUpdate();
			}
		}
			catch(SQLException e){System.out.print(e);}
			catch(ClassNotFoundException e){System.out.print(e);}
			return valid;
	}
	
	public boolean savedraft()
	{
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps = con.prepareStatement("select * from praveen_draft where sender=?");
			ps.setString(1,to);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(email.equals(rs.getString("receiver")))
				{
					valid = true;
				}
			}
			if(!valid)
			{
				ps = con.prepareStatement("insert into praveen_draft(receiver,sender,subject,message,date) values (?,?,?,?,?)");
				ps.setString(1,to);
				ps.setString(2,email);
				ps.setString(3,subj);
				ps.setString(4,msg);
				ps.setString(5,date);
				ps.executeUpdate();
			}
		}
			catch(SQLException e){System.out.print(e);}
			catch(ClassNotFoundException e){System.out.print(e);}
			return valid;
	}
	
	public ResultSet inbox()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps= con.prepareStatement("select * from praveen_compose where receiver= ?");
			ps.setString(1,email);
			rs=ps.executeQuery();
			
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
		return rs;
	}
	
	public ResultSet sent()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps= con.prepareStatement("select * from praveen_compose where sender= ?");
			ps.setString(1,email);
			rs=ps.executeQuery();
			
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
		return rs;
	}
	
	public ResultSet draft()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///praveen","root","root123");
			ps= con.prepareStatement("select * from praveen_draft where sender= ?");
			ps.setString(1,email);
			rs=ps.executeQuery();
			
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
		return rs;
	}
}
