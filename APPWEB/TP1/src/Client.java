import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
static{
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			String req1="SELECT id,nom,fonction from PERSONNEL";
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@vs-oracle2:1521:ORCL", "GRP208US1", "GRP208US1");
			Statement st = conn.createStatement ();
			ResultSet plop = st.executeQuery(req1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
