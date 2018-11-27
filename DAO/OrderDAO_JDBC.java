import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class OrderDAO_JDBC implements OrderDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public OrderDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
	@Override
	public void changestatus(Order order,String newstatus){
		Order o = new Order();
		String sql;
		Statement stmt= null;
		PreparedStatement preparedStatement = null;
		try{
			stmt = dbConnection.createStatement();
			sql = "update customer_order set status=? where order_id=?";
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, newstatus);
			preparedStatement.setInt(2, order.getId());
			preparedStatement.executeUpdate();
			System.out.println("status changed to "+newstatus);
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record

	}

}