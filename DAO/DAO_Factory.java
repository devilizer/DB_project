import java.lang.*;
import java.sql.*;
/*
	Methods to be called in the following order:

	1. activateConnection
	2. 	Any number getDAO calls with any number of database transactions
	3. deactivateConnection
*/
public class DAO_Factory{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	// Modify the DB_URL string, userid and password depending upon the database you want to connect to 
	// In the following string, you are connecting a adatabase named "daoproject"
	static final String DB_URL = "jdbc:mysql://localhost/eshopping";
	static final String USER = "root";
	static final String PASS = "1997";

	Connection dbconnection = null;

	// You can add additional DAOs here as needed. Generally one DAO per class
	ProductDAO productDAO = null;
	Cart_itemDAO cart_itemDAO = null;
	OrderDAO orderDAO = null;

	boolean activeConnection = false;

	public DAO_Factory()
	{
		dbconnection = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception
	{
		if( activeConnection == true )
			throw new Exception("Connection already active");

		System.out.println("Connecting to database...");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnection = DriverManager.getConnection(DB_URL,USER,PASS);
			activeConnection = true;
		} catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public ProductDAO getProductDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( productDAO == null )
			productDAO = new ProductDAO_JDBC( dbconnection );

		return productDAO;
	}
	public Cart_itemDAO getCart_itemDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( cart_itemDAO == null )
			cart_itemDAO = new Cart_itemDAO_JDBC( dbconnection );
		return cart_itemDAO;
	}
	public OrderDAO getOrderDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( orderDAO == null )
			orderDAO = new OrderDAO_JDBC( dbconnection );
		return orderDAO;
	}
	public void deactivateConnection()
	{
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if( dbconnection != null ){
			try{
				dbconnection.close();
				dbconnection = null;
				productDAO = null;
			}
			catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
};

