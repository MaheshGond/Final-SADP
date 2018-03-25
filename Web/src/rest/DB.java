package rest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {

	String myDriver;
	String myUrl;
	Connection conn;
	String query;
	Statement st;
	ResultSet rs;
	login_check c = new login_check();
	public DB()
    {
        try
        {
            
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/test";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String query = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                String usertype = rs.getString("usertype");
                String username = rs.getString("username");
                String psw = rs.getString("psw");
                System.out.format("%s, %s, %s\n", usertype, username,psw);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
